package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Flight;
import com.merkulov.airline.entity.StatusFlight;
import com.merkulov.airline.repository.converter.SqlConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;

public class FlightSqlConverter implements SqlConverter<Flight> {

    private AirportSqlConverter airportSqlConverter = new AirportSqlConverter();
    private PlaneSqlConverter planeSqlConverter = new PlaneSqlConverter();

    @Override
    public Flight convert(ResultSet resultSet) throws SQLException {
        Flight flight = new Flight();

        flight.setId(resultSet.getLong( "id_f"));
        flight.setNumberFlight(resultSet.getInt( "number_flight"));
        flight.setPlane(planeSqlConverter.convert(resultSet, "_p"));
        flight.setDepartureAirport(airportSqlConverter.convert(resultSet,"_a1"));
        flight.setArrivalAirport(airportSqlConverter.convert(resultSet, "_a2"));

        Timestamp sqlTimestamp = resultSet.getTimestamp( "date");

        flight.setDate(sqlTimestamp.toInstant().atZone(ZoneOffset.UTC));
        flight.setStatusFlight(StatusFlight.valueOf(resultSet.getString("status")));

        return flight;
    }
}
