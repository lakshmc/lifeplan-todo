package com.lifeplan.config.security.impl;

import com.lifeplan.config.security.TokenUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2/21/14.
 */
@Service
public class TokenUtilsImpl implements TokenUtils {
    public static final String usertoken = "usertoken";
    public static final String admintoken = "admintoken";

    private static final Logger log = Logger.getLogger(TokenUtilsImpl.class);

    @Override
    public String getToken(UserDetails userDetails) {
        if (userDetails.getUsername().equals("admin")) {
            return admintoken;
        } else if (userDetails.getUsername().equals("user")) {
            return usertoken;
        } else {
            return usertoken;
        }

    }

    @Override
    public String getToken(UserDetails userDetails, Long expiration) {
        return getToken(userDetails);
    }

    @Override
    public boolean validate(String token) {
        return TokenUtilsImpl.usertoken.equals(token) || TokenUtilsImpl.admintoken.equals(token);
    }

    @Override
    public boolean validate(String token, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder("validating hash token: received token ").append(token);
        log.debug(sb.toString());
        return TokenUtilsImpl.usertoken.equals(token) || TokenUtilsImpl.admintoken.equals(token);
    }

    @Override
    public UserDetails getUserFromToken(String token) {

        UserDetails user;
        List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
        if (TokenUtilsImpl.admintoken.equals(token)) {
            gaList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            gaList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        user = new User(usertoken, "password1", true, true, true, true, gaList);
        return user;
    }
}
