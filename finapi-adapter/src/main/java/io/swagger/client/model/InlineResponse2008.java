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
import io.swagger.client.model.InlineResponse2002Paging;
import io.swagger.client.model.InlineResponse2008Categories;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for categories with paging info
 */
@ApiModel(description = "Container for categories with paging info")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse2008 {
  @SerializedName("categories")
  private List<InlineResponse2008Categories> categories = new ArrayList<InlineResponse2008Categories>();

  @SerializedName("paging")
  private InlineResponse2002Paging paging = null;

  public InlineResponse2008 categories(List<InlineResponse2008Categories> categories) {
    this.categories = categories;
    return this;
  }

  public InlineResponse2008 addCategoriesItem(InlineResponse2008Categories categoriesItem) {
    this.categories.add(categoriesItem);
    return this;
  }

   /**
   * Categories
   * @return categories
  **/
  @ApiModelProperty(example = "null", required = true, value = "Categories")
  public List<InlineResponse2008Categories> getCategories() {
    return categories;
  }

  public void setCategories(List<InlineResponse2008Categories> categories) {
    this.categories = categories;
  }

  public InlineResponse2008 paging(InlineResponse2002Paging paging) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2008 inlineResponse2008 = (InlineResponse2008) o;
    return Objects.equals(this.categories, inlineResponse2008.categories) &&
        Objects.equals(this.paging, inlineResponse2008.paging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories, paging);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2008 {\n");
    
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
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

