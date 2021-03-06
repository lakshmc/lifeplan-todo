package com.lifeplan.dao.activity;

import com.lifeplan.models.activity.Activity;

import java.util.List;

/**
 * Created on 2/14/14.
 */
public interface ActivityDao {
    List<Activity> getAllActivity();

    Activity getActivityById(String id);

    void updateActivity(Activity activity);

    void createActivity(Activity activity);

    void deleteActivityById(String id);
}
