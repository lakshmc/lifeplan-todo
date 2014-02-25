package com.lifeplan.logic.auth;

import com.lifeplan.models.auth.AuthUser;
import org.springframework.stereotype.Service;

/**
 * Created on 2/21/14.
 */
@Service
public class AuthUserLogic {

    public boolean isValidAuthUser(AuthUser authUser) {
        return authUser.getUsername().equals("admin") || authUser.getUsername().equals("user");
    }

    public String getAuthorizationToken(AuthUser authUser) {
        if (authUser.getUsername().equals("admin"))
            return "admintoken";
        else
            return "usertoken";
    }
}
