package com.merkulov.airline.repository;

import com.merkulov.airline.entity.Flight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FlightRepository {
    List<Flight> getAllFlight(Connection connection) throws SQLException;
    boolean addFlight(Connection connection,Flight flight) throws SQLException;
    boolean removeFlight(Connection connection,Flight flight);

}
