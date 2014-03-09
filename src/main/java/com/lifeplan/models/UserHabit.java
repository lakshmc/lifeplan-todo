package com.lifeplan.models;

import com.lifeplan.models.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 2/7/14.
 */
@Document(collection = "user_habit")
public class UserHabit {

    @Id
    private String id;
    private User user;
    private Habit habit;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    private UserHabit(User user, Habit habit) {
        this.user = user;
        this.habit = habit;
    }

    public static UserHabit buildUserHabit(User user, Habit habit) {
        return new UserHabit(user, habit);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
