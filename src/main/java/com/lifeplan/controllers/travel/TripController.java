package com.lifeplan.controllers.travel;

import com.lifeplan.logic.travel.TripLogic;
import com.lifeplan.models.travel.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on 2/12/14.
 */
@Controller
@RequestMapping("trips")
public class TripController {

    @Autowired
    TripLogic tripLogic;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Trip> listTrips() {
        return tripLogic.getAllTrips();
    }

    @RequestMapping(value = "create", method = RequestMethod.PUT)
    public
    @ResponseBody
    void createTrip(@RequestBody Trip trip) {
        tripLogic.createTrip(trip);
    }

}
