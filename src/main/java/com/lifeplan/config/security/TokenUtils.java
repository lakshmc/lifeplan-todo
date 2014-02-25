package com.lifeplan.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created on 2/21/14.
 */
@Service
public interface TokenUtils {
    String getToken(UserDetails userDetails);

    String getToken(UserDetails userDetails, Long expiration);

    boolean validate(String token);

    UserDetails getUserFromToken(String token);
}
