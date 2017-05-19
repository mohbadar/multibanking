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
 * Container for user information
 */
@ApiModel(description = "Container for user information")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class UserInfo {
  @SerializedName("userId")
  private String userId = null;

  @SerializedName("registrationDate")
  private String registrationDate = null;

  @SerializedName("deletionDate")
  private String deletionDate = null;

  @SerializedName("lastActiveDate")
  private String lastActiveDate = null;

  public UserInfo userId(String userId) {
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

  public UserInfo registrationDate(String registrationDate) {
    this.registrationDate = registrationDate;
    return this;
  }

   /**
   * User's registration date, in the format 'yyyy-MM-dd'
   * @return registrationDate
  **/
  @ApiModelProperty(example = "null", required = true, value = "User's registration date, in the format 'yyyy-MM-dd'")
  public String getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(String registrationDate) {
    this.registrationDate = registrationDate;
  }

  public UserInfo deletionDate(String deletionDate) {
    this.deletionDate = deletionDate;
    return this;
  }

   /**
   * User's deletion date, in the format 'yyyy-MM-dd'. May be null if the user has not been deleted.
   * @return deletionDate
  **/
  @ApiModelProperty(example = "null", value = "User's deletion date, in the format 'yyyy-MM-dd'. May be null if the user has not been deleted.")
  public String getDeletionDate() {
    return deletionDate;
  }

  public void setDeletionDate(String deletionDate) {
    this.deletionDate = deletionDate;
  }

  public UserInfo lastActiveDate(String lastActiveDate) {
    this.lastActiveDate = lastActiveDate;
    return this;
  }

   /**
   * User's last active date, in the format 'yyyy-MM-dd'. May be null if the user has not yet logged in.
   * @return lastActiveDate
  **/
  @ApiModelProperty(example = "null", value = "User's last active date, in the format 'yyyy-MM-dd'. May be null if the user has not yet logged in.")
  public String getLastActiveDate() {
    return lastActiveDate;
  }

  public void setLastActiveDate(String lastActiveDate) {
    this.lastActiveDate = lastActiveDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.userId, userInfo.userId) &&
        Objects.equals(this.registrationDate, userInfo.registrationDate) &&
        Objects.equals(this.deletionDate, userInfo.deletionDate) &&
        Objects.equals(this.lastActiveDate, userInfo.lastActiveDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, registrationDate, deletionDate, lastActiveDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    registrationDate: ").append(toIndentedString(registrationDate)).append("\n");
    sb.append("    deletionDate: ").append(toIndentedString(deletionDate)).append("\n");
    sb.append("    lastActiveDate: ").append(toIndentedString(lastActiveDate)).append("\n");
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

