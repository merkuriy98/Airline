package com.merkulov.airline.controller;

import com.merkulov.airline.entity.User;
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
import static com.merkulov.airline.constant.JspConstants.REGISTRATION_JSP;

@WebServlet("/entry")
public class Entry extends HttpServlet {
    private UserService userService;
    private static final Logger LOG = Logger.getLogger(Entry.class);

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
        LOG.info("Entry #init");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("registration") != null) {
            registration(req, resp);
            LOG.info("registration finished work!!");
        }
        if(req.getParameter("entry") != null){
            autorization(req,resp);
            LOG.info("autorization finished work !");
        }

    }

    private void registration(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getAttribute("user");
        if(userService.insertUser(user)) {
            resp.sendRedirect("/index.jsp");
            LOG.info("registration выполнена успешно");
        }else
            resp.sendRedirect(REGISTRATION_JSP);
    }

    private void autorization(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.authorization(login,password);
        req.getSession().setAttribute("user",user);

        req.getRequestDispatcher(MAIN_JSP).forward(req,resp);
    }
}
