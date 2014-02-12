package com.lifeplan.dao;

import com.lifeplan.models.UserHabit;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2/7/14.
 */
@Repository
public interface UserHabitDao {
    List<UserHabit> loadUserHabits();
}
