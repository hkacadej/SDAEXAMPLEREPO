package service;

import citypojo.Cities;
import citypojo.City;
import citypojo.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.region.Region;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class LocationService {

    private static final String apiKey = "USf8KC1FwEzNQZYCCjJNhoSnFTdHQGwD";

    public List<Region> getAllRegions() throws IOException, InterruptedException {
        List<Region> regions = new ArrayList<>();

        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request
        String apiUrl = "http://dataservice.accuweather.com/locations/v1/regions?apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();

        regions = mapper.readValue(response.body(), new TypeReference<List<Region>>() {});

        return regions;

    }

    public List<Country> getAllCountriesOfRegion(String regionId) throws IOException, InterruptedException {
        List<Country> countries = new ArrayList<>();

        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request
        String apiUrl = "http://dataservice.accuweather.com/locations/v1/countries/" +
                regionId +
                "?apikey=" + apiKey;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();

        countries = mapper.readValue(response.body(), new TypeReference<List<Country>>() {});

        return countries;


    }

    public List<City> getAllCitiesOfCountry(String countryCode) throws IOException, InterruptedException {
        List<City> cities = new ArrayList<>();

        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request
        String apiUrl = "https://dataservice.accuweather.com/locations/v1/cities/"+
                countryCode+
                "?apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();

        cities = mapper.readValue(response.body(), new TypeReference<List<City>>() {});

        return cities;
    }


    public City getCityDetails(String cityId) throws IOException, InterruptedException {

        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request

        String apiUrl = "http://dataservice.accuweather.com/locations/v1/"+
                cityId+
                "?apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();

        City city = mapper.readValue(response.body(), City.class);

        return city;

    }

    public boolean doesCityExist(String cityId) throws IOException, InterruptedException {
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET Request

        String apiUrl = "http://dataservice.accuweather.com/locations/v1/"+
                cityId+
                "?apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Send request and get response as String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body() != null && !response.body().isEmpty();
    }



}
