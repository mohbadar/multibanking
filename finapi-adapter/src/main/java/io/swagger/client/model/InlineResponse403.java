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
import io.swagger.client.model.InlineResponse403Errors;
import java.util.ArrayList;
import java.util.List;

/**
 * Response type when a service call was not successful. Contains details about the error(s) that occurred.
 */
@ApiModel(description = "Response type when a service call was not successful. Contains details about the error(s) that occurred.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse403 {
  @SerializedName("errors")
  private List<InlineResponse403Errors> errors = new ArrayList<InlineResponse403Errors>();

  @SerializedName("date")
  private String date = null;

  @SerializedName("requestId")
  private String requestId = null;

  public InlineResponse403 errors(List<InlineResponse403Errors> errors) {
    this.errors = errors;
    return this;
  }

  public InlineResponse403 addErrorsItem(InlineResponse403Errors errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * List of errors
   * @return errors
  **/
  @ApiModelProperty(example = "null", value = "List of errors")
  public List<InlineResponse403Errors> getErrors() {
    return errors;
  }

  public void setErrors(List<InlineResponse403Errors> errors) {
    this.errors = errors;
  }

  public InlineResponse403 date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Server date of when the error(s) occurred, in the format YYYY-MM-DD HH:MM:SS.sss
   * @return date
  **/
  @ApiModelProperty(example = "null", required = true, value = "Server date of when the error(s) occurred, in the format YYYY-MM-DD HH:MM:SS.sss")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public InlineResponse403 requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * ID of the request that caused this error. This is either what you have passed for the header 'X-REQUEST-ID', or an auto-generated ID in case you didn't pass any value for that header.
   * @return requestId
  **/
  @ApiModelProperty(example = "null", value = "ID of the request that caused this error. This is either what you have passed for the header 'X-REQUEST-ID', or an auto-generated ID in case you didn't pass any value for that header.")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse403 inlineResponse403 = (InlineResponse403) o;
    return Objects.equals(this.errors, inlineResponse403.errors) &&
        Objects.equals(this.date, inlineResponse403.date) &&
        Objects.equals(this.requestId, inlineResponse403.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors, date, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse403 {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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

