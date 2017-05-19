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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data of notification rule
 */
@ApiModel(description = "Data of notification rule")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse20016NotificationRules {
  @SerializedName("id")
  private Long id = null;

  /**
   * Trigger event type
   */
  public enum TriggerEventEnum {
    @SerializedName("NEW_ACCOUNT_BALANCE")
    NEW_ACCOUNT_BALANCE("NEW_ACCOUNT_BALANCE"),
    
    @SerializedName("NEW_TRANSACTIONS")
    NEW_TRANSACTIONS("NEW_TRANSACTIONS"),
    
    @SerializedName("BANK_LOGIN_ERROR")
    BANK_LOGIN_ERROR("BANK_LOGIN_ERROR"),
    
    @SerializedName("FOREIGN_MONEY_TRANSFER")
    FOREIGN_MONEY_TRANSFER("FOREIGN_MONEY_TRANSFER"),
    
    @SerializedName("LOW_ACCOUNT_BALANCE")
    LOW_ACCOUNT_BALANCE("LOW_ACCOUNT_BALANCE"),
    
    @SerializedName("HIGH_TRANSACTION_AMOUNT")
    HIGH_TRANSACTION_AMOUNT("HIGH_TRANSACTION_AMOUNT"),
    
    @SerializedName("CATEGORY_CASH_FLOW")
    CATEGORY_CASH_FLOW("CATEGORY_CASH_FLOW");

    private String value;

    TriggerEventEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("triggerEvent")
  private TriggerEventEnum triggerEvent = null;

  @SerializedName("params")
  private Map<String, String> params = new HashMap<String, String>();

  @SerializedName("callbackHandle")
  private String callbackHandle = null;

  @SerializedName("includeDetails")
  private Boolean includeDetails = false;

  public InlineResponse20016NotificationRules id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Notification rule identifier
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "Notification rule identifier")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public InlineResponse20016NotificationRules triggerEvent(TriggerEventEnum triggerEvent) {
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Trigger event type
   * @return triggerEvent
  **/
  @ApiModelProperty(example = "null", required = true, value = "Trigger event type")
  public TriggerEventEnum getTriggerEvent() {
    return triggerEvent;
  }

  public void setTriggerEvent(TriggerEventEnum triggerEvent) {
    this.triggerEvent = triggerEvent;
  }

  public InlineResponse20016NotificationRules params(Map<String, String> params) {
    this.params = params;
    return this;
  }

  public InlineResponse20016NotificationRules putParamsItem(String key, String paramsItem) {
    this.params.put(key, paramsItem);
    return this;
  }

   /**
   * Additional parameters that are specific to the trigger event type. Please refer to the documentation for details.
   * @return params
  **/
  @ApiModelProperty(example = "null", value = "Additional parameters that are specific to the trigger event type. Please refer to the documentation for details.")
  public Map<String, String> getParams() {
    return params;
  }

  public void setParams(Map<String, String> params) {
    this.params = params;
  }

  public InlineResponse20016NotificationRules callbackHandle(String callbackHandle) {
    this.callbackHandle = callbackHandle;
    return this;
  }

   /**
   * The string that finAPI includes into the notifications that it sends based on this rule.
   * @return callbackHandle
  **/
  @ApiModelProperty(example = "null", value = "The string that finAPI includes into the notifications that it sends based on this rule.")
  public String getCallbackHandle() {
    return callbackHandle;
  }

  public void setCallbackHandle(String callbackHandle) {
    this.callbackHandle = callbackHandle;
  }

  public InlineResponse20016NotificationRules includeDetails(Boolean includeDetails) {
    this.includeDetails = includeDetails;
    return this;
  }

   /**
   * Whether the notification messages that will be send based on this rule contain encrypted detailed data or not
   * @return includeDetails
  **/
  @ApiModelProperty(example = "null", required = true, value = "Whether the notification messages that will be send based on this rule contain encrypted detailed data or not")
  public Boolean getIncludeDetails() {
    return includeDetails;
  }

  public void setIncludeDetails(Boolean includeDetails) {
    this.includeDetails = includeDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20016NotificationRules inlineResponse20016NotificationRules = (InlineResponse20016NotificationRules) o;
    return Objects.equals(this.id, inlineResponse20016NotificationRules.id) &&
        Objects.equals(this.triggerEvent, inlineResponse20016NotificationRules.triggerEvent) &&
        Objects.equals(this.params, inlineResponse20016NotificationRules.params) &&
        Objects.equals(this.callbackHandle, inlineResponse20016NotificationRules.callbackHandle) &&
        Objects.equals(this.includeDetails, inlineResponse20016NotificationRules.includeDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, triggerEvent, params, callbackHandle, includeDetails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20016NotificationRules {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    callbackHandle: ").append(toIndentedString(callbackHandle)).append("\n");
    sb.append("    includeDetails: ").append(toIndentedString(includeDetails)).append("\n");
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

