package com.merkulov.airline.controller.converter.impl;

import com.merkulov.airline.controller.converter.RequestConverter;
import com.merkulov.airline.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class RequestToUserConverter implements RequestConverter<User> {
    @Override
    public User convert(HttpServletRequest request) {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setLogin(request.getParameter("login"));
        user.setBirthday(Date.valueOf(request.getParameter("birthday")));
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("pass1"));
        return user;
    }
}
