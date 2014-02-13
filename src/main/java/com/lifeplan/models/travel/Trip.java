package com.lifeplan.models.travel;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created on 2/12/14.
 */
public class Trip {

    private String id;
    @Indexed(unique = true)
    private String name;
    private Place destination;
    private Place origin;
    private TripDates tripDates;

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

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public Place getOrigin() {
        return origin;
    }

    public void setOrigin(Place origin) {
        this.origin = origin;
    }

    public TripDates getTripDates() {
        return tripDates;
    }

    public void setTripDates(TripDates tripDates) {
        this.tripDates = tripDates;
    }
}
