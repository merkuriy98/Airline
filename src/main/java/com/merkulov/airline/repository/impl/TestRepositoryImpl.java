package com.merkulov.airline.repository.impl;

import com.merkulov.airline.entity.Test;
import com.merkulov.airline.repository.TestRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRepositoryImpl implements TestRepository {
    private static final String SELECT_TEST = "select * from test";

    private SqlConversationService sqlConversationService;

    public TestRepositoryImpl(SqlConversationService sqlConversationService) {
        this.sqlConversationService = sqlConversationService;
    }

    @Override
    public Test getFirstTest(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_TEST);

        return sqlConversationService.convertToList(resultSet, Test.class).get(0);

    }
}
