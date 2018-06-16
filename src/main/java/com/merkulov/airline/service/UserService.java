package com.merkulov.airline.service;

import com.merkulov.airline.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean insertUser(User user);

    User authorization(String login, String password);
}
