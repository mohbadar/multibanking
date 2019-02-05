/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.64.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.KeywordRule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for keyword rules
 */
@ApiModel(description = "Container for keyword rules")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-05T12:19:21.458Z")
public class KeywordRuleList {
  @SerializedName("keywordRules")
  private List<KeywordRule> keywordRules = new ArrayList<KeywordRule>();

  public KeywordRuleList keywordRules(List<KeywordRule> keywordRules) {
    this.keywordRules = keywordRules;
    return this;
  }

  public KeywordRuleList addKeywordRulesItem(KeywordRule keywordRulesItem) {
    this.keywordRules.add(keywordRulesItem);
    return this;
  }

   /**
   * List of keyword rules
   * @return keywordRules
  **/
  @ApiModelProperty(required = true, value = "List of keyword rules")
  public List<KeywordRule> getKeywordRules() {
    return keywordRules;
  }

  public void setKeywordRules(List<KeywordRule> keywordRules) {
    this.keywordRules = keywordRules;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeywordRuleList keywordRuleList = (KeywordRuleList) o;
    return Objects.equals(this.keywordRules, keywordRuleList.keywordRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keywordRules);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeywordRuleList {\n");
    
    sb.append("    keywordRules: ").append(toIndentedString(keywordRules)).append("\n");
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
