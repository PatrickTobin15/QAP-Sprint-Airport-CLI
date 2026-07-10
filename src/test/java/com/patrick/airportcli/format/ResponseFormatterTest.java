package com.patrick.airportcli.format;

import com.patrick.airportcli.model.AircraftAirports;
import com.patrick.airportcli.model.AircraftSummary;
import com.patrick.airportcli.model.AirportSummary;
import com.patrick.airportcli.model.CityAirports;
import com.patrick.airportcli.model.PassengerAircraft;
import com.patrick.airportcli.model.UsedAirport;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResponseFormatterTest {

    private final ResponseFormatter formatter = new ResponseFormatter();

    @Test
    void formatCitiesWithAirports_includesCityAndAirportNames() {
        AirportSummary airport = new AirportSummary();
        airport.setName("Halifax Stanfield");
        airport.setCode("YHZ");

        CityAirports city = new CityAirports();
        city.setCityName("Halifax");
        city.setAirports(List.of(airport));

        String result = formatter.formatCitiesWithAirports(List.of(city));

        assertTrue(result.contains("Halifax"));
        assertTrue(result.contains("Halifax Stanfield"));
        assertTrue(result.contains("YHZ"));
    }

    @Test
    void formatCitiesWithAirports_handlesCityWithNoAirports() {
        CityAirports city = new CityAirports();
        city.setCityName("Moncton");
        city.setAirports(Collections.emptyList());

        String result = formatter.formatCitiesWithAirports(List.of(city));

        assertTrue(result.contains("none"));
    }

    @Test
    void formatPassengersWithAircraft_includesPassengerNameAndAirline() {
        AircraftSummary aircraft = new AircraftSummary();
        aircraft.setType("737");
        aircraft.setAirlineName("Air Canada");

        PassengerAircraft passenger = new PassengerAircraft();
        passenger.setFirstName("Grace");
        passenger.setLastName("Smith");
        passenger.setAircraft(List.of(aircraft));

        String result = formatter.formatPassengersWithAircraft(List.of(passenger));

        assertTrue(result.contains("Grace Smith"));
        assertTrue(result.contains("Air Canada 737"));
    }

    @Test
    void formatAircraftWithAirports_includesAirlineAndAirportCodes() {
        AirportSummary airport = new AirportSummary();
        airport.setName("Toronto Pearson");
        airport.setCode("YYZ");

        AircraftAirports aircraft = new AircraftAirports();
        aircraft.setAirlineName("WestJet");
        aircraft.setType("A320");
        aircraft.setAirports(List.of(airport));

        String result = formatter.formatAircraftWithAirports(List.of(aircraft));

        assertTrue(result.contains("WestJet A320"));
        assertTrue(result.contains("YYZ"));
    }

    @Test
    void formatUsedAirports_includesAirportAndCity() {
        UsedAirport airport = new UsedAirport();
        airport.setName("Toronto Pearson");
        airport.setCode("YYZ");
        airport.setCityName("Toronto");

        String result = formatter.formatUsedAirports(List.of(airport));

        assertTrue(result.contains("Toronto Pearson"));
        assertTrue(result.contains("Toronto"));
    }

    @Test
    void formatUsedAirports_handlesEmptyList() {
        String result = formatter.formatUsedAirports(Collections.emptyList());

        assertTrue(result.contains("none"));
    }
}
