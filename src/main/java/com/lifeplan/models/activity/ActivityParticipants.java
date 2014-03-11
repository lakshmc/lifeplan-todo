package com.lifeplan.models.activity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 * Created on 2/26/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ActivityParticipants {
    private List<ActivityParticipant> participants;

    public List<ActivityParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ActivityParticipant> participants) {
        this.participants = participants;
    }
}
