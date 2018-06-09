package com.merkulov.airline.repository;

import com.merkulov.airline.entity.Test;

import java.sql.Connection;
import java.sql.SQLException;

public interface TestRepository {

    Test getFirstTest(Connection connection) throws SQLException;
}
