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
import io.swagger.client.model.InlineResponse2009CashFlows;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Cash flows
 */
@ApiModel(description = "Cash flows")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse2009 {
  @SerializedName("cashFlows")
  private List<InlineResponse2009CashFlows> cashFlows = new ArrayList<InlineResponse2009CashFlows>();

  @SerializedName("totalIncome")
  private BigDecimal totalIncome = null;

  @SerializedName("totalSpending")
  private BigDecimal totalSpending = null;

  @SerializedName("totalBalance")
  private BigDecimal totalBalance = null;

  public InlineResponse2009 cashFlows(List<InlineResponse2009CashFlows> cashFlows) {
    this.cashFlows = cashFlows;
    return this;
  }

  public InlineResponse2009 addCashFlowsItem(InlineResponse2009CashFlows cashFlowsItem) {
    this.cashFlows.add(cashFlowsItem);
    return this;
  }

   /**
   * Array of cash flows
   * @return cashFlows
  **/
  @ApiModelProperty(example = "null", required = true, value = "Array of cash flows")
  public List<InlineResponse2009CashFlows> getCashFlows() {
    return cashFlows;
  }

  public void setCashFlows(List<InlineResponse2009CashFlows> cashFlows) {
    this.cashFlows = cashFlows;
  }

  public InlineResponse2009 totalIncome(BigDecimal totalIncome) {
    this.totalIncome = totalIncome;
    return this;
  }

   /**
   * The total income
   * @return totalIncome
  **/
  @ApiModelProperty(example = "null", required = true, value = "The total income")
  public BigDecimal getTotalIncome() {
    return totalIncome;
  }

  public void setTotalIncome(BigDecimal totalIncome) {
    this.totalIncome = totalIncome;
  }

  public InlineResponse2009 totalSpending(BigDecimal totalSpending) {
    this.totalSpending = totalSpending;
    return this;
  }

   /**
   * The total spending
   * @return totalSpending
  **/
  @ApiModelProperty(example = "null", required = true, value = "The total spending")
  public BigDecimal getTotalSpending() {
    return totalSpending;
  }

  public void setTotalSpending(BigDecimal totalSpending) {
    this.totalSpending = totalSpending;
  }

  public InlineResponse2009 totalBalance(BigDecimal totalBalance) {
    this.totalBalance = totalBalance;
    return this;
  }

   /**
   * The total balance
   * @return totalBalance
  **/
  @ApiModelProperty(example = "null", required = true, value = "The total balance")
  public BigDecimal getTotalBalance() {
    return totalBalance;
  }

  public void setTotalBalance(BigDecimal totalBalance) {
    this.totalBalance = totalBalance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2009 inlineResponse2009 = (InlineResponse2009) o;
    return Objects.equals(this.cashFlows, inlineResponse2009.cashFlows) &&
        Objects.equals(this.totalIncome, inlineResponse2009.totalIncome) &&
        Objects.equals(this.totalSpending, inlineResponse2009.totalSpending) &&
        Objects.equals(this.totalBalance, inlineResponse2009.totalBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cashFlows, totalIncome, totalSpending, totalBalance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2009 {\n");
    
    sb.append("    cashFlows: ").append(toIndentedString(cashFlows)).append("\n");
    sb.append("    totalIncome: ").append(toIndentedString(totalIncome)).append("\n");
    sb.append("    totalSpending: ").append(toIndentedString(totalSpending)).append("\n");
    sb.append("    totalBalance: ").append(toIndentedString(totalBalance)).append("\n");
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

