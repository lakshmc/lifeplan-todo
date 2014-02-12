package com.lifeplan.logic.impl;

import com.lifeplan.dao.UserDao;
import com.lifeplan.logic.UserLogic;
import com.lifeplan.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2/8/14.
 */
@Service
public class UserLogicImpl implements UserLogic {

    @Autowired
    UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
