package com.lifeplan.dao.travel.impl;

import com.lifeplan.dao.AbstractMongoHelper;
import com.lifeplan.dao.travel.TripDao;
import com.lifeplan.models.travel.Trip;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2/12/14.
 */
@Repository
public class TripDaoImpl extends AbstractMongoHelper implements TripDao {

    @Override
    public List<Trip> loadAllTrips() {
        return loadAll(Trip.class);
//        return mongoTemplate.findAll(Trip.class);
    }

    @Override
    public void createTrip(Trip trip) {
        if (trip != null) {
            createDocument(trip);
//            mongoTemplate.insert(trip);
        } else {
            throw new IllegalArgumentException("Trip cannot be null when creating a new trip");
        }
    }

    @Override
    public void update(Trip trip) {

    }

    @Override
    public void delete(Trip trip) {

    }
}
