package com.merkulov.airline.controller.admin;

import com.merkulov.airline.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.merkulov.airline.config.ApplicationServletContextListener.USER_SERVICE;
import static com.merkulov.airline.constant.JspConstants.MAIN_JSP;

@WebServlet("/admin/user")
public class UserController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UserController.class);

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
        LOG.info("UserController init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("user", userService.getAllUsers());
        req.getRequestDispatcher(MAIN_JSP).forward(req, resp);
    }
}
