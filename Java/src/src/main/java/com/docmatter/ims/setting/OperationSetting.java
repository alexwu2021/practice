
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
    "ActionTargetSetting",
    "ActionSettings"
})
@Generated("jsonschema2pojo")
public class OperationSetting {

    @JsonProperty("ActionTargetSetting")
    private ActionTargetSetting actionTargetSetting;
    @JsonProperty("ActionSettings")
    private List<ActionSetting> actionSettings = new ArrayList<ActionSetting>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ActionTargetSetting")
    public ActionTargetSetting getActionTargetSetting() {
        return actionTargetSetting;
    }

    @JsonProperty("ActionTargetSetting")
    public void setActionTargetSetting(ActionTargetSetting actionTargetSetting) {
        this.actionTargetSetting = actionTargetSetting;
    }

    public OperationSetting withActionTargetSetting(ActionTargetSetting actionTargetSetting) {
        this.actionTargetSetting = actionTargetSetting;
        return this;
    }

    @JsonProperty("ActionSettings")
    public List<ActionSetting> getActionSettings() {
        return actionSettings;
    }

    @JsonProperty("ActionSettings")
    public void setActionSettings(List<ActionSetting> actionSettings) {
        this.actionSettings = actionSettings;
    }

    public OperationSetting withActionSettings(List<ActionSetting> actionSettings) {
        this.actionSettings = actionSettings;
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

    public OperationSetting withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OperationSetting.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("actionTargetSetting");
        sb.append('=');
        sb.append(((this.actionTargetSetting == null)?"<null>":this.actionTargetSetting));
        sb.append(',');
        sb.append("actionSettings");
        sb.append('=');
        sb.append(((this.actionSettings == null)?"<null>":this.actionSettings));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.actionTargetSetting == null)? 0 :this.actionTargetSetting.hashCode()));
        result = ((result* 31)+((this.actionSettings == null)? 0 :this.actionSettings.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OperationSetting) == false) {
            return false;
        }
        OperationSetting rhs = ((OperationSetting) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.actionTargetSetting == rhs.actionTargetSetting)||((this.actionTargetSetting!= null)&&this.actionTargetSetting.equals(rhs.actionTargetSetting))))&&((this.actionSettings == rhs.actionSettings)||((this.actionSettings!= null)&&this.actionSettings.equals(rhs.actionSettings))));
    }

}
