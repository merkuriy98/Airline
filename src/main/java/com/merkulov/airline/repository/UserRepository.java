package com.merkulov.airline.repository;

import com.merkulov.airline.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> getAllUsers(Connection connection) throws SQLException;

    boolean insertUser(Connection connection, User user) throws SQLException;

    User authorization(Connection connection, String login, String password) throws SQLException;
}
