package com.merkulov.airline.repository.converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SqlConversationService {
    <T> T convert(ResultSet resultSet, Class<T> clazz) throws SQLException;

    <T> List<T> convertToList(ResultSet resultSet, Class<T> clazz) throws SQLException;
}
