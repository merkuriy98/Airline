package com.merkulov.airline.repository;

import com.merkulov.airline.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> getAllusers(Connection connection) throws SQLException;
}
