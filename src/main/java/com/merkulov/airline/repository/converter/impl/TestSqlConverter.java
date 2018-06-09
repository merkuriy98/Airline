package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSqlConverter implements com.merkulov.airline.repository.converter.SqlConverter<com.merkulov.airline.entity.Test> {


    @Override
    public Test convert(ResultSet resultSet) throws SQLException {
        Test test = new Test();
        test.setId(resultSet.getInt("id"));
        return test;
    }
}
