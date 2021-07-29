
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
    "id",
    "name",
    "symbol",
    "slug",
    "rank",
    "is_active",
    "first_historical_data",
    "last_historical_data",
    "platform"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("is_active")
    private Integer isActive;
    @JsonProperty("first_historical_data")
    private String firstHistoricalData;
    @JsonProperty("last_historical_data")
    private String lastHistoricalData;
    @JsonProperty("platform")
    private Object platform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("is_active")
    public Integer getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("first_historical_data")
    public String getFirstHistoricalData() {
        return firstHistoricalData;
    }

    @JsonProperty("first_historical_data")
    public void setFirstHistoricalData(String firstHistoricalData) {
        this.firstHistoricalData = firstHistoricalData;
    }

    @JsonProperty("last_historical_data")
    public String getLastHistoricalData() {
        return lastHistoricalData;
    }

    @JsonProperty("last_historical_data")
    public void setLastHistoricalData(String lastHistoricalData) {
        this.lastHistoricalData = lastHistoricalData;
    }

    @JsonProperty("platform")
    public Object getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(Object platform) {
        this.platform = platform;
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
        sb.append(Datum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("symbol");
        sb.append('=');
        sb.append(((this.symbol == null)?"<null>":this.symbol));
        sb.append(',');
        sb.append("slug");
        sb.append('=');
        sb.append(((this.slug == null)?"<null>":this.slug));
        sb.append(',');
        sb.append("rank");
        sb.append('=');
        sb.append(((this.rank == null)?"<null>":this.rank));
        sb.append(',');
        sb.append("isActive");
        sb.append('=');
        sb.append(((this.isActive == null)?"<null>":this.isActive));
        sb.append(',');
        sb.append("firstHistoricalData");
        sb.append('=');
        sb.append(((this.firstHistoricalData == null)?"<null>":this.firstHistoricalData));
        sb.append(',');
        sb.append("lastHistoricalData");
        sb.append('=');
        sb.append(((this.lastHistoricalData == null)?"<null>":this.lastHistoricalData));
        sb.append(',');
        sb.append("platform");
        sb.append('=');
        sb.append(((this.platform == null)?"<null>":this.platform));
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
        result = ((result* 31)+((this.symbol == null)? 0 :this.symbol.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.rank == null)? 0 :this.rank.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.isActive == null)? 0 :this.isActive.hashCode()));
        result = ((result* 31)+((this.lastHistoricalData == null)? 0 :this.lastHistoricalData.hashCode()));
        result = ((result* 31)+((this.slug == null)? 0 :this.slug.hashCode()));
        result = ((result* 31)+((this.platform == null)? 0 :this.platform.hashCode()));
        result = ((result* 31)+((this.firstHistoricalData == null)? 0 :this.firstHistoricalData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum) == false) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return (((((((((((this.symbol == rhs.symbol)||((this.symbol!= null)&&this.symbol.equals(rhs.symbol)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.rank == rhs.rank)||((this.rank!= null)&&this.rank.equals(rhs.rank))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.isActive == rhs.isActive)||((this.isActive!= null)&&this.isActive.equals(rhs.isActive))))&&((this.lastHistoricalData == rhs.lastHistoricalData)||((this.lastHistoricalData!= null)&&this.lastHistoricalData.equals(rhs.lastHistoricalData))))&&((this.slug == rhs.slug)||((this.slug!= null)&&this.slug.equals(rhs.slug))))&&((this.platform == rhs.platform)||((this.platform!= null)&&this.platform.equals(rhs.platform))))&&((this.firstHistoricalData == rhs.firstHistoricalData)||((this.firstHistoricalData!= null)&&this.firstHistoricalData.equals(rhs.firstHistoricalData))));
    }

}
