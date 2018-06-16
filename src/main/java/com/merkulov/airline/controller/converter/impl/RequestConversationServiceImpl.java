package com.merkulov.airline.controller.converter.impl;

import com.merkulov.airline.controller.converter.RequestConversationService;
import com.merkulov.airline.controller.converter.RequestConverter;
import com.merkulov.airline.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestConversationServiceImpl implements RequestConversationService {
    Map<Class<?>, RequestConverter<?>> converters;

    public RequestConversationServiceImpl() {
        converters = new HashMap<>();
        converters.put(User.class, new RequestToUserConverter());
    }

    @Override
    public <T> T convert(HttpServletRequest request, Class<T> clazz) {
        return (T) converters.get(clazz).convert(request);
    }
}
