package com.lifeplan.controllers.activity;

import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.Activity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on 2/14/14.
 */

@Controller
@RequestMapping(value = "rest/activities")
public class ActivityController {
    private static final Logger log = Logger.getLogger(ActivityController.class);

    @Autowired
    private ActivityDao activityDao;

    // get All Activities
    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<Activity>> getAllActivity() {
        return new ResponseEntity<List<Activity>>(activityDao.getAllActivity(), HttpStatus.OK);
    }

    //create activity
    @RequestMapping(value = "", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity upsertActivity(@RequestBody Activity activity) {
        log.debug(activity);
        if (StringUtils.isEmpty(activity.getId())) {
            activityDao.createActivity(activity);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            activityDao.updateActivity(activity);
            return new ResponseEntity(HttpStatus.OK);
        }
    }


}
