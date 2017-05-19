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
import java.math.BigDecimal;

/**
 * Recipient data for a single money transfer order
 */
@ApiModel(description = "Recipient data for a single money transfer order")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class SingleMoneyTransferRecipientData {
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

  public SingleMoneyTransferRecipientData recipientName(String recipientName) {
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

  public SingleMoneyTransferRecipientData recipientIban(String recipientIban) {
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

  public SingleMoneyTransferRecipientData recipientBic(String recipientBic) {
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

  public SingleMoneyTransferRecipientData amount(BigDecimal amount) {
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

  public SingleMoneyTransferRecipientData purpose(String purpose) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingleMoneyTransferRecipientData singleMoneyTransferRecipientData = (SingleMoneyTransferRecipientData) o;
    return Objects.equals(this.recipientName, singleMoneyTransferRecipientData.recipientName) &&
        Objects.equals(this.recipientIban, singleMoneyTransferRecipientData.recipientIban) &&
        Objects.equals(this.recipientBic, singleMoneyTransferRecipientData.recipientBic) &&
        Objects.equals(this.amount, singleMoneyTransferRecipientData.amount) &&
        Objects.equals(this.purpose, singleMoneyTransferRecipientData.purpose);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipientName, recipientIban, recipientBic, amount, purpose);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SingleMoneyTransferRecipientData {\n");
    
    sb.append("    recipientName: ").append(toIndentedString(recipientName)).append("\n");
    sb.append("    recipientIban: ").append(toIndentedString(recipientIban)).append("\n");
    sb.append("    recipientBic: ").append(toIndentedString(recipientBic)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
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

