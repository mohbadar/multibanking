/*
 * Copyright 2018-2019 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.multibanking.hbci.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.adorsys.multibanking.domain.BankAccount;
import de.adorsys.multibanking.domain.ChallengeData;
import de.adorsys.multibanking.domain.exception.Message;
import de.adorsys.multibanking.domain.exception.MultibankingException;
import de.adorsys.multibanking.domain.request.TransactionRequest;
import de.adorsys.multibanking.domain.response.AbstractResponse;
import de.adorsys.multibanking.domain.response.AuthorisationCodeResponse;
import de.adorsys.multibanking.domain.response.UpdateAuthResponse;
import de.adorsys.multibanking.domain.transaction.AbstractTransaction;
import de.adorsys.multibanking.hbci.model.*;
import de.adorsys.multibanking.mapper.AccountStatementMapper;
import de.adorsys.multibanking.mapper.AccountStatementMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.iban4j.Iban;
import org.kapott.hbci.GV.AbstractHBCIJob;
import org.kapott.hbci.GV.GVTAN2Step;
import org.kapott.hbci.callback.AbstractHBCICallback;
import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.dialog.AbstractHbciDialog;
import org.kapott.hbci.dialog.HBCIJobsDialog;
import org.kapott.hbci.manager.*;
import org.kapott.hbci.passport.PinTanPassport;
import org.kapott.hbci.status.HBCIExecStatus;
import org.kapott.hbci.status.HBCIMsgStatus;
import org.kapott.hbci.status.HBCIStatus;
import org.kapott.hbci.structures.Konto;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.adorsys.multibanking.domain.BankApi.HBCI;
import static de.adorsys.multibanking.domain.ScaApproach.EMBEDDED;
import static de.adorsys.multibanking.domain.ScaStatus.SCAMETHODSELECTED;
import static de.adorsys.multibanking.domain.exception.MultibankingError.HBCI_ERROR;
import static de.adorsys.multibanking.domain.exception.MultibankingError.INTERNAL_ERROR;
import static de.adorsys.multibanking.hbci.model.HbciDialogType.BPD;
import static de.adorsys.multibanking.hbci.model.HbciDialogType.JOBS;

@Slf4j
public abstract class ScaAwareJob<T extends AbstractTransaction, R extends AbstractResponse> {

    static AccountStatementMapper accountStatementMapper = new AccountStatementMapperImpl();
    private static HbciDialogRequestMapper hbciDialogRequestMapper = new HbciDialogRequestMapperImpl();

    private HbciTanSubmit hbciTanSubmit = new HbciTanSubmit();
    private AuthorisationCodeResponse authorisationCodeResponse = new AuthorisationCodeResponse(hbciTanSubmit);
    private HBCIJobsDialog dialog;

    public R execute(HBCICallback hbciCallback) {
        return execute(hbciCallback, null);
    }

    R execute(HBCICallback hbciCallback, HBCIJobsDialog existingDialog) {
        this.dialog = existingDialog;
        if (this.dialog == null) {
            R jobResponse = initDialog(hbciCallback);
            if (jobResponse != null) return jobResponse; //TAN required for HKIDN
        }

        //could be null in case of empty hktan requests
        AbstractHBCIJob hbciJob = createJobMessage(dialog.getPassport());

        //hbciJobs could be null in case of tan request without corresponding hbci request (TAN verbrennen)
        boolean tan2StepRequired = hbciJob == null || dialog.getPassport().tan2StepRequired(hbciJob);

        GVTAN2Step hktan = null;
        if (tan2StepRequired) {
            hktan = prepareHbciMessagefor2FA(hbciJob);
        } else {
            //No SCA needed
            dialog.addTask(hbciJob);
        }

        HBCIExecStatus hbciExecStatus = executeTasks(dialog);

        //check for SCA is really needed after execution
        tan2StepRequired = Optional.ofNullable(hktan)
            .map(gvtan2Step -> KnownReturncode.W3076.searchReturnValue(gvtan2Step.getJobResult().getJobStatus().getRetVals()) == null
                && KnownReturncode.W3076.searchReturnValue(gvtan2Step.getJobResult().getGlobStatus().getRetVals()) == null)
            .orElse(false);

        R jobResponse = createJobResponse(dialog.getPassport(), hbciTanSubmit, hbciExecStatus.getMsgStatusList());
        if (tan2StepRequired) {
            updateTanSubmit(hbciTanSubmit, dialog, hbciJob);
            jobResponse.setAuthorisationCodeResponse(authorisationCodeResponse);
        } else {
            //sca not needed and dialog not closed
            dialog.dialogEnd();
        }

        return jobResponse;
    }

    private R initDialog(HBCICallback hbciCallback) {
        log.info("init new hbci dialog");
        PinTanPassport bpdPassport = fetchBpd(hbciCallback);

        dialog = (HBCIJobsDialog) createDialog(JOBS, hbciCallback,
            getUserTanTransportType(bpdPassport.getBankTwostepMechanisms()));

        dialog.getPassport().setBPD(bpdPassport.getBPD());

        HBCIMsgStatus dialogInitMsgStatus =
            dialog.dialogInit(((HbciConsent) getTransactionRequest().getBankApiConsentData()).isWithHktan());

        if (checkDialogInitScaRequired(dialogInitMsgStatus)) {
            log.info("HKIDN SCA required");
            R jobResponse = createJobResponse(dialog.getPassport(), hbciTanSubmit,
                Collections.singletonList(dialogInitMsgStatus));
            jobResponse.setAuthorisationCodeResponse(authorisationCodeResponse);
            return jobResponse;
        }
        return null;
    }

    private boolean checkDialogInitScaRequired(HBCIMsgStatus initMsgStatus) {
        if (!initMsgStatus.isOK()) {
            throw new MultibankingException(HBCI_ERROR, initMsgStatus.getErrorList()
                .stream()
                .map(messageString -> Message.builder().renderedMessage(messageString).build())
                .collect(Collectors.toList()));
        }

        boolean scaRequired = initMsgStatus.segStatus.getRetVals().stream()
            .anyMatch(hbciRetVal -> hbciRetVal.code.equals("0030"));

        if (scaRequired) {
            updateTanSubmit(hbciTanSubmit, dialog, createJobMessage(dialog.getPassport()));
            hbciTanSubmit.setHbciJobName("HKIDN");

            String header = "TAN2StepRes" + hbciTanSubmit.getTwoStepMechanism().getSegversion();
            dialog.getPassport().getCallback().tanChallengeCallback(initMsgStatus.getData().get(header + ".orderref")
                , initMsgStatus.getData().get(header + ".challenge"), initMsgStatus.getData().get(header +
                    ".challenge_hhd_uc"), null);
        }

        return scaRequired;
    }

    PinTanPassport fetchBpd(HBCICallback hbciCallback) {
        AbstractHbciDialog bpdDialog = createDialog(BPD, hbciCallback, null);
        bpdDialog.execute(true);
        return bpdDialog.getPassport();
    }

    private GVTAN2Step prepareHbciMessagefor2FA(AbstractHBCIJob hbciJob) {
        HBCITwoStepMechanism hbciTwoStepMechanism =
            getUserTanTransportType(dialog.getPassport().getBankTwostepMechanisms());

        if (hbciTwoStepMechanism.getProcess() == 1 && hbciJob == null) {
            throw new MultibankingException(INTERNAL_ERROR, "Tan requests without corresponding transaction not " +
                "supported with HKTAN process variant 1");
        }

        if (hbciJob == null || hbciTwoStepMechanism.getProcess() == 2) {
            return hktanProcess2(hbciTwoStepMechanism, hbciJob);
        } else {
            return hktanProcess1(hbciTwoStepMechanism, hbciJob);
        }
    }

    private void updateTanSubmit(HbciTanSubmit hbciTanSubmit, AbstractHbciDialog dialog, AbstractHBCIJob scaJob) {
        hbciTanSubmit.setOriginJobName(
            Optional.ofNullable(getTransactionRequest().getTransaction())
                .map(transaction -> getHbciJobName(transaction.getTransactionType()))
                .orElseGet(() -> getHbciJobName(null)));

        hbciTanSubmit.setPassportState(new HbciPassport.State(dialog.getPassport()).toJson());
        hbciTanSubmit.setDialogId(dialog.getDialogId());
        hbciTanSubmit.setMsgNum(dialog.getMsgnum());
        hbciTanSubmit.setTwoStepMechanism(getUserTanTransportType(dialog.getPassport().getBankTwostepMechanisms()));

        Optional.ofNullable(scaJob)
            .ifPresent(hbciJob -> {
                try {
                    hbciTanSubmit.setLowLevelParams(new ObjectMapper().writeValueAsString(scaJob.getLowlevelParams()));
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    throw new MultibankingException(INTERNAL_ERROR, 500, e.getMessage());
                }

                Optional.ofNullable(hbciJob.getPainVersion())
                    .ifPresent(painVersion -> hbciTanSubmit.setPainVersion(painVersion.getURN()));
                hbciTanSubmit.setOriginLowLevelName(hbciJob.getJobName());
                hbciTanSubmit.setOriginSegVersion(hbciJob.getSegVersion());
                hbciTanSubmit.setHbciJobName(hbciJob.getHBCICode());
            });
    }

    private AbstractHbciDialog createDialog(HbciDialogType dialogType, HBCICallback hbciCallback,
                                            HBCITwoStepMechanism twoStepMechanism) {
        HBCICallback callback = createCallback(hbciCallback);
        HbciDialogRequest dialogRequest = createDialogRequest(callback);

        return HbciDialogFactory.createDialog(dialogType, null, dialogRequest, twoStepMechanism);
    }

    private HBCIExecStatus executeTasks(AbstractHbciDialog dialog) {
        HBCIExecStatus execStatus = dialog.execute(false);
        if (!execStatus.isOK()) {
            throw new MultibankingException(HBCI_ERROR, execStatus.getErrorMessages()
                .stream()
                .map(messageString -> Message.builder().renderedMessage(messageString).build())
                .collect(Collectors.toList()));
        }
        return execStatus;
    }

    private GVTAN2Step hktanProcess1(HBCITwoStepMechanism hbciTwoStepMechanism, AbstractHBCIJob hbciJob) {
        GVTAN2Step hktan = new GVTAN2Step(dialog.getPassport(), hbciJob);
        hktan.setProcess(KnownTANProcess.PROCESS1);
        hktan.setSegVersion(hbciTwoStepMechanism.getSegversion());

        if (dialog.getPassport().tanMediaNeeded()) {
            hktan.setParam("tanmedia", getConsent().getSelectedMethod().getMedium());
        }

        //1. Schritt: HKTAN <-> HITAN
        //2. Schritt: HKUEB <-> HIRMS zu HKUEB
        hktan.setParam("notlasttan", "N");
        hktan.setParam("orderhash", hbciJob.createOrderHash(hbciTwoStepMechanism.getSegversion()));

        // wenn needchallengeklass gesetzt ist:
        if (StringUtils.equals(hbciTwoStepMechanism.getNeedchallengeklass(), "J")) {
            ChallengeInfo cinfo = ChallengeInfo.getInstance();
            cinfo.applyParams(hbciJob, hktan, hbciTwoStepMechanism);
        }

        hbciTanSubmit.setSepaPain(hbciJob.getRawData());

        dialog.addTask(hktan, false);
        return hktan;
    }

    private GVTAN2Step hktanProcess2(HBCITwoStepMechanism hbciTwoStepMechanism, AbstractHBCIJob hbciJob) {
        GVTAN2Step hktan = new GVTAN2Step(dialog.getPassport(), hbciJob);
        hktan.setProcess(KnownTANProcess.PROCESS2_STEP1);
        hktan.setSegVersion(hbciTwoStepMechanism.getSegversion());

        if (dialog.getPassport().tanMediaNeeded()) {
            hktan.setParam("tanmedia", getConsent().getSelectedMethod().getMedium());
        }

        //Schritt 1: HKUEB und HKTAN <-> HITAN
        //Schritt 2: HKTAN <-> HITAN und HIRMS zu HIUEB
        hktan.setParam("orderaccount", getPsuKonto(dialog.getPassport()));
        Optional.ofNullable(hbciJob)
            .map(AbstractHBCIJob::getHBCICode)
            .ifPresent(hbciCode -> hktan.setParam("ordersegcode", hbciCode));

        Optional<HBCIMessage> messages = Optional.ofNullable(hbciJob)
            .map(dialog::addTask);

        if (messages.isPresent()) {
            messages.get().append(hktan);
        } else {
            dialog.addTask(hktan);
        }

        return hktan;
    }

    Konto getPsuKonto(PinTanPassport passport) {
        return getPsuAccount()
            .map(account -> {
                Konto konto = passport.findAccountByAccountNumber(Iban.valueOf(account.getIban()).getAccountNumber());
                konto.iban = account.getIban();
                konto.bic = Optional.ofNullable(account.getBic())
                    .orElse(HBCIUtils.getBankInfo(konto.blz).getBic());
                return konto;
            })
            .orElseGet(() -> passport.getAccounts().get(0));
    }

    private Optional<BankAccount> getPsuAccount() {
        return Optional.ofNullable(getTransactionRequest().getTransaction().getPsuAccount());
    }

    private HBCITwoStepMechanism getUserTanTransportType(Map<String, HBCITwoStepMechanism> bpdScaMethods) {
        return Optional.ofNullable(getConsent().getSelectedMethod())
            .map(tanTransportType -> bpdScaMethods.get(tanTransportType.getId()))
            .map(hbciTwoStepMechanism -> {
                hbciTwoStepMechanism.setMedium(getConsent().getSelectedMethod().getMedium());
                return hbciTwoStepMechanism;
            })
            .orElseGet(() -> {
                HBCITwoStepMechanism hbciTwoStepMechanism = new HBCITwoStepMechanism();
                hbciTwoStepMechanism.setSecfunc("999");
                hbciTwoStepMechanism.setSegversion(6);
                hbciTwoStepMechanism.setProcess(2);
                hbciTwoStepMechanism.setId("999");
                return hbciTwoStepMechanism;
            });
    }

    private HBCICallback createCallback(HBCICallback hbciCallback) {
        return new AbstractHBCICallback() {

            @Override
            public void tanChallengeCallback(String orderRef, String challenge, String challengeHhdUc,
                                             HHDVersion.Type type) {
                //needed later for submitAuthorizationCode
                hbciTanSubmit.setOrderRef(orderRef);

                UpdateAuthResponse updateAuthResponse = new UpdateAuthResponse();
                updateAuthResponse.setBankApi(HBCI);
                updateAuthResponse.setScaStatus(SCAMETHODSELECTED);
                updateAuthResponse.setScaApproach(EMBEDDED);
                authorisationCodeResponse.setUpdateAuthResponse(updateAuthResponse);

                ChallengeData challengeData = new ChallengeData();
                challengeData.setAdditionalInformation(challenge);
                updateAuthResponse.setChallenge(challengeData);

                if (challengeHhdUc != null) {
                    MatrixCode matrixCode = MatrixCode.tryParse(challengeHhdUc);
                    if (matrixCode != null)
                        challengeData.setImage(new String(matrixCode.getImage(), StandardCharsets.ISO_8859_1));
                    else
                        challengeData.setData(Collections.singletonList(challengeHhdUc));
                }
            }

            @Override
            public void status(int statusTag, Object o) {
                Optional.ofNullable(hbciCallback)
                    .ifPresent(callback -> callback.status(statusTag, o));
            }

            @Override
            public void status(int statusTag, Object[] o) {
                Optional.ofNullable(hbciCallback)
                    .ifPresent(callback -> callback.status(statusTag, o));
            }
        };
    }

    List<String> collectWarnings(List<HBCIMsgStatus> msgStatusList) {
        return Optional.ofNullable(msgStatusList)
            .map(list -> list.isEmpty() ? null : list.get(0))
            .map(status -> status.segStatus)
            .map(HBCIStatus::getWarnings)
            .map(list -> list.stream().map(retVal -> retVal.code))
            .orElse(Stream.empty())
            .collect(Collectors.toList());
    }

    private HbciDialogRequest createDialogRequest(HBCICallback hbciCallback) {
        return hbciDialogRequestMapper.toHbciDialogRequest(getTransactionRequest(), hbciCallback);
    }

    private HbciConsent getConsent() {
        return (HbciConsent) getTransactionRequest().getBankApiConsentData();
    }

    public abstract AbstractHBCIJob createJobMessage(PinTanPassport passport);

    abstract TransactionRequest<T> getTransactionRequest();

    abstract String getHbciJobName(AbstractTransaction.TransactionType transactionType);

    abstract R createJobResponse(PinTanPassport passport, HbciTanSubmit tanSubmit, List<HBCIMsgStatus> msgStatusList);

}
