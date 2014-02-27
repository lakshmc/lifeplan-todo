package com.lifeplan.models.activity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

/**
 * Created on 2/14/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Activity {

    private String id;
    private String name;
    private boolean plannedActivity;
    private DateTime startTimestamp;
    private DateTime endTimestamp;
    private DateTime lastModified;
    private ActivityParticipants activityParticipants;
    private ActivityFeeling activityFeeling;
    private ActivityLocation activityLocation;
    private boolean consuming;
    private String notes;

    public ActivityParticipants getActivityParticipants() {
        return activityParticipants;
    }

    public void setActivityParticipants(ActivityParticipants activityParticipants) {
        this.activityParticipants = activityParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public boolean getPlannedActivity() {
        return isPlannedActivity();
    }*/

    public boolean isPlannedActivity() {
        return plannedActivity;
    }

    public void setPlannedActivity(boolean plannedActivity) {
        this.plannedActivity = plannedActivity;
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

    public ActivityFeeling getActivityFeeling() {
        return activityFeeling;
    }

    public void setActivityFeeling(ActivityFeeling activityFeeling) {
        this.activityFeeling = activityFeeling;
    }

    public ActivityLocation getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(ActivityLocation activityLocation) {
        this.activityLocation = activityLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isConsuming() {
        return consuming;
    }

    public void setConsuming(boolean consuming) {
        this.consuming = consuming;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", plannedActivity=" + plannedActivity +
                ", startTimestamp=" + startTimestamp +
                ", endTimestamp=" + endTimestamp +
                ", activityParticipants=" + activityParticipants +
                ", activityFeeling=" + activityFeeling +
                ", activityLocation=" + activityLocation +
                ", consuming=" + consuming +
                ", notes='" + notes + '\'' +
                '}';
    }

    public DateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }

   /* name: watching a movie
    type: planned (if intentionally decided by the user) /unplanned (all other actions)
    start date-time:
    end date-time:
    participants: self|group( option to add number of people and their names)
    feeling: positive|negative|neutral
    location: home|Office|Other
    consuming: true|false (drinking coffee or watching movie is consumption, writing something or learning something is productive)
    notes: things that you want to remember about this next time when you look at it*/

}
