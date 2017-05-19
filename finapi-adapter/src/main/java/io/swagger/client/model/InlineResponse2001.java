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
 * Set of identifiers (in ascending order)
 */
@ApiModel(description = "Set of identifiers (in ascending order)")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse2001 {
  @SerializedName("identifiers")
  private List<Long> identifiers = new ArrayList<Long>();

  public InlineResponse2001 identifiers(List<Long> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  public InlineResponse2001 addIdentifiersItem(Long identifiersItem) {
    this.identifiers.add(identifiersItem);
    return this;
  }

   /**
   * Set of identifiers (in ascending order)
   * @return identifiers
  **/
  @ApiModelProperty(example = "null", value = "Set of identifiers (in ascending order)")
  public List<Long> getIdentifiers() {
    return identifiers;
  }

  public void setIdentifiers(List<Long> identifiers) {
    this.identifiers = identifiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.identifiers, inlineResponse2001.identifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifiers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
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

