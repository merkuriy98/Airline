package com.merkulov.airline.controller;

import com.merkulov.airline.constant.JspConstants;
import com.merkulov.airline.entity.User;
import com.merkulov.airline.exception.ControllerException;
import com.merkulov.airline.exception.ExceptionErrors;
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

@WebServlet("/authorization")
class AuthorizationController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AuthorizationController.class);

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        LOG.info("AuthorizationController #init");
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.authorization(login, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher(MAIN_JSP).forward(req, resp);
        } else {
            throw new ControllerException(JspConstants.INDEX, ExceptionErrors.WRONG_DATA);
        }
    }
}
