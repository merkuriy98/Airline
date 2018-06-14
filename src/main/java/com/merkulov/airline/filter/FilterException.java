package com.merkulov.airline.filter;

import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static com.merkulov.airline.constant.JspConstants.EXCEPTION_JSP;

@WebFilter(urlPatterns = "/*")
public class FilterException implements Filter {
    private static final Logger LOG = Logger.getLogger(Filter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        LOG.info("FilterException init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            filterChain.doFilter(servletRequest,servletResponse);
            LOG.info("request transfer to servlet");
        }catch (Exception ex){
            LOG.debug("Error in FilterException " + ex.getMessage());
            servletRequest.getRequestDispatcher(EXCEPTION_JSP).forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        LOG.info("FilterException destroy");
    }
}
