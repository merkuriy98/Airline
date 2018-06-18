package com.merkulov.airline.service;

import com.merkulov.airline.entity.Flight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FlightService {
    List<Flight> getAllFlight();
    boolean addFlight(Flight flight);
    boolean removeFlight(Flight flight);
}
