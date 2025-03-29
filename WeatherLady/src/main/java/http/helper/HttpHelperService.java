package http.helper;

import citypojo.Cities;
import citypojo.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.DailyForecastMain;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpHelperService {

    public static Cities getCities() throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        String apiKey = "NpLPcZ005Dh9cqq18FUX1vJg0zFRgsVW";
        // Create HTTP GET Request
        System.out.println("Building Request");
        String apiUrl = "https://dataservice.accuweather.com/locations/v1/cities/AL?apikey=" + apiKey;

        //http://dataservice.accuweather.com/locations/v1/cities/AL/search?apikey=YOUR_API_KEY
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        System.out.println("Sending request : " + request.toString());
        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Received response with status: " + response.statusCode());
        // Print raw JSON response
        System.out.println("Raw JSON Response: " + response.body());

        ObjectMapper mapper = new ObjectMapper();

            List<City> citiesList = mapper.readValue(response.body(), new TypeReference<List<City>>() {});

        Cities cities = new Cities();

        cities.setCities(citiesList);
        System.out.println(cities);

        return cities;
    }

    public static DailyForecastMain getDailyForecast(String locationCode) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();


        // Create HTTP GET Request
        System.out.println("Building Request");
        String apiUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + locationCode + "?apikey=NpLPcZ005Dh9cqq18FUX1vJg0zFRgsVW";

        //http://dataservice.accuweather.com/locations/v1/cities/AL/search?apikey=YOUR_API_KEY
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        System.out.println("Sending request : " + request.toString());
        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println("Received response with status: " + response.statusCode());
        // Print raw JSON response
        //System.out.println("Raw JSON Response: " + response.body());

        ObjectMapper mapper = new ObjectMapper();

        DailyForecastMain dailyForecastMain = mapper.readValue(response.body(), DailyForecastMain.class);

        return dailyForecastMain;
    }

    public static City getCityByLocationKey(String locationKey) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        String apiKey = "NpLPcZ005Dh9cqq18FUX1vJg0zFRgsVW";
        // Create HTTP GET Request
        System.out.println("Building Request");
        String apiUrl = "http://dataservice.accuweather.com/locations/v1/" + locationKey +"?apikey=" + apiKey;

        //http://dataservice.accuweather.com/locations/v1/cities/AL/search?apikey=YOUR_API_KEY
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        System.out.println("Sending request : " + request.toString());
        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Received response with status: " + response.statusCode());
        // Print raw JSON response
        System.out.println("Raw JSON Response: " + response.body());

        ObjectMapper mapper = new ObjectMapper();

        City city = mapper.readValue(response.body(), City.class);

        return city;
    }
}
