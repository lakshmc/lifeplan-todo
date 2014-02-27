package com.lifeplan.logic.auth;

import com.lifeplan.dao.auth.AuthUserDao;
import com.lifeplan.models.user.auth.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2/21/14.
 */
@Service
public class AuthUserLogic {
    @Autowired
    private AuthUserDao authUserDao;

    public boolean isValidAuthUser(AuthUser authUser) {
        return authUserDao.authUserExists(authUser);
        //return authUser.getUsername().equals("admin") || authUser.getUsername().equals("user");
    }

    public String getAuthorizationToken(AuthUser authUser) {
        return authUser.getUsername() + "token";
        /*if (authUser.getUsername().equals("admin"))
            return "admintoken";
        else
            return "usertoken";*/
    }

    public void addAuthUser(AuthUser authUser) {
        authUserDao.addAuthUser(authUser);
    }
}
