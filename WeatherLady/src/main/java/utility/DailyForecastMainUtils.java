package utility;

import pojo.DailyForecast;
import pojo.DailyForecastMain;

public class DailyForecastMainUtils {
    public static void printDailyForecastMain(DailyForecastMain dailyForecastMain) {
        System.out.println("Date : " + dailyForecastMain.getHeadline().getEffectiveDate());
        System.out.println("Message : " + dailyForecastMain.getHeadline().getText());
        for (DailyForecast dailyForecast : dailyForecastMain.getDailyForecasts()) {
            System.out.println("Day : " + dailyForecast.getDay().getIconPhrase());
            System.out.println("Temperature max : " + dailyForecast.getTemperature().getMaximum().getValue() + " " + dailyForecast.getTemperature().getMaximum().getUnit());
            System.out.println("Temperature min : " + dailyForecast.getTemperature().getMinimum().getValue() + " " + dailyForecast.getTemperature().getMinimum().getUnit());

        }
    }
}
