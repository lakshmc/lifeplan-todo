package com.lifeplan.config.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created on 2/21/14.
 */

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {
    private static final Logger logger = Logger.getLogger(AuthenticationTokenProcessingFilter.class);
    //    @Autowired UserService userService;
    @Autowired
    TokenUtils tokenUtils;
    AuthenticationManager authManager;

    public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        @SuppressWarnings("unchecked")
        Map<String, String[]> parms = request.getParameterMap();
        /*logger.debug("i am at the processing filter");
        logger.debug(parms);*/
        if (parms.containsKey("token")) {
            String token = parms.get("token")[0]; // grab the first "token" parameter

            // validate the token
            if (tokenUtils.validate(token)) {
                // determine the user based on the (already validated) token
                UserDetails userDetails = tokenUtils.getUserFromToken(token);
                // build an Authentication object with the user's info
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
                // set the authentication into the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        // continue thru the filter chain
        logger.debug("completed auth filter");
        chain.doFilter(request, response);
    }
}
