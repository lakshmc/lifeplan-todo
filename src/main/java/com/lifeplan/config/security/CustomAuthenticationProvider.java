package com.lifeplan.config.security;

/**
 * Created on 2/24/14.
 */
//@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider/* implements AuthenticationProvider */ {
   /* @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        *//*String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println(username+":"+password);*//*
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }*/
}
