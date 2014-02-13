package com.lifeplan.logic.travel.impl;

import com.lifeplan.dao.travel.TripDao;
import com.lifeplan.logic.travel.TripLogic;
import com.lifeplan.models.travel.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 2/12/14.
 */
@Component
public class TripLogicImpl implements TripLogic {
    @Autowired
    TripDao tripDao;

    @Override
    public List<Trip> getAllTrips() {
        return tripDao.loadAllTrips();
    }

    @Override
    public void createTrip(Trip trip) {
        if (trip != null) {
            tripDao.createTrip(trip);
        } else {
            throw new IllegalArgumentException("trip object cannot be null when creating trip");
        }
    }

    @Override
    public void updateTrip(Trip trip) {
        if (trip != null) {
            tripDao.update(trip);
        } else {
            throw new IllegalArgumentException("trip object cannot be null when updating trip");
        }
    }

    @Override
    public void deleteTrip(String tripId) {

    }
}
