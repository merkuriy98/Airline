package com.merkulov.airline.controller.admin;

import com.merkulov.airline.constant.JspConstants;
import com.merkulov.airline.controller.converter.RequestConversationService;
import com.merkulov.airline.entity.Role;
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
import java.util.Objects;

import static com.merkulov.airline.config.ApplicationServletContextListener.REQUEST_CONVERSATION_SERVICE;
import static com.merkulov.airline.config.ApplicationServletContextListener.USER_SERVICE;
import static com.merkulov.airline.constant.JspConstants.REGISTRATION_JSP;

@WebServlet("/admin/registration")
public class RegistrationController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(RegistrationController.class);

    private UserService userService;
    private RequestConversationService conversationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
        conversationService = (RequestConversationService) config.getServletContext().getAttribute(REQUEST_CONVERSATION_SERVICE);
        LOG.info("RegistrationController #init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspConstants.REGISTRATION_JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = conversationService.convert(req, User.class);
        checkConfirmPassword(user, req);

        if (userService.insertUser(user)) {
            resp.sendRedirect("/index.jsp");
            LOG.info("registration выполнена успешно");
        } else {
            throw new ControllerException(REGISTRATION_JSP, ExceptionErrors.WRONG_AUTHORIZATION);
        }
    }

    private void checkConfirmPassword(User user, HttpServletRequest req) {
        String confirmPassword = req.getParameter("pass2");
        if (!Objects.equals(confirmPassword, user.getPassword())) {
            throw new ControllerException(REGISTRATION_JSP, ExceptionErrors.WRONG_CONFIRM_PASSWORD);
        }
    }
}
