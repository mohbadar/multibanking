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

package de.adorsys.multibanking.hbci.model;

import de.adorsys.multibanking.domain.TanTransportType;
import lombok.Data;
import org.kapott.hbci.manager.HBCITwoStepMechanism;

/**
 * Created by alexg on 16.11.17.
 */
@Data
public class HbciTanSubmit {

    private String dialogId;
    private long msgNum;
    private String orderRef;
    private String passportState;
    private String hbciJobName; //eg. HKCCS
    private String originJobName; //"org.kapott.hbci.GV.GV" + jobname
    private String originLowLevelName; //key for hbci-300.xml
    private int originSegVersion; //segment version
    private String sepaPain;
    private HBCITwoStepMechanism twoStepMechanism;
}
