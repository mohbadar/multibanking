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
 * User&#39;s verification status
 */
@ApiModel(description = "User's verification status")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class VerificationStatusResource {
  @SerializedName("userId")
  private String userId = null;

  @SerializedName("isUserVerified")
  private Boolean isUserVerified = false;

  public VerificationStatusResource userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User's identifier
   * @return userId
  **/
  @ApiModelProperty(example = "null", required = true, value = "User's identifier")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public VerificationStatusResource isUserVerified(Boolean isUserVerified) {
    this.isUserVerified = isUserVerified;
    return this;
  }

   /**
   * User's verification status
   * @return isUserVerified
  **/
  @ApiModelProperty(example = "null", required = true, value = "User's verification status")
  public Boolean getIsUserVerified() {
    return isUserVerified;
  }

  public void setIsUserVerified(Boolean isUserVerified) {
    this.isUserVerified = isUserVerified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStatusResource verificationStatusResource = (VerificationStatusResource) o;
    return Objects.equals(this.userId, verificationStatusResource.userId) &&
        Objects.equals(this.isUserVerified, verificationStatusResource.isUserVerified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, isUserVerified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStatusResource {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    isUserVerified: ").append(toIndentedString(isUserVerified)).append("\n");
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

