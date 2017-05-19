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
 * Container for an account&#39;s name, type and &#39;isNew&#39; flag&#39;.
 */
@ApiModel(description = "Container for an account's name, type and 'isNew' flag'.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class Body2 {
  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("accountTypeId")
  private Long accountTypeId = null;

  @SerializedName("isNew")
  private Boolean isNew = false;

  public Body2 accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Account name. Maximum length is 512.
   * @return accountName
  **/
  @ApiModelProperty(example = "null", value = "Account name. Maximum length is 512.")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public Body2 accountTypeId(Long accountTypeId) {
    this.accountTypeId = accountTypeId;
    return this;
  }

   /**
   * Identifier of account type.<br/><br/>1 = Checking,<br/>2 = Savings,<br/>3 = CreditCard,<br/>4 = Security,<br/>5 = Loan,<br/>6 = Pocket (DEPRECATED; will not be returned for any account unless this type has explicitly been set via PATCH),<br/>7 = Membership<br/><br/>
   * minimum: 1
   * maximum: 7
   * @return accountTypeId
  **/
  @ApiModelProperty(example = "null", value = "Identifier of account type.<br/><br/>1 = Checking,<br/>2 = Savings,<br/>3 = CreditCard,<br/>4 = Security,<br/>5 = Loan,<br/>6 = Pocket (DEPRECATED; will not be returned for any account unless this type has explicitly been set via PATCH),<br/>7 = Membership<br/><br/>")
  public Long getAccountTypeId() {
    return accountTypeId;
  }

  public void setAccountTypeId(Long accountTypeId) {
    this.accountTypeId = accountTypeId;
  }

  public Body2 isNew(Boolean isNew) {
    this.isNew = isNew;
    return this;
  }

   /**
   * Whether this account should be flagged as 'new' or not. Any newly imported account will have this flag initially set to true, and remain so until you set it to false (see PATCH /accounts/<id>). How you use this field is up to your interpretation, however it is recommended to set the flag to false for all accounts right after the initial import of the bank connection. This way, you will be able recognize accounts that get newly imported during a later update of the bank connection, by checking for any accounts with the flag set to true after every update of the bank connection.
   * @return isNew
  **/
  @ApiModelProperty(example = "null", value = "Whether this account should be flagged as 'new' or not. Any newly imported account will have this flag initially set to true, and remain so until you set it to false (see PATCH /accounts/<id>). How you use this field is up to your interpretation, however it is recommended to set the flag to false for all accounts right after the initial import of the bank connection. This way, you will be able recognize accounts that get newly imported during a later update of the bank connection, by checking for any accounts with the flag set to true after every update of the bank connection.")
  public Boolean getIsNew() {
    return isNew;
  }

  public void setIsNew(Boolean isNew) {
    this.isNew = isNew;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body2 body2 = (Body2) o;
    return Objects.equals(this.accountName, body2.accountName) &&
        Objects.equals(this.accountTypeId, body2.accountTypeId) &&
        Objects.equals(this.isNew, body2.isNew);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, accountTypeId, isNew);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body2 {\n");
    
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountTypeId: ").append(toIndentedString(accountTypeId)).append("\n");
    sb.append("    isNew: ").append(toIndentedString(isNew)).append("\n");
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

