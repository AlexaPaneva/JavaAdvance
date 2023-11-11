package javaAdvanced.setAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
                countriesDataByContinent = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            countriesDataByContinent.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> citiesByCountry
                    = countriesDataByContinent.get(continent);

            citiesByCountry.putIfAbsent(country, new ArrayList<>());
            List<String> cities = citiesByCountry.get(country);
            cities.add(city);
        }
        countriesDataByContinent.forEach((continent, countries) -> {
            System.out.println(continent + ":");

            countries.forEach((country, cities) -> {

                String joinedCities = String.join(", ", cities);

                System.out.println("  " + country + " -> " + joinedCities);
            });
        });
    }
}
