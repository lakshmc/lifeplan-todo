package com.lifeplan.models.user;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 2/7/14.
 */
@Document(collection = "user")
public class User {

    private String id;
    @Indexed(unique = true)
    private String username;
    private String name;
    private String firstName;
    private String preferredName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User buildUser(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                '}';
    }
}
