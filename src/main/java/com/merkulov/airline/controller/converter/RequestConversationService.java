package com.merkulov.airline.controller.converter;

import javax.servlet.http.HttpServletRequest;

public interface RequestConversationService {
    <T> T convert(HttpServletRequest request, Class<T> clazz);
}
