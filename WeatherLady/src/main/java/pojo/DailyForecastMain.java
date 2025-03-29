package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class DailyForecastMain {

    @JsonProperty("Headline")
    private Headline headline;

    @JsonProperty("DailyForecasts")
    private DailyForecast[] dailyForecasts;

    public DailyForecast[] getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(DailyForecast[] dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "DailyForecastMain{" +
                "headline=" + headline +
                ", dailyForecasts=" + Arrays.toString(dailyForecasts) +
                '}';
    }
}
