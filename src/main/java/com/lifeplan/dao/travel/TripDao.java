package com.lifeplan.dao.travel;

import com.lifeplan.models.travel.Trip;

import java.util.List;

/**
 * Created on 2/12/14.
 */
public interface TripDao {
    List<Trip> loadAllTrips();

    void createTrip(Trip trip);

    void update(Trip trip);

    void delete(Trip trip);
}
