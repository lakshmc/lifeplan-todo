package com.lifeplan.logic;

import com.lifeplan.models.user.User;

import java.util.List;

/**
 * Created on 2/8/14.
 */
public interface UserLogic {
    void createUser(User user);

    List<User> getAllUsers();
}
