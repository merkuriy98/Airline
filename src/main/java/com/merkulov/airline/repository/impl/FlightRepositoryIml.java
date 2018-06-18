package com.merkulov.airline.repository.impl;

import com.merkulov.airline.entity.Airport;
import com.merkulov.airline.entity.Flight;
import com.merkulov.airline.entity.Plane;
import com.merkulov.airline.entity.StatusFlight;
import com.merkulov.airline.repository.FlightRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightRepositoryIml implements FlightRepository {

    private static final String SELECT_ALL_FLIGHT = "SELECT * FROM flights\n" +
            "INNER JOIN planes ON flights.id_plane = planes.id\n" +
            "INNER JOIN airports a1 ON flights.departure_airport = a1.id\n" +
            "INNER JOIN airports a2  ON flights.arrival_aiport = a2.id";
    private static final String INSERT_FLIGHT = "INSERT INTO flights" +
            " (number_flight, id_plane, departure_airport, arrival_aiport, date, status)" +
            " VALUE (?, ?, ?, ?, ?, ?)";

    private SqlConversationService sqlConversationService;

    public FlightRepositoryIml(SqlConversationService sqlConversationService) {
        this.sqlConversationService = sqlConversationService;
    }

    @Override
    public List<Flight> getAllFlight(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_FLIGHT);
        return sqlConversationService.convertToList(resultSet, Flight.class);
    }

    @Override
    public boolean addFlight(Connection connection, Flight flight) throws SQLException {
        int res = 0;
        PreparedStatement pstmt = connection.prepareStatement(INSERT_FLIGHT);
        int k = 1;
        pstmt.setInt(k++, flight.getNumberFlight());
        pstmt.setLong(k++, flight.getPlane().getId());
        pstmt.setLong(k++, flight.getDepartureAirport().getId());
        pstmt.setLong(k++, flight.getArrivalAirport().getId());

        ZonedDateTime zonedDateTime = flight.getDate();
        Timestamp timestamp = Timestamp.from(zonedDateTime.toInstant());
        pstmt.setTimestamp(k++, timestamp);
        pstmt.setString(k++, flight.getStatusFlight().name());
        int resDB = pstmt.executeUpdate();

        return res != resDB;
    }

    @Override
    public boolean removeFlight(Connection connection, Flight flight) {
        return false;
    }
}
