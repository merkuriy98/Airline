package com.merkulov.airline.filter;

import com.merkulov.airline.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/entry")
public class FilterEntry implements Filter {
    private static final Logger LOG = Logger.getLogger(FilterEntry.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("FilterEntry #init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if(httpServletRequest.getParameter("registration") != null){
            String firstName = httpServletRequest.getParameter("firstName");
            String lastName = httpServletRequest.getParameter("lastName");
            String login = httpServletRequest.getParameter("login");
            String year = httpServletRequest.getParameter("year");
            String month = httpServletRequest.getParameter("month");
            String day = httpServletRequest.getParameter("day");
            String data = year + "-" + month + "-" + day;
            String phone = httpServletRequest.getParameter("phone");
            String pass1 = httpServletRequest.getParameter("pass1");
            String pass2 = httpServletRequest.getParameter("pass2");
            if (pass1.equals(pass2)) {
                User user = new User(firstName, lastName, login, data, phone, pass1);
                httpServletRequest.setAttribute("user", user);

                LOG.info("FilterEntry transfer request to servlet");
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }
        if (httpServletRequest.getParameter("entry") != null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            LOG.info("FilterEntry transfer request to servlet as entry");
        }
    }

    @Override
    public void destroy() {
        LOG.info("FilterEntry #destroy");
    }
}
