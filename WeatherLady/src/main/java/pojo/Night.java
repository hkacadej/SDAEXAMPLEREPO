package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Night {
    @JsonProperty("Icon")
    private int Icon;

    @JsonProperty("IconPhrase")
    private String IconPhrase;

    @JsonProperty("HasPrecipitation")
    private boolean HasPrecipitation;

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    @Override
    public String toString() {
        return "Night{" +
                "Icon=" + Icon +
                ", IconPhrase='" + IconPhrase + '\'' +
                ", HasPrecipitation=" + HasPrecipitation +
                '}';
    }
}
