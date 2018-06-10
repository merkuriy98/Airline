package com.merkulov.airline.config;

import com.merkulov.airline.repository.TestRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;
import com.merkulov.airline.repository.converter.impl.SqlConversationServiceImpl;
import com.merkulov.airline.repository.impl.TestRepositoryImpl;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.repository.transaction.impl.TransactionManagerImpl;
import com.merkulov.airline.service.impl.TestServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ApplicationServletContextListener implements ServletContextListener {
    public static final String TEST_SERVICE = "testService";
    private static final Logger LOG = Logger.getLogger(ApplicationServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        TransactionManager transactionManager = initTransactionManager();
        ServletContext servletContext = servletContextEvent.getServletContext();
        initService(servletContext, transactionManager);
    }

    private TransactionManager initTransactionManager() {
        try {
            return new TransactionManagerImpl(
                    (DataSource) new InitialContext().lookup("java:comp/env/jdbc/airline"));
        } catch (NamingException e) {
            e.getMessage();
        }
        return null;
    }

    private void initService(ServletContext servletContext, TransactionManager transactionManager) {
        SqlConversationService sqlConversationService = new SqlConversationServiceImpl();

        TestRepository testRepository = new TestRepositoryImpl(sqlConversationService);

        servletContext.setAttribute(TEST_SERVICE, new TestServiceImpl(transactionManager, testRepository));

        String pref = servletContext.getRealPath("/" + "WEB-INF/log4j.properties");
        PropertyConfigurator.configure(pref);
        LOG.info("#initService finished work");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
