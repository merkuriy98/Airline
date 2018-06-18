package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Airport;
import com.merkulov.airline.repository.converter.SqlConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportSqlConverter implements SqlConverter<Airport> {

    @Override
    public Airport convert(ResultSet resultSet) throws SQLException {
        Airport airport = new Airport();

        airport.setId(resultSet.getLong("id"));
        airport.setName(resultSet.getString("name"));
        airport.setCity(resultSet.getString("city"));
        airport.setCountry(resultSet.getString("country"));

        return airport;
    }

    public Airport convert(ResultSet resultSet, String alias) throws SQLException {
        Airport airport = new Airport();

        airport.setId(resultSet.getLong(alias + "id"));
        airport.setName(resultSet.getString(alias + "name"));
        airport.setCity(resultSet.getString(alias + "city"));
        airport.setCountry(resultSet.getString(alias + "country"));

        return airport;
    }
}
