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

import de.adorsys.multibanking.domain.request.TransactionRequest;
import de.adorsys.multibanking.domain.response.AbstractResponse;
import de.adorsys.multibanking.domain.response.PaymentResponse;
import de.adorsys.multibanking.domain.transaction.AbstractPayment;
import de.adorsys.multibanking.domain.transaction.AbstractTransaction;
import de.adorsys.multibanking.domain.transaction.SinglePayment;
import de.adorsys.multibanking.hbci.model.HbciTanSubmit;
import lombok.RequiredArgsConstructor;
import org.kapott.hbci.GV.AbstractHBCIJob;
import org.kapott.hbci.GV_Result.HBCIJobResult;
import org.kapott.hbci.passport.PinTanPassport;
import org.kapott.hbci.status.HBCIMsgStatus;

import java.util.List;

@RequiredArgsConstructor
public class TanRequestJob extends AbstractPaymentJob<AbstractPayment> {

    private final TransactionRequest<AbstractPayment> transactionRequest;

    @Override
    TransactionRequest<AbstractPayment> getTransactionRequest() {
        return transactionRequest;
    }

    @Override
    String getHbciJobName(AbstractTransaction.TransactionType transactionType) {
        return null;
    }

    @Override
    PaymentResponse createJobResponse(PinTanPassport passport, HbciTanSubmit tanSubmit,
                                       List<HBCIMsgStatus> msgStatusList) {
        PaymentResponse paymentResponse = new PaymentResponse(null);
        paymentResponse.setWarnings(collectWarnings(msgStatusList));
        return paymentResponse;
    }

    @Override
    AbstractHBCIJob getHbciJob() {
        return null;
    }

    @Override
    public String orderIdFromJobResult(HBCIJobResult paymentGV) {
        return null;
    }

    @Override
    public AbstractHBCIJob createJobMessage(PinTanPassport passport) {
        return null;
    }

}
