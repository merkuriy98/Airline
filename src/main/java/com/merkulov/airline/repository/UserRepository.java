package com.merkulov.airline.repository;

import com.merkulov.airline.entity.User;
import com.merkulov.airline.exception.RepositoryException;
import com.merkulov.airline.repository.converter.impl.SqlConversationServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> getAllUsers(Connection connection) throws SQLException;
    boolean insertUser(Connection connection, User user) throws SQLException;
}
