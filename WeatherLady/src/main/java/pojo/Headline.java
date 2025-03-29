package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {

    @JsonProperty("EffectiveDate")
    private LocalDate effectiveDate;

    @JsonProperty("EffectiveEpochDate")
    private String effectiveEpochDate;

    @JsonProperty("Severity")
    private int severity;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("EndDate")
    private String endDate;

    @JsonProperty("EndEpochDate")
    private long endEpochDate;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveEpochDate() {
        return effectiveEpochDate;
    }

    public void setEffectiveEpochDate(String effectiveEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getEndEpochDate() {
        return endEpochDate;
    }

    public void setEndEpochDate(long endEpochDate) {
        this.endEpochDate = endEpochDate;
    }

    @Override
    public String toString() {
        return "Headline{" +
                "effectiveDate='" + effectiveDate + '\'' +
                ", effectiveEpochDate='" + effectiveEpochDate + '\'' +
                ", severity=" + severity +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endEpochDate=" + endEpochDate +
                '}';
    }
}
