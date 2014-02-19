package com.lifeplan.controllers.activity;

import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.Activity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on 2/14/14.
 */

@Controller
@RequestMapping(value = "activities")
public class ActivityController {
    private static final Logger log = Logger.getLogger(ActivityController.class);

    @Autowired
    private ActivityDao activityDao;

    // get All Activities
    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Activity> getAllActivity() {
        return activityDao.getAllActivity();
    }


    //create activity
    @RequestMapping(value = "", method = RequestMethod.POST)
    public
    @ResponseBody
    void addNewActivity(@RequestBody Activity activity) {
        activityDao.createActivity(activity);
    }


}
