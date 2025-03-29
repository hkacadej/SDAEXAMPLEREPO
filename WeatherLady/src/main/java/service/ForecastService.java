package service;

import citypojo.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.DailyForecast;
import pojo.DailyForecastMain;
import pojo.Minimum;
import pojo.Temperature;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ForecastService {

    private static final String apiKey= "USf8KC1FwEzNQZYCCjJNhoSnFTdHQGwD";

    public DailyForecastMain getForecastForOneDay(String cityId) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request

        String apiUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/"+
                cityId+
                "?apikey="+
                apiKey+
                "&metric=true";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        DailyForecastMain dfm = mapper.readValue(response.body(), DailyForecastMain.class);

        return dfm;
    }

    public List<DailyForecastMain> getForecastForFiveDays(String cityId) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request

        String apiUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/"+
                cityId+
                "?apikey="+
                apiKey+
                "&metric=true";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        List<DailyForecastMain> dfmList = mapper.readValue(response.body(),new TypeReference<List<DailyForecastMain>>() {} );

        return dfmList;
    }

    public List<DailyForecastMain> getForecastForTenDays(String cityId) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request

        String apiUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/10day/"+
                cityId+
                "?apikey="+
                apiKey+
                "&metric=true";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        List<DailyForecastMain> dfmList = mapper.readValue(response.body(),new TypeReference<List<DailyForecastMain>>() {} );

        return dfmList;
    }

    public List<DailyForecastMain> getForecastForFifteenDays(String cityId) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request

        String apiUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/15day/"+
                cityId+
                "?apikey="+
                apiKey+
                "&metric=true";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        List<DailyForecastMain> dfmList = mapper.readValue(response.body(),new TypeReference<List<DailyForecastMain>>() {} );

        return dfmList;
    }

    public void showAverageTemperatureForFifteenDays(String cityId) throws IOException, InterruptedException {
        // Get a list of Weather forecasts
        List<DailyForecastMain> dfmList = getForecastForFifteenDays(cityId);

        List<Temperature> temperatureList = dfmList.stream().map(
                (dalilyForecastMain) -> {return dalilyForecastMain.getDailyForecasts()[0].getTemperature();}
        ).toList();

        List<Minimum> minimumList = temperatureList.stream().map(temp -> temp.getMinimum()).toList();

        int totalMin = 0;
        for (Minimum minimum : minimumList){
            totalMin += minimum.getValue();
        }
        System.out.println("Average Temperature for Fifteen days: " + totalMin/dfmList.size());

    }

    // OTHER METHODS AS NEEDED
}
