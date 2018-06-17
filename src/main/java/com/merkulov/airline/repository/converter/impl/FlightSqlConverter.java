package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Flight;
import com.merkulov.airline.entity.Plane;
import com.merkulov.airline.entity.StatusFlight;
import com.merkulov.airline.repository.converter.SqlConversationService;
import com.merkulov.airline.repository.converter.SqlConverter;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlightSqlConverter implements SqlConverter<Flight> {

    @Override
    public Flight convert(ResultSet resultSet) throws SQLException {
//        Flight flight = new Flight();
//
//        flight.setId(resultSet.getLong("id"));
//        flight.setNumberFlight(resultSet.getInt("number_flight"));
//        Timestamp sqlTimestamp = resultSet.getTimestamp("data");
//        flight.setDate(sqlTimestamp.toInstant().atZone(ZoneId.systemDefault()));
//        flight.setStatusFlight(StatusFlight.valueOf(resultSet.getString("status")));

        return null;
    }
}
