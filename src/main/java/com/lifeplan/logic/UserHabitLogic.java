package com.lifeplan.logic;

import com.lifeplan.models.UserHabit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2/7/14.
 */
@Service
public interface UserHabitLogic {
    List<UserHabit> getUserHabits();
}
