package com.merkulov.airline.entity;

import java.time.ZonedDateTime;
import java.util.Set;

public class Flight extends AbstactEntity<Long> {
    private int numberFlight;
    private Plane plane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private ZonedDateTime date;
    private StatusFlight statusFlight;
    private Set<Employee> brigade;

    public int getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(int numberFlight) {
        this.numberFlight = numberFlight;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public StatusFlight getStatusFlight() {
        return statusFlight;
    }

    public void setStatusFlight(StatusFlight statusFlight) {
        this.statusFlight = statusFlight;
    }

    public Set<Employee> getBrigade() {
        return brigade;
    }

    public void setBrigade(Set<Employee> brigade) {
        this.brigade = brigade;
    }
}
