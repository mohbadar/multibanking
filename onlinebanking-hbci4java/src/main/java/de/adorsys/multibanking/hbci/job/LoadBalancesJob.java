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

import de.adorsys.multibanking.domain.BankAccount;
import de.adorsys.multibanking.domain.exception.Message;
import de.adorsys.multibanking.domain.exception.MultibankingException;
import de.adorsys.multibanking.domain.request.TransactionRequest;
import de.adorsys.multibanking.domain.response.LoadBalancesResponse;
import de.adorsys.multibanking.domain.transaction.AbstractTransaction;
import de.adorsys.multibanking.domain.transaction.LoadBalances;
import de.adorsys.multibanking.hbci.model.HbciTanSubmit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kapott.hbci.GV.AbstractHBCIJob;
import org.kapott.hbci.GV.GVSaldoReq;
import org.kapott.hbci.GV_Result.GVRSaldoReq;
import org.kapott.hbci.passport.PinTanPassport;
import org.kapott.hbci.status.HBCIMsgStatus;
import org.kapott.hbci.structures.Konto;

import java.util.List;
import java.util.stream.Collectors;

import static de.adorsys.multibanking.domain.exception.MultibankingError.HBCI_ERROR;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class LoadBalancesJob extends ScaAwareJob<LoadBalances, LoadBalancesResponse> {

    private final TransactionRequest<LoadBalances> loadBalanceRequest;
    private AbstractHBCIJob balanceJob;

    private Konto createAccount() {
        BankAccount bankAccount = loadBalanceRequest.getTransaction().getPsuAccount();

        Konto account = new Konto();
        account.bic = bankAccount.getBic();
        account.number = bankAccount.getAccountNumber();
        account.iban = bankAccount.getIban();
        account.blz = bankAccount.getBlz();
        account.curr = bankAccount.getCurrency();
        account.country = bankAccount.getCountry();
        return account;
    }

    @Override
    public AbstractHBCIJob createJobMessage(PinTanPassport passport) {
        balanceJob = new GVSaldoReq(passport);
        balanceJob.setParam("my", createAccount());
        return balanceJob;
    }

    @Override
    TransactionRequest<LoadBalances> getTransactionRequest() {
        return loadBalanceRequest;
    }

    @Override
    String getHbciJobName(AbstractTransaction.TransactionType transactionType) {
        return GVSaldoReq.getLowlevelName();
    }

    @Override
    public LoadBalancesResponse createJobResponse(PinTanPassport passport, HbciTanSubmit tanSubmit,
                                                  List<HBCIMsgStatus> msgStatusList) {
        if (balanceJob.getJobResult().getJobStatus().hasErrors()) {
            log.error("Balance job not OK");
            throw new MultibankingException(HBCI_ERROR, balanceJob.getJobResult().getJobStatus().getErrorList().stream()
                .map(messageString -> Message.builder().renderedMessage(messageString).build())
                .collect(Collectors.toList()));
        }

        BankAccount bankAccount = loadBalanceRequest.getTransaction().getPsuAccount();

        if (balanceJob.getJobResult().isOK()) {
            bankAccount.setBalances(accountStatementMapper.createBalancesReport((GVRSaldoReq) balanceJob.getJobResult(),
                bankAccount.getAccountNumber()));
        }

        return new LoadBalancesResponse(bankAccount);
    }
}
