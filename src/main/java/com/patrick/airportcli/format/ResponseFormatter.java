package com.patrick.airportcli.format;

import com.patrick.airportcli.model.AircraftAirports;
import com.patrick.airportcli.model.AircraftSummary;
import com.patrick.airportcli.model.AirportSummary;
import com.patrick.airportcli.model.CityAirports;
import com.patrick.airportcli.model.PassengerAircraft;
import com.patrick.airportcli.model.UsedAirport;

import java.util.List;

public class ResponseFormatter {

    public String formatCitiesWithAirports(List<CityAirports> cities) {
        StringBuilder sb = new StringBuilder("Q1: Airports per city\n");

        for (CityAirports city : cities) {
            sb.append("- ").append(city.getCityName()).append(": ");
            if (city.getAirports() == null || city.getAirports().isEmpty()) {
                sb.append("none");
            } else {
                sb.append(joinAirportNames(city.getAirports()));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String formatPassengersWithAircraft(List<PassengerAircraft> passengers) {
        StringBuilder sb = new StringBuilder("Q2: Aircraft per passenger\n");

        for (PassengerAircraft passenger : passengers) {
            sb.append("- ").append(passenger.getFirstName()).append(" ").append(passenger.getLastName()).append(": ");
            if (passenger.getAircraft() == null || passenger.getAircraft().isEmpty()) {
                sb.append("none");
            } else {
                sb.append(joinAircraftDescriptions(passenger.getAircraft()));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String formatAircraftWithAirports(List<AircraftAirports> aircraftList) {
        StringBuilder sb = new StringBuilder("Q3: Airports per aircraft\n");

        for (AircraftAirports aircraft : aircraftList) {
            sb.append("- ").append(aircraft.getAirlineName()).append(" ").append(aircraft.getType()).append(": ");
            if (aircraft.getAirports() == null || aircraft.getAirports().isEmpty()) {
                sb.append("none");
            } else {
                sb.append(joinAirportNames(aircraft.getAirports()));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String formatUsedAirports(List<UsedAirport> airports) {
        StringBuilder sb = new StringBuilder("Q4: Airports used by passengers\n");

        if (airports == null || airports.isEmpty()) {
            sb.append("none\n");
            return sb.toString();
        }

        for (UsedAirport airport : airports) {
            sb.append("- ").append(airport.getName()).append(" (").append(airport.getCode()).append(")");
            if (airport.getCityName() != null) {
                sb.append(" in ").append(airport.getCityName());
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String joinAirportNames(List<AirportSummary> airports) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < airports.size(); i++) {
            AirportSummary airport = airports.get(i);
            sb.append(airport.getName()).append(" (").append(airport.getCode()).append(")");
            if (i < airports.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private String joinAircraftDescriptions(List<AircraftSummary> aircraftList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aircraftList.size(); i++) {
            AircraftSummary aircraft = aircraftList.get(i);
            sb.append(aircraft.getAirlineName()).append(" ").append(aircraft.getType());
            if (i < aircraftList.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
