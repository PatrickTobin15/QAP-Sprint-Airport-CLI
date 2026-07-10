package com.patrick.airportcli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AircraftAirports {

    private Long aircraftId;
    private String type;
    private String airlineName;
    private List<AirportSummary> airports;

    public AircraftAirports() {
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<AirportSummary> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportSummary> airports) {
        this.airports = airports;
    }
}
