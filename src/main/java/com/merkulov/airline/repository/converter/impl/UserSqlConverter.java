package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Role;
import com.merkulov.airline.entity.User;
import com.merkulov.airline.repository.converter.SqlConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSqlConverter implements SqlConverter<User> {

    @Override
    public User convert(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setRole(Role.valueOf(resultSet.getString("role_name")));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setLogin(resultSet.getString("login"));
        user.setBirthday(resultSet.getDate("birthday"));
        user.setPhone(resultSet.getString("phone"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }
}
