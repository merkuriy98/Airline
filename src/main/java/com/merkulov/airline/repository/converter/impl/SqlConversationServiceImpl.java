package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlConversationServiceImpl implements com.merkulov.airline.repository.converter.SqlConversationService {
    private Map<Class, com.merkulov.airline.repository.converter.SqlConverter> converters;

    public SqlConversationServiceImpl() {
        converters = new HashMap<>();
        converters.put(Test.class, new TestSqlConverter());
    }

    @Override
    public <T> T convert(ResultSet resultSet, Class<T> clazz) throws SQLException {
        return (T) converters.get(clazz).convert(resultSet);
    }

    @Override
    public <T> List<T> convertToList(ResultSet resultSet, Class<T> clazz) throws SQLException {
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(convert(resultSet, clazz));
        }
        return list;
    }
}
