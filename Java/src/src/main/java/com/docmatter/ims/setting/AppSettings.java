
package com.docmatter.ims.setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "OperationSettings"
})
@Generated("jsonschema2pojo")
public class AppSettings {

    @JsonProperty("OperationSettings")
    private List<OperationSetting> operationSettings = new ArrayList<OperationSetting>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("OperationSettings")
    public List<OperationSetting> getOperationSettings() {
        return operationSettings;
    }

    @JsonProperty("OperationSettings")
    public void setOperationSettings(List<OperationSetting> operationSettings) {
        this.operationSettings = operationSettings;
    }

    public AppSettings withOperationSettings(List<OperationSetting> operationSettings) {
        this.operationSettings = operationSettings;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AppSettings withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AppSettings.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("operationSettings");
        sb.append('=');
        sb.append(((this.operationSettings == null)?"<null>":this.operationSettings));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.operationSettings == null)? 0 :this.operationSettings.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AppSettings) == false) {
            return false;
        }
        AppSettings rhs = ((AppSettings) other);
        return (((this.operationSettings == rhs.operationSettings)||((this.operationSettings!= null)&&this.operationSettings.equals(rhs.operationSettings)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
