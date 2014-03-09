package com.lifeplan.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2/21/14.
 */
@Service
public interface TokenUtils {
    String getToken(UserDetails userDetails);

    String getToken(UserDetails userDetails, Long expiration);

    boolean validate(String token);

    boolean validate(String token, HttpServletRequest request);

    UserDetails getUserFromToken(String token);
}
