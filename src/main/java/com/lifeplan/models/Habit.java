package com.lifeplan.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 2/7/14.
 */
@Document(collection="habit")
public class Habit {

    @Id
    private String id;
    private String name;
    private boolean positive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    private Habit(String name){
        this.name = name;
    }

    public static Habit HabitBuidler(String name){
        return new Habit(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
