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
import java.util.ArrayList;
import java.util.List;

/**
 * Data of a sub-transaction
 */
@ApiModel(description = "Data of a sub-transaction")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class SubTransactionParams {
  @SerializedName("amount")
  private BigDecimal amount = null;

  @SerializedName("categoryId")
  private Long categoryId = null;

  @SerializedName("purpose")
  private String purpose = null;

  @SerializedName("counterpart")
  private String counterpart = null;

  @SerializedName("counterpartAccountNumber")
  private String counterpartAccountNumber = null;

  @SerializedName("counterpartIban")
  private String counterpartIban = null;

  @SerializedName("counterpartBic")
  private String counterpartBic = null;

  @SerializedName("counterpartBlz")
  private String counterpartBlz = null;

  @SerializedName("labelIds")
  private List<Long> labelIds = new ArrayList<Long>();

  public SubTransactionParams amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount
   * @return amount
  **/
  @ApiModelProperty(example = "null", required = true, value = "Amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public SubTransactionParams categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

   /**
   * Category identifier. If not specified, the original transaction's category will be applied. If you explicitly want the sub-transaction to have no category, then pass this field with value '0' (zero).
   * @return categoryId
  **/
  @ApiModelProperty(example = "null", value = "Category identifier. If not specified, the original transaction's category will be applied. If you explicitly want the sub-transaction to have no category, then pass this field with value '0' (zero).")
  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public SubTransactionParams purpose(String purpose) {
    this.purpose = purpose;
    return this;
  }

   /**
   * Purpose. Maximum length is 2000. If not specified, the original transaction's value will be applied.
   * @return purpose
  **/
  @ApiModelProperty(example = "null", value = "Purpose. Maximum length is 2000. If not specified, the original transaction's value will be applied.")
  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public SubTransactionParams counterpart(String counterpart) {
    this.counterpart = counterpart;
    return this;
  }

   /**
   * Counterpart. Maximum length is 270. If not specified, the original transaction's value will be applied.
   * @return counterpart
  **/
  @ApiModelProperty(example = "null", value = "Counterpart. Maximum length is 270. If not specified, the original transaction's value will be applied.")
  public String getCounterpart() {
    return counterpart;
  }

  public void setCounterpart(String counterpart) {
    this.counterpart = counterpart;
  }

  public SubTransactionParams counterpartAccountNumber(String counterpartAccountNumber) {
    this.counterpartAccountNumber = counterpartAccountNumber;
    return this;
  }

   /**
   * Counterpart account number. If not specified, the original transaction's value will be applied.
   * @return counterpartAccountNumber
  **/
  @ApiModelProperty(example = "null", value = "Counterpart account number. If not specified, the original transaction's value will be applied.")
  public String getCounterpartAccountNumber() {
    return counterpartAccountNumber;
  }

  public void setCounterpartAccountNumber(String counterpartAccountNumber) {
    this.counterpartAccountNumber = counterpartAccountNumber;
  }

  public SubTransactionParams counterpartIban(String counterpartIban) {
    this.counterpartIban = counterpartIban;
    return this;
  }

   /**
   * Counterpart IBAN. If not specified, the original transaction's value will be applied.
   * @return counterpartIban
  **/
  @ApiModelProperty(example = "null", value = "Counterpart IBAN. If not specified, the original transaction's value will be applied.")
  public String getCounterpartIban() {
    return counterpartIban;
  }

  public void setCounterpartIban(String counterpartIban) {
    this.counterpartIban = counterpartIban;
  }

  public SubTransactionParams counterpartBic(String counterpartBic) {
    this.counterpartBic = counterpartBic;
    return this;
  }

   /**
   * Counterpart BIC. If not specified, the original transaction's value will be applied.
   * @return counterpartBic
  **/
  @ApiModelProperty(example = "null", value = "Counterpart BIC. If not specified, the original transaction's value will be applied.")
  public String getCounterpartBic() {
    return counterpartBic;
  }

  public void setCounterpartBic(String counterpartBic) {
    this.counterpartBic = counterpartBic;
  }

  public SubTransactionParams counterpartBlz(String counterpartBlz) {
    this.counterpartBlz = counterpartBlz;
    return this;
  }

   /**
   * Counterpart BLZ. If not specified, the original transaction's value will be applied.
   * @return counterpartBlz
  **/
  @ApiModelProperty(example = "null", value = "Counterpart BLZ. If not specified, the original transaction's value will be applied.")
  public String getCounterpartBlz() {
    return counterpartBlz;
  }

  public void setCounterpartBlz(String counterpartBlz) {
    this.counterpartBlz = counterpartBlz;
  }

  public SubTransactionParams labelIds(List<Long> labelIds) {
    this.labelIds = labelIds;
    return this;
  }

  public SubTransactionParams addLabelIdsItem(Long labelIdsItem) {
    this.labelIds.add(labelIdsItem);
    return this;
  }

   /**
   * List of connected labels. Note that when this field is not specified, then the labels of the original transaction will NOT get applied to the sub-transaction. Instead, the sub-transaction will have no labels assigned to it.
   * @return labelIds
  **/
  @ApiModelProperty(example = "null", value = "List of connected labels. Note that when this field is not specified, then the labels of the original transaction will NOT get applied to the sub-transaction. Instead, the sub-transaction will have no labels assigned to it.")
  public List<Long> getLabelIds() {
    return labelIds;
  }

  public void setLabelIds(List<Long> labelIds) {
    this.labelIds = labelIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubTransactionParams subTransactionParams = (SubTransactionParams) o;
    return Objects.equals(this.amount, subTransactionParams.amount) &&
        Objects.equals(this.categoryId, subTransactionParams.categoryId) &&
        Objects.equals(this.purpose, subTransactionParams.purpose) &&
        Objects.equals(this.counterpart, subTransactionParams.counterpart) &&
        Objects.equals(this.counterpartAccountNumber, subTransactionParams.counterpartAccountNumber) &&
        Objects.equals(this.counterpartIban, subTransactionParams.counterpartIban) &&
        Objects.equals(this.counterpartBic, subTransactionParams.counterpartBic) &&
        Objects.equals(this.counterpartBlz, subTransactionParams.counterpartBlz) &&
        Objects.equals(this.labelIds, subTransactionParams.labelIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, categoryId, purpose, counterpart, counterpartAccountNumber, counterpartIban, counterpartBic, counterpartBlz, labelIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubTransactionParams {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    counterpart: ").append(toIndentedString(counterpart)).append("\n");
    sb.append("    counterpartAccountNumber: ").append(toIndentedString(counterpartAccountNumber)).append("\n");
    sb.append("    counterpartIban: ").append(toIndentedString(counterpartIban)).append("\n");
    sb.append("    counterpartBic: ").append(toIndentedString(counterpartBic)).append("\n");
    sb.append("    counterpartBlz: ").append(toIndentedString(counterpartBlz)).append("\n");
    sb.append("    labelIds: ").append(toIndentedString(labelIds)).append("\n");
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

