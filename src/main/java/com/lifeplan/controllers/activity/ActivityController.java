package com.lifeplan.controllers.activity;

import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2/14/14.
 */

@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityDao activityDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Activity> getAllActivity() {
        return activityDao.getAllActivity();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Activity getActivityById(@RequestParam String id) {
        return activityDao.getActivityById(id);
    }

    //create activity
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public
    @ResponseBody
    void addNewActivity(@RequestBody Activity activity) {
        activityDao.createActivity(activity);
    }


}
