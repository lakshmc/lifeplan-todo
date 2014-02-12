package com.lifeplan.logic.impl;

import com.lifeplan.dao.UserHabitDao;
import com.lifeplan.logic.UserHabitLogic;
import com.lifeplan.models.UserHabit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2/7/14.
 */
@Service
public class UserHabitLogicImpl implements UserHabitLogic {
    @Autowired
    private UserHabitDao userHabitDao;

    @Override
    public List<UserHabit> getUserHabits() {
        return userHabitDao.loadUserHabits();
    }
}
