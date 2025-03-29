package org.example;
import citypojo.Cities;
import citypojo.City;
import citypojo.Country;
import http.helper.HttpHelperService;
import pojo.DailyForecastMain;
import pojos.region.Region;
import service.LocationService;
import utility.DailyForecastMainUtils;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Testing LocationService

        LocationService locationService = new LocationService();

        try {
            System.out.println("Testing getAllRegions -----------------------");
            List<Region> regions = locationService.getAllRegions();
            for (Region region : regions) {
                System.out.println("Region Id : " + region.getId() + " Name : " + region.getLocalizedName());
            }

            System.out.println("Testing getAllCountriesOfRegion ------------------------");
            List<Country> countries = locationService.getAllCountriesOfRegion("EUR");
            for (Country country : countries) {
                System.out.println("Country Id : " + country.getId() + " Name : " + country.getLocalizedName());
            }

            System.out.println("Testing getAllCitiesOfCountry ------------------------");
            List<City> cities = locationService.getAllCitiesOfCountry("AL");
            for (City city : cities) {
                System.out.println("City name : " + city.getLocalizedName() + " City Code : " + city.getKey());
            }

            System.out.println("Testing getCityDetails ------------------------");
            City city = locationService.getCityDetails("6804");
            System.out.println(city);

            System.out.println("Testing doesCityExist ------------------------");

            if (locationService.doesCityExist("1122")) {
                System.out.println("City with id 1122 exists");
            }else {
                System.out.println("City with id 1122 does not exist");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void miniMenu() throws IOException, InterruptedException {

        // ask the user what does he want to do
        System.out.println("Enter 1 for city List");
        System.out.println("Enter 2 to get the weather of a city");
        System.out.println("Enter 3 to get information of a city");

        try (Scanner scanner = new Scanner(System.in)) {

            int choice = scanner.nextInt();
            if(choice == 1) {
                Cities cities = HttpHelperService.getCities();
                for (City city : cities.getCities()) {
                    System.out.println("City Name = " + city.getLocalizedName() + ", city key = " + city.getKey());
                }
            } else if (choice == 2) {
                System.out.println("Enter the city key");
                String cityKey = scanner.next();
                DailyForecastMain dailyForecastMain= HttpHelperService.getDailyForecast(cityKey);
                DailyForecastMainUtils.printDailyForecastMain(dailyForecastMain);
            } else if (choice == 3) {
                String cityKey = scanner.next();
                City city = HttpHelperService.getCityByLocationKey(cityKey);
                System.out.println(city);
            }else {
                System.out.println("Invalid choice");
            }

        }
    }

}