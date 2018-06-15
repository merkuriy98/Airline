package com.merkulov.airline.repository.impl;

import com.merkulov.airline.entity.User;
import com.merkulov.airline.exception.RepositoryException;
import com.merkulov.airline.repository.UserRepository;
import com.merkulov.airline.repository.converter.SqlConversationService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepositoryIml implements UserRepository {
    private static final Logger LOG = Logger.getLogger(UserRepositoryIml.class);

    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String INSERT_USERS = "INSERT INTO users (first_name,last_name,login,birthday,phone,password) " +
            "VALUES (?,?,?,?,?,?)";
    private static final String SELECT_USER = "SELECT * from users WHERE login = ? AND password = ?";

    private SqlConversationService sqlConversationService;

    public UserRepositoryIml(SqlConversationService sqlConversationService) {
        this.sqlConversationService = sqlConversationService;
    }

    @Override
    public List<User> getAllUsers(Connection connection) throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery(SELECT_ALL_USERS);
        return sqlConversationService.convertToList(rs, User.class);
    }

    @Override
    public boolean insertUser(Connection connection, User user) throws SQLException {
        int res = 0;
        PreparedStatement pstmt = connection.prepareStatement(INSERT_USERS);
        int k = 1;
        pstmt.setString(k++, user.getFirstName());
        pstmt.setString(k++, user.getLastName());
        pstmt.setString(k++, user.getLogin());
        pstmt.setString(k++, user.getBirthday());
        pstmt.setString(k++, user.getPhone());
        pstmt.setString(k++, user.getPassword());
        int resDB = pstmt.executeUpdate();
//        ResultSet generatedKey = pstmt.getGeneratedKeys();
//        if (generatedKey.next()) {
//            user.setId(generatedKey.getInt("id"));
//        }
        return res != resDB;
    }

    @Override
    public User authorization(Connection connection, String login, String password) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(SELECT_USER);
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setLogin(rs.getString("login"));
            user.setBirthday(rs.getString("birthday"));
            user.setPhone(rs.getString("phone"));
            user.setPassword(rs.getString("password"));
        }
        return  user;
    }
}
