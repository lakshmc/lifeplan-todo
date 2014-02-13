package com.lifeplan.models.travel;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created on 2/12/14.
 */
public class Place {

    private String id;
    @Indexed(unique = true)
    private String name;
    private PlaceAddress address;

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

    public PlaceAddress getAddress() {
        return address;
    }

    public void setAddress(PlaceAddress address) {
        this.address = address;
    }
}
