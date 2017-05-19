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

/**
 * Container for bank connection update parameters
 */
@ApiModel(description = "Container for bank connection update parameters")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class UpdateBankConnectionParams {
  @SerializedName("bankConnectionId")
  private Long bankConnectionId = null;

  @SerializedName("bankingPin")
  private String bankingPin = null;

  @SerializedName("importNewAccounts")
  private Boolean importNewAccounts = false;

  @SerializedName("skipPositionsDownload")
  private Boolean skipPositionsDownload = false;

  public UpdateBankConnectionParams bankConnectionId(Long bankConnectionId) {
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

  public UpdateBankConnectionParams bankingPin(String bankingPin) {
    this.bankingPin = bankingPin;
    return this;
  }

   /**
   * Online banking PIN. If a PIN is stored in the bank connection, then this field may remain unset. If the field is set though then it will always be used (even if there is some other PIN stored in the bank connection)
   * @return bankingPin
  **/
  @ApiModelProperty(example = "null", value = "Online banking PIN. If a PIN is stored in the bank connection, then this field may remain unset. If the field is set though then it will always be used (even if there is some other PIN stored in the bank connection)")
  public String getBankingPin() {
    return bankingPin;
  }

  public void setBankingPin(String bankingPin) {
    this.bankingPin = bankingPin;
  }

  public UpdateBankConnectionParams importNewAccounts(Boolean importNewAccounts) {
    this.importNewAccounts = importNewAccounts;
    return this;
  }

   /**
   * Whether new accounts that have not yet been imported will be imported or not. Default is false. <br/>NOTES:<br/><br/>&bull; For best performance of the bank connection update, you should not enable this flag unless you really expect new accounts to be available in the connection. It is recommended to let your users tell you through your application when they want the service to look for new accounts.<br/>&bull; If you have imported a bank connection using specific <code>accountTypeIds</code> (e.g. <code>1,2</code> to import checking and saving accounts), you would import all other accounts (e.g. security accounts or credit cards) by setting <code>importNewAccounts</code> to <code>true</code>. To avoid importing account types that you are not interested in, make sure this field is undefined or set to false.
   * @return importNewAccounts
  **/
  @ApiModelProperty(example = "null", value = "Whether new accounts that have not yet been imported will be imported or not. Default is false. <br/>NOTES:<br/><br/>&bull; For best performance of the bank connection update, you should not enable this flag unless you really expect new accounts to be available in the connection. It is recommended to let your users tell you through your application when they want the service to look for new accounts.<br/>&bull; If you have imported a bank connection using specific <code>accountTypeIds</code> (e.g. <code>1,2</code> to import checking and saving accounts), you would import all other accounts (e.g. security accounts or credit cards) by setting <code>importNewAccounts</code> to <code>true</code>. To avoid importing account types that you are not interested in, make sure this field is undefined or set to false.")
  public Boolean getImportNewAccounts() {
    return importNewAccounts;
  }

  public void setImportNewAccounts(Boolean importNewAccounts) {
    this.importNewAccounts = importNewAccounts;
  }

  public UpdateBankConnectionParams skipPositionsDownload(Boolean skipPositionsDownload) {
    this.skipPositionsDownload = skipPositionsDownload;
    return this;
  }

   /**
   * Whether to skip the download of transactions and securities or not. If set to true, then finAPI will download just the accounts list with the accounts' information (like account name, number, holder, etc), as well as the accounts' balances (if possible), but skip the download of transactions and securities. Default is false.<br/>NOTES:<br/><br/>&bull; If you skip the download of transactions and securities during an import or update, you can still download them on a later update (though you might not get all positions at a later point, because the date range in which the bank servers provide this data is usually limited). However, once finAPI has downloaded the transactions or securities for the first time, you will not be able to go back to skipping the download of transactions and securities! In other words: Once you make your first request with <code>skipPositionsDownload=false</code> for a certain bank connection, you will no longer be able to make a request with <code>skipPositionsDownload=true</code> for that same bank connection.<br/>&bull; If this bank connection is updated via finAPI's automatic batch update, then transactions and security positions <u>will</u> be downloaded in any case!<br/>&bull; For security accounts, skipping the downloading of the securities might result in the account's balance also not being downloaded.
   * @return skipPositionsDownload
  **/
  @ApiModelProperty(example = "null", value = "Whether to skip the download of transactions and securities or not. If set to true, then finAPI will download just the accounts list with the accounts' information (like account name, number, holder, etc), as well as the accounts' balances (if possible), but skip the download of transactions and securities. Default is false.<br/>NOTES:<br/><br/>&bull; If you skip the download of transactions and securities during an import or update, you can still download them on a later update (though you might not get all positions at a later point, because the date range in which the bank servers provide this data is usually limited). However, once finAPI has downloaded the transactions or securities for the first time, you will not be able to go back to skipping the download of transactions and securities! In other words: Once you make your first request with <code>skipPositionsDownload=false</code> for a certain bank connection, you will no longer be able to make a request with <code>skipPositionsDownload=true</code> for that same bank connection.<br/>&bull; If this bank connection is updated via finAPI's automatic batch update, then transactions and security positions <u>will</u> be downloaded in any case!<br/>&bull; For security accounts, skipping the downloading of the securities might result in the account's balance also not being downloaded.")
  public Boolean getSkipPositionsDownload() {
    return skipPositionsDownload;
  }

  public void setSkipPositionsDownload(Boolean skipPositionsDownload) {
    this.skipPositionsDownload = skipPositionsDownload;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBankConnectionParams updateBankConnectionParams = (UpdateBankConnectionParams) o;
    return Objects.equals(this.bankConnectionId, updateBankConnectionParams.bankConnectionId) &&
        Objects.equals(this.bankingPin, updateBankConnectionParams.bankingPin) &&
        Objects.equals(this.importNewAccounts, updateBankConnectionParams.importNewAccounts) &&
        Objects.equals(this.skipPositionsDownload, updateBankConnectionParams.skipPositionsDownload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankConnectionId, bankingPin, importNewAccounts, skipPositionsDownload);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBankConnectionParams {\n");
    
    sb.append("    bankConnectionId: ").append(toIndentedString(bankConnectionId)).append("\n");
    sb.append("    bankingPin: ").append(toIndentedString(bankingPin)).append("\n");
    sb.append("    importNewAccounts: ").append(toIndentedString(importNewAccounts)).append("\n");
    sb.append("    skipPositionsDownload: ").append(toIndentedString(skipPositionsDownload)).append("\n");
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

