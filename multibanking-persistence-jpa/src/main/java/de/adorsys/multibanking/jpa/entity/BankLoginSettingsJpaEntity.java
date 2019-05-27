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

package de.adorsys.multibanking.jpa.entity;

import de.adorsys.multibanking.domain.BankLoginCredentialInfo;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.HashMap;

@Data
@Embeddable
public class BankLoginSettingsJpaEntity {

    private String icon;
    @Basic
    private HashMap<String, String> additional_icons;
    @Basic
    private ArrayList<BankLoginCredentialInfo> credentials;
    private String auth_type;
    @Column(length = 10000)
    private String advice;
}