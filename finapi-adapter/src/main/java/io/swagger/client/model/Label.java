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
 * Container for a label&#39;s data
 */
@ApiModel(description = "Container for a label's data")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class Label {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("name")
  private String name = null;

  public Label id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Label identifier
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "Label identifier")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Label name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Label name
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "Label name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Label label = (Label) o;
    return Objects.equals(this.id, label.id) &&
        Objects.equals(this.name, label.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Label {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

