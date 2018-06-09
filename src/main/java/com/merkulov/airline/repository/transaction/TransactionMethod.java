package com.merkulov.airline.repository.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public interface TransactionMethod<T> {

    T execute(Connection connection) throws SQLException;
}
