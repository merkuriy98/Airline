package com.merkulov.airline.repository.converter;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlConverter<T> {

    T convert(ResultSet resultSet) throws SQLException;
}
