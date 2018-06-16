package com.merkulov.airline.filter;

import com.merkulov.airline.exception.ValidationException;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static com.merkulov.airline.constant.JspConstants.EXCEPTION_JSP;

public class FilterException implements Filter {
    private static final Logger LOG = Logger.getLogger(FilterException.class);

    @Override
    public void init(FilterConfig filterConfig) {
        LOG.info("FilterException#init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
            LOG.info("FilterException request transfer to servlet");
        } catch (ValidationException ex) {
            LOG.warn(ex.getErrors(), ex);
            request.setAttribute("errors", ex.getErrors());
            request.getRequestDispatcher(ex.getForwardJsp()).forward(request, response);
        } catch (Exception ex) {
            LOG.warn("Error in FilterException " + ex.getMessage(), ex);
            request.getRequestDispatcher(EXCEPTION_JSP).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        LOG.info("FilterException destroy");
    }
}
