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
import io.swagger.client.model.InlineResponse20019Transactions;
import io.swagger.client.model.InlineResponse2002Paging;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for page of transactions, data about total count of transactions and balances
 */
@ApiModel(description = "Container for page of transactions, data about total count of transactions and balances")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse20019 {
  @SerializedName("transactions")
  private List<InlineResponse20019Transactions> transactions = new ArrayList<InlineResponse20019Transactions>();

  @SerializedName("paging")
  private InlineResponse2002Paging paging = null;

  @SerializedName("income")
  private BigDecimal income = null;

  @SerializedName("spending")
  private BigDecimal spending = null;

  @SerializedName("balance")
  private BigDecimal balance = null;

  public InlineResponse20019 transactions(List<InlineResponse20019Transactions> transactions) {
    this.transactions = transactions;
    return this;
  }

  public InlineResponse20019 addTransactionsItem(InlineResponse20019Transactions transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

   /**
   * Array of transactions per page
   * @return transactions
  **/
  @ApiModelProperty(example = "null", required = true, value = "Array of transactions per page")
  public List<InlineResponse20019Transactions> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<InlineResponse20019Transactions> transactions) {
    this.transactions = transactions;
  }

  public InlineResponse20019 paging(InlineResponse2002Paging paging) {
    this.paging = paging;
    return this;
  }

   /**
   * Get paging
   * @return paging
  **/
  @ApiModelProperty(example = "null", value = "")
  public InlineResponse2002Paging getPaging() {
    return paging;
  }

  public void setPaging(InlineResponse2002Paging paging) {
    this.paging = paging;
  }

  public InlineResponse20019 income(BigDecimal income) {
    this.income = income;
    return this;
  }

   /**
   * The total income of all transactions
   * @return income
  **/
  @ApiModelProperty(example = "null", required = true, value = "The total income of all transactions")
  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public InlineResponse20019 spending(BigDecimal spending) {
    this.spending = spending;
    return this;
  }

   /**
   * The total spending of all transactions
   * @return spending
  **/
  @ApiModelProperty(example = "null", required = true, value = "The total spending of all transactions")
  public BigDecimal getSpending() {
    return spending;
  }

  public void setSpending(BigDecimal spending) {
    this.spending = spending;
  }

  public InlineResponse20019 balance(BigDecimal balance) {
    this.balance = balance;
    return this;
  }

   /**
   * The total sum of all transactions
   * @return balance
  **/
  @ApiModelProperty(example = "null", required = true, value = "The total sum of all transactions")
  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20019 inlineResponse20019 = (InlineResponse20019) o;
    return Objects.equals(this.transactions, inlineResponse20019.transactions) &&
        Objects.equals(this.paging, inlineResponse20019.paging) &&
        Objects.equals(this.income, inlineResponse20019.income) &&
        Objects.equals(this.spending, inlineResponse20019.spending) &&
        Objects.equals(this.balance, inlineResponse20019.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactions, paging, income, spending, balance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20019 {\n");
    
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    spending: ").append(toIndentedString(spending)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

