package com.merkulov.airline.repository.transaction.impl;

import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.repository.transaction.TransactionMethod;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManagerImpl implements TransactionManager {
    private DataSource dataSource;
    private static final Logger LOG = Logger.getLogger(TransactionManager.class);

    public TransactionManagerImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public <T> T transaction(TransactionMethod<T> transactionMethod) {
        try {
            Connection connection = dataSource.getConnection();
            LOG.info("communication with the DB is established");
            return transaction(transactionMethod, connection);
        } catch (SQLException e) {
            LOG.debug("Error SQL Connection " + e.getMessage());
            throw new RuntimeException();//DataSourceException
        }
    }

    private <T> T transaction(TransactionMethod<T> transactionMethod, Connection connection) throws SQLException {
        try {
            connection.setAutoCommit(false);
            T t = transactionMethod.execute(connection);
            connection.commit();
            LOG.info("transact has commit");
            return t;
        } catch (SQLException e) {
            connection.rollback();
            LOG.warn("Error, transact has rollback" + e.getMessage());
            throw new RuntimeException();//RepositoryException
        }

    }
}
