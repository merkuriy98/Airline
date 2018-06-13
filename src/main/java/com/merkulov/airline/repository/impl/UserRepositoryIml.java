package com.merkulov.airline.repository.impl;

import com.merkulov.airline.entity.User;
import com.merkulov.airline.repository.UserRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryIml implements UserRepository{
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";

    private SqlConversationService sqlConversationService;

    public UserRepositoryIml(SqlConversationService sqlConversationService) {
        this.sqlConversationService = sqlConversationService;
    }

    @Override
    public List<User> getAllusers(Connection connection) throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery(SELECT_ALL_USERS);

        return sqlConversationService.convertToList(rs,User.class);
    }
}
