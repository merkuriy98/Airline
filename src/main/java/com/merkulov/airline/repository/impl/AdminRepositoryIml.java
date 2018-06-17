package com.merkulov.airline.repository.impl;

import com.merkulov.airline.entity.Airport;
import com.merkulov.airline.entity.Flight;
import com.merkulov.airline.entity.Plane;
import com.merkulov.airline.entity.StatusFlight;
import com.merkulov.airline.repository.AdminRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryIml implements AdminRepository{
    public static final Logger LOG = Logger.getLogger(AdminRepository.class);

    private static final String SELECT_ALL_PLANES = "SELECT * FROM planes";
    private static final String SELECT_PLANE_BY_ID = "SELECT * FROM planes WHERE id = ?";
    private static final String SELECT_AIRPORT_BY_ID = "SELECT * FROM airports WHERE id = ?";
   // private static final String SELECT_ALL_FLIGHT = "SELECT (id),(number_flight),(date),(status) FROM flights";
    private static final String SELECT_ALL_FLIGHT = "SELECT * FROM flights";

    private SqlConversationService sqlConversationService;

    public AdminRepositoryIml(SqlConversationService sqlConversationService){
        this.sqlConversationService = sqlConversationService;
    }

    @Override
    public List<Flight> getAllFlight(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_FLIGHT);
        List<Flight> list = new ArrayList<>();
        while(resultSet.next()){
            Flight flight = new Flight();
            flight.setId(resultSet.getLong("id"));
            flight.setNumberFlight(resultSet.getInt("number_flight"));
            flight.setPlane(getPlane(connection,resultSet.getInt("id_plane")));
            flight.setDepartureAirport(getAirport(connection,resultSet.getInt("departure_airport")));
            flight.setArrivalAirport(getAirport(connection, resultSet.getInt("arrival_airport")));
            Timestamp sqlTimestamp = resultSet.getTimestamp("data");
            flight.setDate(sqlTimestamp.toInstant().atZone(ZoneId.systemDefault()));
            flight.setStatusFlight(StatusFlight.valueOf(resultSet.getString("status")));
            list.add(flight);
        }
        return list;
    }

    @Override
    public boolean addFlight(Connection connection, Flight flight) {
        return false;
    }

    @Override
    public boolean removeFlight(Connection connection, Flight flight) {
        return false;
    }

    private List<Plane> getListPlane(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_PLANES);
        return sqlConversationService.convertToList(resultSet,Plane.class);
    }

    private Plane getPlane (Connection connection, int id) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(SELECT_PLANE_BY_ID);
        pstmt.setLong(1, id);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next()){
            return  sqlConversationService.convert(resultSet,Plane.class);
        }
        return null;
    }

    private Airport getAirport (Connection connection, int  id) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(SELECT_AIRPORT_BY_ID);
        pstmt.setLong(1, id);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next()){
            return sqlConversationService.convert(resultSet,Airport.class);
        }
        return null;
    }
}
