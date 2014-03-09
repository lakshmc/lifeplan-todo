package com.lifeplan.controllers.auth;

import com.lifeplan.logic.auth.AuthUserLogic;
import com.lifeplan.models.user.auth.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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

    @RequestMapping(value = "rest/addAuthUser", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity addUserCredentials(@RequestBody @Valid AuthUser authUser, BindingResult result) {
        // you are about to add a new auth user. A corresponding User object should already be there in db
        // validate if User.username is same as the username provided in AuthUser
        if (result.hasErrors()) {
            return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        } else {
            authUserLogic.addAuthUser(authUser);
            return new ResponseEntity(HttpStatus.CREATED);
        }

    }
}
