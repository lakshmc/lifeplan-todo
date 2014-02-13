package com.lifeplan.logic.travel;

import com.lifeplan.models.travel.Trip;

import java.util.List;

/**
 * Created on 2/12/14.
 */
public interface TripLogic {
    List<Trip> getAllTrips();

    void createTrip(Trip trip);

    void updateTrip(Trip trip);

    void deleteTrip(String tripId);
}
