package com.merkulov.airline.filter;

import com.merkulov.airline.entity.Role;
import com.merkulov.airline.entity.User;
import com.merkulov.airline.exception.AuthException;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class AuthAdminFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(AuthAdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("AuthAdminFilter#init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        checkUserAdmin(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void checkUserAdmin(ServletRequest servletRequest) {
        Optional.ofNullable(servletRequest)
                .map(request -> ((HttpServletRequest) request))
                .map(request -> request.getSession(false))
                .map(session -> ((User) session.getAttribute("user")))
                .filter(user -> Role.ADMIN.equals(user.getRole()))
                .orElseThrow(AuthException::new);
    }

    @Override
    public void destroy() {

    }
}
