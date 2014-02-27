package com.lifeplan.dao;

import com.lifeplan.models.user.User;

import java.util.List;

/**
 * Created on 2/8/14.
 */
public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();

    User getUserByUserName(String username);
}
