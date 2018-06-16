package com.merkulov.airline.config;

import com.merkulov.airline.controller.converter.impl.RequestConversationServiceImpl;
import com.merkulov.airline.repository.UserRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;
import com.merkulov.airline.repository.converter.impl.SqlConversationServiceImpl;
import com.merkulov.airline.repository.impl.UserRepositoryIml;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.repository.transaction.impl.TransactionManagerImpl;
import com.merkulov.airline.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ApplicationServletContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(ApplicationServletContextListener.class);

    public static final String USER_SERVICE = "userService";
    public static final String REQUEST_CONVERSATION_SERVICE = "requestConversationService";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        TransactionManager transactionManager = initTransactionManager();
        ServletContext servletContext = servletContextEvent.getServletContext();
        initService(servletContext, transactionManager);
        initRequestConversationService(servletContext);
    }

    private void initRequestConversationService(ServletContext servletContext) {
        servletContext.setAttribute(REQUEST_CONVERSATION_SERVICE, new RequestConversationServiceImpl());
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

        UserRepository userRepository = new UserRepositoryIml(sqlConversationService);
        servletContext.setAttribute(USER_SERVICE, new UserServiceImpl(transactionManager, userRepository));

        String pref = servletContext.getRealPath("/" + "WEB-INF/log4j.properties");
        PropertyConfigurator.configure(pref);
        LOG.info("#initService finished work");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
