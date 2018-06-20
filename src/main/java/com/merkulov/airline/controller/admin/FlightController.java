package com.merkulov.airline.controller.admin;

import com.merkulov.airline.service.FlightService;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.merkulov.airline.config.ApplicationServletContextListener.FLIGHT_SERVICE;
import static com.merkulov.airline.constant.JspConstants.MAIN_JSP;

@WebServlet("/admin/test")
public class FlightController extends HttpServlet{
    private static final Logger LOG = Logger.getLogger(FlightController.class);

    private FlightService flightService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        flightService = (FlightService) config.getServletContext().getAttribute(FLIGHT_SERVICE);
        LOG.info("FlightController#init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test", flightService.getAllFlight());
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
    }
}
