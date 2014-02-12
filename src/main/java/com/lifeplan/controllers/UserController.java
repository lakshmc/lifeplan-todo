package com.lifeplan.controllers;

import com.lifeplan.logic.UserLogic;
import com.lifeplan.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created on 2/8/14.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserLogic userLogic;

    @RequestMapping("")
    public @ResponseBody List<User> getAllUsers()  throws Exception{
        logger.debug("called  getAll Users");
        return userLogic.getAllUsers();
    }

    @RequestMapping(value="create", method = RequestMethod.PUT)
    public @ResponseBody void saveUser(@RequestBody User user)  throws Exception {
        logger.debug("creating: "+user);
        userLogic.createUser(user);
    }
}
