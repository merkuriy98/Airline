package com.merkulov.airline.config;

import com.merkulov.airline.repository.TestRepository;
import com.merkulov.airline.repository.impl.TestRepositoryImpl;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.repository.transaction.impl.TransactionManagerImpl;
import com.merkulov.airline.service.impl.TestServiceImpl;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ApplicationServletContextListener implements ServletContextListener {
    public static final String TEST_SERVICE = "testService";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context listener started:");
        TransactionManager transactionManager = initTransactionManager();
        ServletContext servletContext = servletContextEvent.getServletContext();
        initService(servletContext, transactionManager);
    }

    private TransactionManager initTransactionManager() {
        try {
            return new TransactionManagerImpl(
                    (DataSource) new InitialContext().lookup("java:comp/env/jdbc/airline"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initService(ServletContext servletContext, TransactionManager transactionManager) {
        com.merkulov.airline.repository.converter.SqlConversationService sqlConversationService = new com.merkulov.airline.repository.converter.impl.SqlConversationServiceImpl();

        TestRepository testRepository = new TestRepositoryImpl(sqlConversationService);

        servletContext.setAttribute(TEST_SERVICE, new TestServiceImpl(transactionManager, testRepository));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
