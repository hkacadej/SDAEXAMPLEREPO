package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("EpochDate")
    private long epochDate;

    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("Day")
    private Day day;

    @JsonProperty("Night")
    private Night night;

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(long epochDate) {
        this.epochDate = epochDate;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Night getNight() {
        return night;
    }

    public void setNight(Night night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "date='" + date + '\'' +
                ", epochDate=" + epochDate +
                ", temperature=" + temperature +
                ", day=" + day +
                ", night=" + night +
                '}';
    }
}
