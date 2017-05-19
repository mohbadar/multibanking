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
import java.util.ArrayList;
import java.util.List;

/**
 * Update transactions parameters
 */
@ApiModel(description = "Update transactions parameters")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class UpdateTransactionsParams {
  @SerializedName("isNew")
  private Boolean isNew = false;

  @SerializedName("isPotentialDuplicate")
  private Boolean isPotentialDuplicate = false;

  @SerializedName("categoryId")
  private Long categoryId = null;

  @SerializedName("labelIds")
  private List<Long> labelIds = new ArrayList<Long>();

  public UpdateTransactionsParams isNew(Boolean isNew) {
    this.isNew = isNew;
    return this;
  }

   /**
   * Whether this transactions should be flagged as 'new' or not. Any newly imported transaction will have this flag initially set to true. How you use this field is up to your interpretation. For example, you might want to set it to false once a user has clicked on/seen the transaction.
   * @return isNew
  **/
  @ApiModelProperty(example = "null", value = "Whether this transactions should be flagged as 'new' or not. Any newly imported transaction will have this flag initially set to true. How you use this field is up to your interpretation. For example, you might want to set it to false once a user has clicked on/seen the transaction.")
  public Boolean getIsNew() {
    return isNew;
  }

  public void setIsNew(Boolean isNew) {
    this.isNew = isNew;
  }

  public UpdateTransactionsParams isPotentialDuplicate(Boolean isPotentialDuplicate) {
    this.isPotentialDuplicate = isPotentialDuplicate;
    return this;
  }

   /**
   * You can set this field only to 'false'. finAPI marks transactions as a potential duplicates  when its internal duplicate detection algorithm is signaling so. Transactions that are flagged as duplicates can be deleted by the user. To prevent the user from deleting original transactions, which might lead to incorrect balances, it is not possible to manually set this flag to 'true'.
   * @return isPotentialDuplicate
  **/
  @ApiModelProperty(example = "null", value = "You can set this field only to 'false'. finAPI marks transactions as a potential duplicates  when its internal duplicate detection algorithm is signaling so. Transactions that are flagged as duplicates can be deleted by the user. To prevent the user from deleting original transactions, which might lead to incorrect balances, it is not possible to manually set this flag to 'true'.")
  public Boolean getIsPotentialDuplicate() {
    return isPotentialDuplicate;
  }

  public void setIsPotentialDuplicate(Boolean isPotentialDuplicate) {
    this.isPotentialDuplicate = isPotentialDuplicate;
  }

  public UpdateTransactionsParams categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

   /**
   * Identifier of the new category to apply to the transaction. When updating the transaction's category, the category's fields 'id', 'name', 'parentId', 'parentName', and 'isCustom' will all get updated. To clear the category for the transaction, the categoryId field must be passed with value 0.
   * @return categoryId
  **/
  @ApiModelProperty(example = "null", value = "Identifier of the new category to apply to the transaction. When updating the transaction's category, the category's fields 'id', 'name', 'parentId', 'parentName', and 'isCustom' will all get updated. To clear the category for the transaction, the categoryId field must be passed with value 0.")
  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public UpdateTransactionsParams labelIds(List<Long> labelIds) {
    this.labelIds = labelIds;
    return this;
  }

  public UpdateTransactionsParams addLabelIdsItem(Long labelIdsItem) {
    this.labelIds.add(labelIdsItem);
    return this;
  }

   /**
   * Identifiers of labels to apply to the transaction. To clear transactions' labels, pass an empty array of identifiers: '[]'
   * @return labelIds
  **/
  @ApiModelProperty(example = "null", value = "Identifiers of labels to apply to the transaction. To clear transactions' labels, pass an empty array of identifiers: '[]'")
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
    UpdateTransactionsParams updateTransactionsParams = (UpdateTransactionsParams) o;
    return Objects.equals(this.isNew, updateTransactionsParams.isNew) &&
        Objects.equals(this.isPotentialDuplicate, updateTransactionsParams.isPotentialDuplicate) &&
        Objects.equals(this.categoryId, updateTransactionsParams.categoryId) &&
        Objects.equals(this.labelIds, updateTransactionsParams.labelIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isNew, isPotentialDuplicate, categoryId, labelIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTransactionsParams {\n");
    
    sb.append("    isNew: ").append(toIndentedString(isNew)).append("\n");
    sb.append("    isPotentialDuplicate: ").append(toIndentedString(isPotentialDuplicate)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
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

