package com.merkulov.airline.controller.converter;

import javax.servlet.http.HttpServletRequest;

public interface RequestConverter<T> {
    T convert(HttpServletRequest request);
}
