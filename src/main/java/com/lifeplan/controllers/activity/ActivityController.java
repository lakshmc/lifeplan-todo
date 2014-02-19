package com.lifeplan.controllers.activity;

import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.Activity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // get Activity by id
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Activity getActivityById(@PathVariable String id) {
        log.debug("got id:" + id);
        if (id.equals("123")) {
            throw new DuplicateKeyException("test exception");
        }
        return activityDao.getActivityById(id);
    }

    //create activity
    @RequestMapping(value = "", method = RequestMethod.POST)
    public
    @ResponseBody
    void addNewActivity(@RequestBody Activity activity) {
        activityDao.createActivity(activity);
    }


}
