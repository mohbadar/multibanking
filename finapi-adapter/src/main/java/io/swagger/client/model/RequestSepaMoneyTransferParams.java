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
import io.swagger.client.model.Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for a single or collective SEPA money transfer order request
 */
@ApiModel(description = "Parameters for a single or collective SEPA money transfer order request")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class RequestSepaMoneyTransferParams {
  @SerializedName("recipientName")
  private String recipientName = null;

  @SerializedName("recipientIban")
  private String recipientIban = null;

  @SerializedName("recipientBic")
  private String recipientBic = null;

  @SerializedName("amount")
  private BigDecimal amount = null;

  @SerializedName("purpose")
  private String purpose = null;

  @SerializedName("accountId")
  private Long accountId = null;

  @SerializedName("bankingPin")
  private String bankingPin = null;

  @SerializedName("twoStepProcedureId")
  private String twoStepProcedureId = null;

  @SerializedName("additionalMoneyTransfers")
  private List<Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers> additionalMoneyTransfers = new ArrayList<Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers>();

  public RequestSepaMoneyTransferParams recipientName(String recipientName) {
    this.recipientName = recipientName;
    return this;
  }

   /**
   * Name of the recipient. Note: Neither finAPI nor the involved bank servers are guaranteed to validate the recipient name. Even if the recipient name does not depict the actual registered account holder of the specified recipient account, the money transfer request might still be successful.
   * @return recipientName
  **/
  @ApiModelProperty(example = "null", required = true, value = "Name of the recipient. Note: Neither finAPI nor the involved bank servers are guaranteed to validate the recipient name. Even if the recipient name does not depict the actual registered account holder of the specified recipient account, the money transfer request might still be successful.")
  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public RequestSepaMoneyTransferParams recipientIban(String recipientIban) {
    this.recipientIban = recipientIban;
    return this;
  }

   /**
   * IBAN of the recipient's account
   * @return recipientIban
  **/
  @ApiModelProperty(example = "null", required = true, value = "IBAN of the recipient's account")
  public String getRecipientIban() {
    return recipientIban;
  }

  public void setRecipientIban(String recipientIban) {
    this.recipientIban = recipientIban;
  }

  public RequestSepaMoneyTransferParams recipientBic(String recipientBic) {
    this.recipientBic = recipientBic;
    return this;
  }

   /**
   * BIC of the recipient's account. Note: This field is optional if - and only if - the bank connection of the account that you want to transfer money from supports the IBAN-Only money transfer. You can find this out via GET /bankConnections/<id>. Also note that when a BIC is given, then this BIC will be used for the money transfer request independent of whether it is required or not.
   * @return recipientBic
  **/
  @ApiModelProperty(example = "null", value = "BIC of the recipient's account. Note: This field is optional if - and only if - the bank connection of the account that you want to transfer money from supports the IBAN-Only money transfer. You can find this out via GET /bankConnections/<id>. Also note that when a BIC is given, then this BIC will be used for the money transfer request independent of whether it is required or not.")
  public String getRecipientBic() {
    return recipientBic;
  }

  public void setRecipientBic(String recipientBic) {
    this.recipientBic = recipientBic;
  }

  public RequestSepaMoneyTransferParams amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount to transfer. Must be a positive decimal number with at most two decimal places (e.g. 99.90)
   * @return amount
  **/
  @ApiModelProperty(example = "null", required = true, value = "The amount to transfer. Must be a positive decimal number with at most two decimal places (e.g. 99.90)")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public RequestSepaMoneyTransferParams purpose(String purpose) {
    this.purpose = purpose;
    return this;
  }

   /**
   * The purpose of the transfer transaction
   * @return purpose
  **/
  @ApiModelProperty(example = "null", value = "The purpose of the transfer transaction")
  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public RequestSepaMoneyTransferParams accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Identifier of the bank account that you want to transfer money from
   * @return accountId
  **/
  @ApiModelProperty(example = "null", required = true, value = "Identifier of the bank account that you want to transfer money from")
  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public RequestSepaMoneyTransferParams bankingPin(String bankingPin) {
    this.bankingPin = bankingPin;
    return this;
  }

   /**
   * Online banking PIN. If a PIN is stored in the account's bank connection, then this field may remain unset. If the field is set though then it will always be used (even if there is some other PIN stored in the bank connection).
   * @return bankingPin
  **/
  @ApiModelProperty(example = "null", value = "Online banking PIN. If a PIN is stored in the account's bank connection, then this field may remain unset. If the field is set though then it will always be used (even if there is some other PIN stored in the bank connection).")
  public String getBankingPin() {
    return bankingPin;
  }

  public void setBankingPin(String bankingPin) {
    this.bankingPin = bankingPin;
  }

  public RequestSepaMoneyTransferParams twoStepProcedureId(String twoStepProcedureId) {
    this.twoStepProcedureId = twoStepProcedureId;
    return this;
  }

   /**
   * The bank-given ID of the two-step-procedure that should be used for the money transfer. For a list of available two-step-procedures, see the corresponding bank connection (GET /bankConnections). If this field is not set, then the bank connection's default two-step procedure will be used. Note that in this case, when the bank connection has no default two-step procedure set, then the service will return an error (see response messages for details).
   * @return twoStepProcedureId
  **/
  @ApiModelProperty(example = "null", value = "The bank-given ID of the two-step-procedure that should be used for the money transfer. For a list of available two-step-procedures, see the corresponding bank connection (GET /bankConnections). If this field is not set, then the bank connection's default two-step procedure will be used. Note that in this case, when the bank connection has no default two-step procedure set, then the service will return an error (see response messages for details).")
  public String getTwoStepProcedureId() {
    return twoStepProcedureId;
  }

  public void setTwoStepProcedureId(String twoStepProcedureId) {
    this.twoStepProcedureId = twoStepProcedureId;
  }

  public RequestSepaMoneyTransferParams additionalMoneyTransfers(List<Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers> additionalMoneyTransfers) {
    this.additionalMoneyTransfers = additionalMoneyTransfers;
    return this;
  }

  public RequestSepaMoneyTransferParams addAdditionalMoneyTransfersItem(Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers additionalMoneyTransfersItem) {
    this.additionalMoneyTransfers.add(additionalMoneyTransfersItem);
    return this;
  }

   /**
   * In case that you want to submit not just a single money transfer, but instead do a collective money transfer, use this field to pass a list of additional money transfer orders. The service will then pass a collective money transfer request to the bank, including both the money transfer specified on the top-level, as well as all money transfers specified in this list.
   * @return additionalMoneyTransfers
  **/
  @ApiModelProperty(example = "null", value = "In case that you want to submit not just a single money transfer, but instead do a collective money transfer, use this field to pass a list of additional money transfer orders. The service will then pass a collective money transfer request to the bank, including both the money transfer specified on the top-level, as well as all money transfers specified in this list.")
  public List<Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers> getAdditionalMoneyTransfers() {
    return additionalMoneyTransfers;
  }

  public void setAdditionalMoneyTransfers(List<Apiv1accountsrequestSepaMoneyTransferAdditionalMoneyTransfers> additionalMoneyTransfers) {
    this.additionalMoneyTransfers = additionalMoneyTransfers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestSepaMoneyTransferParams requestSepaMoneyTransferParams = (RequestSepaMoneyTransferParams) o;
    return Objects.equals(this.recipientName, requestSepaMoneyTransferParams.recipientName) &&
        Objects.equals(this.recipientIban, requestSepaMoneyTransferParams.recipientIban) &&
        Objects.equals(this.recipientBic, requestSepaMoneyTransferParams.recipientBic) &&
        Objects.equals(this.amount, requestSepaMoneyTransferParams.amount) &&
        Objects.equals(this.purpose, requestSepaMoneyTransferParams.purpose) &&
        Objects.equals(this.accountId, requestSepaMoneyTransferParams.accountId) &&
        Objects.equals(this.bankingPin, requestSepaMoneyTransferParams.bankingPin) &&
        Objects.equals(this.twoStepProcedureId, requestSepaMoneyTransferParams.twoStepProcedureId) &&
        Objects.equals(this.additionalMoneyTransfers, requestSepaMoneyTransferParams.additionalMoneyTransfers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipientName, recipientIban, recipientBic, amount, purpose, accountId, bankingPin, twoStepProcedureId, additionalMoneyTransfers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestSepaMoneyTransferParams {\n");
    
    sb.append("    recipientName: ").append(toIndentedString(recipientName)).append("\n");
    sb.append("    recipientIban: ").append(toIndentedString(recipientIban)).append("\n");
    sb.append("    recipientBic: ").append(toIndentedString(recipientBic)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    bankingPin: ").append(toIndentedString(bankingPin)).append("\n");
    sb.append("    twoStepProcedureId: ").append(toIndentedString(twoStepProcedureId)).append("\n");
    sb.append("    additionalMoneyTransfers: ").append(toIndentedString(additionalMoneyTransfers)).append("\n");
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

