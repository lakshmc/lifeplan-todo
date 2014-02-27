package com.lifeplan.models.activity;

import org.joda.time.DateTime;

/**
 * Created on 2/18/14.
 */
public class ActivityBuilder {

    private Activity activity;

    ActivityBuilder() {
        activity = new Activity();
    }

    ActivityBuilder(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public ActivityBuilder setName(String name) {
        activity.setName(name);
        return this;
    }

    public ActivityBuilder setActivityType(boolean activityType) {
        activity.setPlannedActivity(activityType);
        return this;
    }

    public ActivityBuilder setStartTimestamp(DateTime startTimestamp) {
        activity.setStartTimestamp(startTimestamp);
        return this;
    }

    public ActivityBuilder setEndTimestamp(DateTime endTimestamp) {
        activity.setEndTimestamp(endTimestamp);
        return this;
    }

    public ActivityBuilder setActivityParticipant(ActivityParticipants activityParticipant) {
        activity.setActivityParticipants(activityParticipant);
        return this;
    }

    public ActivityBuilder setActivityFeeling(ActivityFeeling activityFeeling) {
        activity.setActivityFeeling(activityFeeling);
        return this;
    }

    public ActivityBuilder setActivityLocation(ActivityLocation activityLocation) {
        activity.setActivityLocation(activityLocation);
        return this;
    }

    public ActivityBuilder setNotes(String notes) {
        activity.setNotes(notes);
        return this;
    }

    public ActivityBuilder setConsuming(boolean consuming) {
        activity.setConsuming(consuming);
        return this;
    }
}
