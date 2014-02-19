package com.lifeplan.models.activity;

import com.lifeplan.models.activity.constants.ACTIVITY_FEELING;
import com.lifeplan.models.activity.constants.ACTIVITY_LOCATION;
import com.lifeplan.models.activity.constants.ACTIVITY_PARTICIPANT;
import com.lifeplan.models.activity.constants.ACTIVITY_TYPE;
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

    public ActivityBuilder setActivityType(ACTIVITY_TYPE activityType) {
        activity.setActivityType(activityType);
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

    public ActivityBuilder setActivityParticipant(ACTIVITY_PARTICIPANT activityParticipant) {
        activity.setActivityParticipant(activityParticipant);
        return this;
    }

    public ActivityBuilder setActivityFeeling(ACTIVITY_FEELING activityFeeling) {
        activity.setActivityFeeling(activityFeeling);
        return this;
    }

    public ActivityBuilder setActivityLocation(ACTIVITY_LOCATION activityLocation) {
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
