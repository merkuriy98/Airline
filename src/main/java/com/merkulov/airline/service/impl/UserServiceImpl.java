package com.merkulov.airline.service.impl;

import com.merkulov.airline.entity.User;
import com.merkulov.airline.repository.UserRepository;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private TransactionManager transactionManager;
    private UserRepository userRepository;

    public UserServiceImpl(TransactionManager transactionManager, UserRepository userRepository) {
        this.transactionManager = transactionManager;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return transactionManager.transaction(
                connection -> userRepository.getAllUsers(connection)
        );
    }

    @Override
    public boolean insertUser(User user) {
        return transactionManager.transaction(
                connection -> userRepository.insertUser(connection, user));
    }

    @Override
    public User authorization(String login, String password) {
        return transactionManager.transaction(
                connection -> userRepository.authorization(connection, login, password));
    }
}
