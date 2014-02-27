package com.lifeplan.models.activity;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created on 2/26/14.
 */
public class ActivityLocation {
    @Indexed(unique = true)
    private String locationName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
