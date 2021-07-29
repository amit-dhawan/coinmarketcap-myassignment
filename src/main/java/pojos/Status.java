
package pojos;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timestamp",
    "error_code",
    "error_message",
    "elapsed",
    "credit_count",
    "notice"
})
@Generated("jsonschema2pojo")
public class Status {

    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("error_code")
    private Integer errorCode;
    @JsonProperty("error_message")
    private Object errorMessage;
    @JsonProperty("elapsed")
    private Integer elapsed;
    @JsonProperty("credit_count")
    private Integer creditCount;
    @JsonProperty("notice")
    private Object notice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("error_code")
    public Integer getErrorCode() {
        return errorCode;
    }

    @JsonProperty("error_code")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("error_message")
    public Object getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("error_message")
    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("elapsed")
    public Integer getElapsed() {
        return elapsed;
    }

    @JsonProperty("elapsed")
    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    @JsonProperty("credit_count")
    public Integer getCreditCount() {
        return creditCount;
    }

    @JsonProperty("credit_count")
    public void setCreditCount(Integer creditCount) {
        this.creditCount = creditCount;
    }

    @JsonProperty("notice")
    public Object getNotice() {
        return notice;
    }

    @JsonProperty("notice")
    public void setNotice(Object notice) {
        this.notice = notice;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Status.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("errorMessage");
        sb.append('=');
        sb.append(((this.errorMessage == null)?"<null>":this.errorMessage));
        sb.append(',');
        sb.append("elapsed");
        sb.append('=');
        sb.append(((this.elapsed == null)?"<null>":this.elapsed));
        sb.append(',');
        sb.append("creditCount");
        sb.append('=');
        sb.append(((this.creditCount == null)?"<null>":this.creditCount));
        sb.append(',');
        sb.append("notice");
        sb.append('=');
        sb.append(((this.notice == null)?"<null>":this.notice));
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
        result = ((result* 31)+((this.elapsed == null)? 0 :this.elapsed.hashCode()));
        result = ((result* 31)+((this.errorMessage == null)? 0 :this.errorMessage.hashCode()));
        result = ((result* 31)+((this.errorCode == null)? 0 :this.errorCode.hashCode()));
        result = ((result* 31)+((this.creditCount == null)? 0 :this.creditCount.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.notice == null)? 0 :this.notice.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status) == false) {
            return false;
        }
        Status rhs = ((Status) other);
        return ((((((((this.elapsed == rhs.elapsed)||((this.elapsed!= null)&&this.elapsed.equals(rhs.elapsed)))&&((this.errorMessage == rhs.errorMessage)||((this.errorMessage!= null)&&this.errorMessage.equals(rhs.errorMessage))))&&((this.errorCode == rhs.errorCode)||((this.errorCode!= null)&&this.errorCode.equals(rhs.errorCode))))&&((this.creditCount == rhs.creditCount)||((this.creditCount!= null)&&this.creditCount.equals(rhs.creditCount))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.notice == rhs.notice)||((this.notice!= null)&&this.notice.equals(rhs.notice))));
    }

}
