package com.lifeplan.models.activity;

import org.joda.time.LocalDateTime;

import java.util.Collections;
import java.util.List;

/**
 * Created on 2/18/14.
 */
public class ActivityFixtures {

    public static List<Activity> getAllActivities() {
        return Collections.singletonList(new ActivityBuilder().setName("Test Activity 1").setStartTimestamp(LocalDateTime.now().toDateTime()).getActivity());
    }
}
