package com.lifeplan.models.activity;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created on 2/26/14.
 */
public class ActivityFeeling {

    @Indexed(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
