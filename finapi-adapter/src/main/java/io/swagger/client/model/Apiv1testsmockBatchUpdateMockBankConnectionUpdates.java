/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.20.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Apiv1testsmockBatchUpdateMockAccountsData;
import java.util.ArrayList;
import java.util.List;

/**
 * Data for a mock bank connection update
 */
@ApiModel(description = "Data for a mock bank connection update")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class Apiv1testsmockBatchUpdateMockBankConnectionUpdates {
  @SerializedName("bankConnectionId")
  private Long bankConnectionId = null;

  @SerializedName("simulateBankLoginError")
  private Boolean simulateBankLoginError = false;

  @SerializedName("mockAccountsData")
  private List<Apiv1testsmockBatchUpdateMockAccountsData> mockAccountsData = new ArrayList<Apiv1testsmockBatchUpdateMockAccountsData>();

  public Apiv1testsmockBatchUpdateMockBankConnectionUpdates bankConnectionId(Long bankConnectionId) {
    this.bankConnectionId = bankConnectionId;
    return this;
  }

   /**
   * Bank connection identifier
   * @return bankConnectionId
  **/
  @ApiModelProperty(example = "null", required = true, value = "Bank connection identifier")
  public Long getBankConnectionId() {
    return bankConnectionId;
  }

  public void setBankConnectionId(Long bankConnectionId) {
    this.bankConnectionId = bankConnectionId;
  }

  public Apiv1testsmockBatchUpdateMockBankConnectionUpdates simulateBankLoginError(Boolean simulateBankLoginError) {
    this.simulateBankLoginError = simulateBankLoginError;
    return this;
  }

   /**
   * Whether to simulate the case that the update fails due to incorrect banking credentials. Note that there is no real communication to any bank server involved, so you won't lock your accounts when enabling this flag. Default value is 'false'.
   * @return simulateBankLoginError
  **/
  @ApiModelProperty(example = "null", value = "Whether to simulate the case that the update fails due to incorrect banking credentials. Note that there is no real communication to any bank server involved, so you won't lock your accounts when enabling this flag. Default value is 'false'.")
  public Boolean getSimulateBankLoginError() {
    return simulateBankLoginError;
  }

  public void setSimulateBankLoginError(Boolean simulateBankLoginError) {
    this.simulateBankLoginError = simulateBankLoginError;
  }

  public Apiv1testsmockBatchUpdateMockBankConnectionUpdates mockAccountsData(List<Apiv1testsmockBatchUpdateMockAccountsData> mockAccountsData) {
    this.mockAccountsData = mockAccountsData;
    return this;
  }

  public Apiv1testsmockBatchUpdateMockBankConnectionUpdates addMockAccountsDataItem(Apiv1testsmockBatchUpdateMockAccountsData mockAccountsDataItem) {
    this.mockAccountsData.add(mockAccountsDataItem);
    return this;
  }

   /**
   * Mock accounts data. Note that for accounts that exist in a bank connection but that you do not specify in this list, the service will act like those accounts are not received by the bank servers. This means that any accounts that you do not specify here will be marked as deprecated. If you do not specify this list at all, all accounts in the bank connection will be marked as deprecated.
   * @return mockAccountsData
  **/
  @ApiModelProperty(example = "null", value = "Mock accounts data. Note that for accounts that exist in a bank connection but that you do not specify in this list, the service will act like those accounts are not received by the bank servers. This means that any accounts that you do not specify here will be marked as deprecated. If you do not specify this list at all, all accounts in the bank connection will be marked as deprecated.")
  public List<Apiv1testsmockBatchUpdateMockAccountsData> getMockAccountsData() {
    return mockAccountsData;
  }

  public void setMockAccountsData(List<Apiv1testsmockBatchUpdateMockAccountsData> mockAccountsData) {
    this.mockAccountsData = mockAccountsData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Apiv1testsmockBatchUpdateMockBankConnectionUpdates apiv1testsmockBatchUpdateMockBankConnectionUpdates = (Apiv1testsmockBatchUpdateMockBankConnectionUpdates) o;
    return Objects.equals(this.bankConnectionId, apiv1testsmockBatchUpdateMockBankConnectionUpdates.bankConnectionId) &&
        Objects.equals(this.simulateBankLoginError, apiv1testsmockBatchUpdateMockBankConnectionUpdates.simulateBankLoginError) &&
        Objects.equals(this.mockAccountsData, apiv1testsmockBatchUpdateMockBankConnectionUpdates.mockAccountsData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankConnectionId, simulateBankLoginError, mockAccountsData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Apiv1testsmockBatchUpdateMockBankConnectionUpdates {\n");
    
    sb.append("    bankConnectionId: ").append(toIndentedString(bankConnectionId)).append("\n");
    sb.append("    simulateBankLoginError: ").append(toIndentedString(simulateBankLoginError)).append("\n");
    sb.append("    mockAccountsData: ").append(toIndentedString(mockAccountsData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

