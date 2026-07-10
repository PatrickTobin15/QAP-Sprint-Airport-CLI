package com.patrick.airportcli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityAirports {

    private Long cityId;
    private String cityName;
    private List<AirportSummary> airports;

    public CityAirports() {
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<AirportSummary> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportSummary> airports) {
        this.airports = airports;
    }
}
