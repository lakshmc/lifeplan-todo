package com.lifeplan.dao.activity.impl;

import com.lifeplan.dao.AbstractMongoHelper;
import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2/14/14.
 */
@Repository
public class ActivityDaoImpl extends AbstractMongoHelper implements ActivityDao {
    private final static Class<Activity> ACTIVITY_CLASS = Activity.class;

    @Override
    public List<Activity> getAllActivity() {
        return loadAll(ACTIVITY_CLASS);
    }

    @Override
    public Activity getActivityById(String id) {
        return findById(id, ACTIVITY_CLASS);
    }

    @Override
    public void createActivity(Activity activity) {
        if (null == activity) {
            throw new IllegalArgumentException("Activity cannot be null when adding new activity");
        } else {
            createDocument(activity);
        }
    }

    @Override
    public void deleteActivityById(String id) {
        deleteDocumentById(id, Activity.class);
    }
}
