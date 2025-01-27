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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.adorsys.multibanking.domain.ScaStatus;
import de.adorsys.multibanking.domain.exception.Message;
import de.adorsys.multibanking.domain.exception.MultibankingException;
import de.adorsys.multibanking.domain.response.TransactionAuthorisationResponse;
import de.adorsys.multibanking.domain.transaction.AbstractPayment;
import de.adorsys.multibanking.domain.transaction.TransactionAuthorisation;
import de.adorsys.multibanking.hbci.model.HbciConsent;
import de.adorsys.multibanking.hbci.model.HbciDialogFactory;
import de.adorsys.multibanking.hbci.model.HbciPassport;
import de.adorsys.multibanking.hbci.model.HbciTanSubmit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kapott.hbci.GV.AbstractHBCIJob;
import org.kapott.hbci.GV.GVTAN2Step;
import org.kapott.hbci.callback.AbstractHBCICallback;
import org.kapott.hbci.dialog.HBCIJobsDialog;
import org.kapott.hbci.manager.KnownTANProcess;
import org.kapott.hbci.passport.PinTanPassport;
import org.kapott.hbci.status.HBCIExecStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static de.adorsys.multibanking.domain.ScaStatus.FINALISED;
import static de.adorsys.multibanking.domain.ScaStatus.SCAMETHODSELECTED;
import static de.adorsys.multibanking.domain.exception.MultibankingError.HBCI_ERROR;
import static de.adorsys.multibanking.domain.exception.MultibankingError.INTERNAL_ERROR;

@RequiredArgsConstructor
@Slf4j
public class SubmitAuthorisationCodeJob {

    private final ScaAwareJob scaJob;

    public TransactionAuthorisationResponse sumbitAuthorizationCode(TransactionAuthorisation submitAuthorisationCode) {
        HbciTanSubmit hbciTanSubmit =
            evaluateTanSubmit((HbciConsent) submitAuthorisationCode.getOriginTransactionRequest().getBankApiConsentData());

        HbciPassport hbciPassport = createPassport(submitAuthorisationCode, hbciTanSubmit);

        HBCIJobsDialog hbciDialog = new HBCIJobsDialog(hbciPassport, hbciTanSubmit.getDialogId(),
            hbciTanSubmit.getMsgNum());

        if (hbciTanSubmit.getTwoStepMechanism().getProcess() == 1) {
            submitProcess1(hbciTanSubmit, hbciPassport, hbciDialog);
        } else {
            submitProcess2(hbciTanSubmit, hbciDialog);
        }

        HBCIExecStatus hbciExecStatus = hbciDialog.execute(false);
        if (!hbciExecStatus.isOK()) {
            hbciDialog.dialogEnd();
            throw new MultibankingException(HBCI_ERROR, hbciExecStatus.getErrorMessages().stream()
                .map(messageString -> Message.builder().renderedMessage(messageString).build())
                .collect(Collectors.toList()));
        } else {
            if (hbciTanSubmit.getHbciJobName() != null && hbciTanSubmit.getHbciJobName().equals("HKIDN")) {
                //sca for dialoginit was needed -> fints consent active, expecting response with exempted sca
                TransactionAuthorisationResponse<?> response =
                    new TransactionAuthorisationResponse<>(scaJob.execute(null, hbciDialog));
                response.setScaStatus(FINALISED);
                return response;
            }
            return createResponse(hbciPassport, hbciTanSubmit, hbciExecStatus);
        }
    }

    private void submitProcess1(HbciTanSubmit hbciTanSubmit, HbciPassport hbciPassport,
                                HBCIJobsDialog hbciDialog) {
        //1. Schritt: HKTAN <-> HITAN
        //2. Schritt: HKUEB <-> HIRMS zu HKUEB
        AbstractHBCIJob hbciJob = scaJob.createJobMessage(hbciPassport);

        if (hbciTanSubmit.getSepaPain() != null) {
            hbciJob.getConstraints().remove("_sepapain"); //prevent pain generation
            hbciJob.setLowlevelParam(hbciJob.getName() + ".sepapain", hbciTanSubmit.getSepaPain());
        }
        hbciDialog.addTask(hbciJob);
    }

