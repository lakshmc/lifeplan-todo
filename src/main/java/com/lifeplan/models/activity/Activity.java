package com.lifeplan.models.activity;

import com.lifeplan.models.activity.constants.ACTIVITY_FEELING;
import com.lifeplan.models.activity.constants.ACTIVITY_LOCATION;
import com.lifeplan.models.activity.constants.ACTIVITY_PARTICIPANT;
import com.lifeplan.models.activity.constants.ACTIVITY_TYPE;
import org.joda.time.DateTime;

/**
 * Created on 2/14/14.
 */
public class Activity {

    private String name;
    private ACTIVITY_TYPE activityType;
    private DateTime startTimestamp;
    private DateTime endTimestamp;
    private ACTIVITY_PARTICIPANT activityParticipant;
    private ACTIVITY_FEELING activityFeeling;
    private ACTIVITY_LOCATION activityLocation;
    private String notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ACTIVITY_TYPE getActivityType() {
        return activityType;
    }

    public void setActivityType(ACTIVITY_TYPE activityType) {
        this.activityType = activityType;
    }

    public DateTime getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(DateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public DateTime getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(DateTime endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public ACTIVITY_PARTICIPANT getActivityParticipant() {
        return activityParticipant;
    }

    public void setActivityParticipant(ACTIVITY_PARTICIPANT activityParticipant) {
        this.activityParticipant = activityParticipant;
    }

    public ACTIVITY_FEELING getActivityFeeling() {
        return activityFeeling;
    }

    public void setActivityFeeling(ACTIVITY_FEELING activityFeeling) {
        this.activityFeeling = activityFeeling;
    }

    public ACTIVITY_LOCATION getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(ACTIVITY_LOCATION activityLocation) {
        this.activityLocation = activityLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

   /* name: watching a movie
    type: planned (if intentionally decided by the user) /unplanned (all other actions)
    start date-time:
    end date-time:
    participants: self|group( option to add number of people and their names)
    feeling: positive|negative|neutral
    location: home|Office|Other
    notes: things that you want to remember about this next time when you look at it*/

}
