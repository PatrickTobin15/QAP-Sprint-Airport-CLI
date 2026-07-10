package com.patrick.airportcli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PassengerAircraft {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private List<AircraftSummary> aircraft;

    public PassengerAircraft() {
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AircraftSummary> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<AircraftSummary> aircraft) {
        this.aircraft = aircraft;
    }
}
