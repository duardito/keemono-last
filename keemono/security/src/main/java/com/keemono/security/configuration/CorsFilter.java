package com.keemono.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by edu on 18/04/2015.
 */
@Component
public class CorsFilter implements Filter {

    @Value("${cerberus.token.header}")
    private String tokenHeader;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest)req;

        String origin = httpRequest.getHeader("Origin");
        if (origin == null || origin.equalsIgnoreCase("null")) {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        else {
            response.addHeader("Access-Control-Allow-Origin", origin);
        }
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-uw-act-as, Origin, X-Requested-With, Content-Type, Accept, " + tokenHeader);
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
}
