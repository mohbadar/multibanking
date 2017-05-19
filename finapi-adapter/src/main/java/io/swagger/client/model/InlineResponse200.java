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
import io.swagger.client.model.InlineResponse200Accounts;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for data of multiple bank accounts
 */
@ApiModel(description = "Container for data of multiple bank accounts")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse200 {
  @SerializedName("accounts")
  private List<InlineResponse200Accounts> accounts = new ArrayList<InlineResponse200Accounts>();

  public InlineResponse200 accounts(List<InlineResponse200Accounts> accounts) {
    this.accounts = accounts;
    return this;
  }

  public InlineResponse200 addAccountsItem(InlineResponse200Accounts accountsItem) {
    this.accounts.add(accountsItem);
    return this;
  }

   /**
   * List of bank accounts
   * @return accounts
  **/
  @ApiModelProperty(example = "null", value = "List of bank accounts")
  public List<InlineResponse200Accounts> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<InlineResponse200Accounts> accounts) {
    this.accounts = accounts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.accounts, inlineResponse200.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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

