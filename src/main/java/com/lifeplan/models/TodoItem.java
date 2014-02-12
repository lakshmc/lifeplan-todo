package com.lifeplan.models;

import com.lifeplan.logic.util.DateUtil;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 2/10/14.
 */

@Document
public class TodoItem {

    private String id; // ObjectId auto generated and assigned by mongo
    @Indexed(unique = true)
    private String name;
    private String description;
    private boolean completed;
    private String createdOn;
    private String completedOn;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(String completedOn) {
        this.completedOn = completedOn;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", createdOn=" + createdOn +
                ", completedOn=" + completedOn +
                '}';
    }

    public void markCompleted() {
        this.completed=true;
        this.completedOn= DateUtil.getCurrentDateTimeInString();
    }
}
