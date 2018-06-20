package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Plane;
import com.merkulov.airline.repository.converter.SqlConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneSqlConverter implements SqlConverter<Plane> {

    @Override
    public Plane convert(ResultSet resultSet) throws SQLException {
        Plane plane = new Plane();

        plane.setId(resultSet.getLong("id"));
        plane.setName(resultSet.getString("name"));
        plane.setModel(resultSet.getString("model"));

        return plane;
    }

    public Plane convert(ResultSet resultSet, String alias) throws SQLException {
        Plane plane = new Plane();

        plane.setId(resultSet.getLong("id" + alias));
        plane.setName(resultSet.getString("name" + alias));
        plane.setModel(resultSet.getString("model" + alias));

        return plane;
    }
}
