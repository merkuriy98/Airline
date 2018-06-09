package com.merkulov.airline.repository.transaction.impl;

import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.repository.transaction.TransactionMethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManagerImpl implements TransactionManager {
    private DataSource dataSource;

    public TransactionManagerImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public <T> T transaction(TransactionMethod<T> transactionMethod) {
        try {
            Connection connection = dataSource.getConnection();
            return transaction(transactionMethod, connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();//DataSourceException
        }
    }

    private <T> T transaction(TransactionMethod<T> transactionMethod, Connection connection) throws SQLException {
        try {
            connection.setAutoCommit(false);
            T t = transactionMethod.execute(connection);
            connection.commit();
            return t;
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            throw new RuntimeException();//RepositoryException
        }

    }
}
