package com.merkulov.airline.repository;

import com.merkulov.airline.entity.Test;
import com.merkulov.airline.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TestRepository {

    Test getFirstTest(Connection connection) throws SQLException;
}
