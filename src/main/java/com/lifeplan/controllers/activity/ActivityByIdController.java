package com.lifeplan.controllers.activity;

import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.Activity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2/18/14.
 */
@Controller
@RequestMapping(value = "rest/activities/{id}")
public class ActivityByIdController {
    @Autowired
    ActivityDao activityDao;

    private static final Logger log = Logger.getLogger(ActivityByIdController.class);

    // get Activity by id
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Activity getActivityById(@PathVariable String id) {
        log.debug("got id:" + id);
        if (id.equals("123")) {
            throw new DuplicateKeyException("test exception");
        }
        return activityDao.getActivityById(id);
    }

    // delete Activity by id
    @RequestMapping(method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseEntity deleteActivityById(@PathVariable String id) {
        log.debug("got id:" + id);
        if (id.equals("123")) {
            throw new DuplicateKeyException("test exception");
        }
        activityDao.deleteActivityById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
