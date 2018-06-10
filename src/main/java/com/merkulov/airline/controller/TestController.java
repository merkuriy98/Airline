package com.merkulov.airline.controller;

import com.merkulov.airline.service.TestService;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.merkulov.airline.config.ApplicationServletContextListener.TEST_SERVICE;
import static com.merkulov.airline.constant.JspConstants.*;


@WebServlet("/test")
public class TestController extends HttpServlet {
    private TestService testService;
    private static final Logger LOG = Logger.getLogger(TestController.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        testService = (TestService) config.getServletContext().getAttribute(TEST_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hello = "Hello, World!!!!";
        req.setAttribute("hello", hello);
        req.setAttribute("test", testService.getFirstTest());
        LOG.info("WORK CONTROLLER");
        req.getRequestDispatcher(TEST_JSP).forward(req, resp);
    }
}
