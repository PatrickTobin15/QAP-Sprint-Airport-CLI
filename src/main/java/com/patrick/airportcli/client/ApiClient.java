package com.patrick.airportcli.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrick.airportcli.model.AircraftAirports;
import com.patrick.airportcli.model.CityAirports;
import com.patrick.airportcli.model.PassengerAircraft;
import com.patrick.airportcli.model.UsedAirport;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ApiClient {

    private final HttpExecutor httpExecutor;
    private final ObjectMapper objectMapper;
    private final String baseUrl;

    public ApiClient(HttpExecutor httpExecutor, String baseUrl) {
        this.httpExecutor = httpExecutor;
        this.baseUrl = baseUrl;
        this.objectMapper = new ObjectMapper();
    }

    // Q1: airports per city
    public List<CityAirports> getCitiesWithAirports() throws IOException, InterruptedException {
        String json = httpExecutor.get(baseUrl + "/api/cities/airports-summary");
        return Arrays.asList(objectMapper.readValue(json, CityAirports[].class));
    }

    // Q2: aircraft per passenger
    public List<PassengerAircraft> getPassengersWithAircraft() throws IOException, InterruptedException {
        String json = httpExecutor.get(baseUrl + "/api/passengers/aircraft-summary");
        return Arrays.asList(objectMapper.readValue(json, PassengerAircraft[].class));
    }

    // Q3: airports per aircraft
    public List<AircraftAirports> getAircraftWithAirports() throws IOException, InterruptedException {
        String json = httpExecutor.get(baseUrl + "/api/aircraft/airports-summary");
        return Arrays.asList(objectMapper.readValue(json, AircraftAirports[].class));
    }

    // Q4: airports used by passengers
    public List<UsedAirport> getAirportsUsedByPassengers() throws IOException, InterruptedException {
        String json = httpExecutor.get(baseUrl + "/api/airports/used-by-passengers");
        return Arrays.asList(objectMapper.readValue(json, UsedAirport[].class));
    }
}
