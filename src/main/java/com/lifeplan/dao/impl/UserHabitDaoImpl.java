package com.lifeplan.dao.impl;

import com.lifeplan.dao.UserHabitDao;
import com.lifeplan.models.UserHabit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2/7/14.
 */
@Repository
public class UserHabitDaoImpl implements UserHabitDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public static final String USER_HABIT_COLLECTION_NAME = "user_habit";

    @Override
    public List<UserHabit> loadUserHabits() {
        return mongoTemplate.findAll(UserHabit.class, USER_HABIT_COLLECTION_NAME);
        /*User user = User.buildUser("Kanth");

        List<UserHabit> list = new ArrayList<UserHabit>();
        list.add(UserHabit.buildUserHabit(user, Habit.HabitBuidler("Read a book")));
        list.add(UserHabit.buildUserHabit(user, Habit.HabitBuidler("Eat at home")));

        return list;*/
    }

    /*@Override
    public List<UserHabit> loadUserHabits() {
        User user = User.buildUser("Kanth");

        List<UserHabit> list = new ArrayList<UserHabit>();
        list.add(UserHabit.buildUserHabit(user, Habit.HabitBuidler("Read a book")));
        list.add(UserHabit.buildUserHabit(user, Habit.HabitBuidler("Eat at home")));

        return list;
    }*/
}