    @SuppressWarnings("unchecked")
    private void submitProcess2(HbciTanSubmit hbciTanSubmit, HBCIJobsDialog hbciDialog) {
        //Schritt 1: HKUEB und HKTAN <-> HITAN
        //Schritt 2: HKTAN <-> HITAN und HIRMS zu HIUEB
        AbstractHBCIJob originJob = Optional.ofNullable(hbciTanSubmit.getOriginJobName())
            .map(originJobName -> {
                AbstractHBCIJob result = scaJob.createJobMessage(hbciDialog.getPassport());
                try {
                    result.setLlParams(objectMapper().readValue(hbciTanSubmit.getLowLevelParams(), HashMap.class));
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    throw new MultibankingException(INTERNAL_ERROR, 500, e.getMessage());
                }
                result.setSegVersion(hbciTanSubmit.getOriginSegVersion());
                return result;
            }).orElse(null);

        GVTAN2Step hktan = new GVTAN2Step(hbciDialog.getPassport(), originJob);
        hktan.setProcess(KnownTANProcess.PROCESS2_STEP2);
        Optional.ofNullable(hbciTanSubmit.getHbciJobName())
            .ifPresent(hbciSegCode -> hktan.setParam("ordersegcode", hbciSegCode));
        hktan.setParam("orderref", hbciTanSubmit.getOrderRef());
        hktan.setParam("process", hbciTanSubmit.getHktanProcess() != null ? hbciTanSubmit.getHktanProcess() : "2");
        hktan.setParam("notlasttan", "N");
        hbciDialog.addTask(hktan, false);
    }

    private TransactionAuthorisationResponse createResponse(PinTanPassport passport, HbciTanSubmit hbciTanSubmit,
                                                            HBCIExecStatus status) {
        TransactionAuthorisationResponse response =
            new TransactionAuthorisationResponse<>(scaJob.createJobResponse(passport, hbciTanSubmit,
                status.getMsgStatusList()));

        //HKIDN -> FINALISED -> further request like HKCAZ already executed
        ScaStatus scaStatus = Optional.ofNullable(hbciTanSubmit.getHbciJobName())
            .map(hbciJobName -> hbciJobName.equals("HKIDN") || scaJob.getTransactionRequest().getTransaction() instanceof AbstractPayment)
            .map(finalised -> Boolean.TRUE.equals(finalised) ? FINALISED : SCAMETHODSELECTED)
            .orElse(FINALISED);

        response.setScaStatus(scaStatus);
        return response;
    }

    private HbciTanSubmit evaluateTanSubmit(HbciConsent hbciConsent) {
        if (hbciConsent.getHbciTanSubmit() instanceof HbciTanSubmit) {
            return (HbciTanSubmit) hbciConsent.getHbciTanSubmit();
        } else {
            return deserializeTanSubmit((byte[]) hbciConsent.getHbciTanSubmit());
        }
    }

    private HbciTanSubmit deserializeTanSubmit(byte[] data) {
        try {
            return objectMapper().readValue(data, HbciTanSubmit.class);
        } catch (Exception e) {
            throw new IllegalStateException("Could not deserialize HbciTanSubmit", e);
        }
    }

    private HbciPassport createPassport(TransactionAuthorisation submitAuthorizationCode, HbciTanSubmit hbciTanSubmit) {
        Map<String, String> bpd =
            Optional.ofNullable(submitAuthorizationCode.getOriginTransactionRequest().getHbciBPD())
                .orElseGet(() -> scaJob.fetchBpd(null).getBPD());

        HbciPassport.State state = HbciPassport.State.fromJson(hbciTanSubmit.getPassportState());

        HbciPassport hbciPassport = HbciDialogFactory.createPassport(state,
            new AbstractHBCICallback() {
                @Override
                public String needTAN() {
                    return ((HbciConsent) submitAuthorizationCode.getOriginTransactionRequest().getBankApiConsentData()).getScaAuthenticationData();
                }
            });
        state.apply(hbciPassport);

        HbciConsent hbciConsent =
            (HbciConsent) submitAuthorizationCode.getOriginTransactionRequest().getBankApiConsentData();

        hbciPassport.setPIN(hbciConsent.getCredentials().getPin());
        hbciPassport.setCurrentSecMechInfo(hbciTanSubmit.getTwoStepMechanism());
        hbciPassport.setBPD(bpd);

        return hbciPassport;
    }

    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }
}
