package com.patrick.airportcli;

import com.patrick.airportcli.client.ApiClient;
import com.patrick.airportcli.client.HttpExecutor;
import com.patrick.airportcli.client.JavaHttpExecutor;
import com.patrick.airportcli.format.ResponseFormatter;

public class Main {

    private static final String DEFAULT_BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        String baseUrl = args.length > 0 ? args[0] : DEFAULT_BASE_URL;

        HttpExecutor httpExecutor = new JavaHttpExecutor();
        ApiClient apiClient = new ApiClient(httpExecutor, baseUrl);
        ResponseFormatter formatter = new ResponseFormatter();

        System.out.println("Connecting to " + baseUrl + "\n");

        try {
            System.out.println(formatter.formatCitiesWithAirports(apiClient.getCitiesWithAirports()));
            System.out.println(formatter.formatPassengersWithAircraft(apiClient.getPassengersWithAircraft()));
            System.out.println(formatter.formatAircraftWithAirports(apiClient.getAircraftWithAirports()));
            System.out.println(formatter.formatUsedAirports(apiClient.getAirportsUsedByPassengers()));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Is the API running at " + baseUrl + "?");
        }
    }
}
