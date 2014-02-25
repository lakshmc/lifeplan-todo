package com.lifeplan.controllers.auth;

import com.lifeplan.logic.auth.AuthUserLogic;
import com.lifeplan.models.auth.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2/21/14.
 */

@Controller
public class AuthController {
    @Autowired
    AuthUserLogic authUserLogic;

    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public
    @ResponseBody
    String validateUserCredentials(@RequestBody AuthUser authUser) {

        if (authUserLogic.isValidAuthUser(authUser)) {
            return authUserLogic.getAuthorizationToken(authUser);
        } else
            throw new BadCredentialsException("Invalid username password combination.");
    }

}
