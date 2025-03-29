package pojos.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("LocalizedName")
    private String localizedName;

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id='" + id + '\'' +
                ", localizedName='" + localizedName + '\'' +
                '}';
    }
}
