package com.lifeplan.models.interactions;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created on 2/17/14.
 */
public abstract class Interaction {

    private List<InteractionParticipant> participants;
    private InteractionType interactionType;

    protected int getParticipantCount() {
        if (CollectionUtils.isNotEmpty(participants)) {
            return participants.size();
        } else {
            return 0;
        }
    }

    protected List<InteractionParticipant> getParticipants() {
        return participants;
    }

    protected void setParticipants(List<InteractionParticipant> participants) {
        this.participants = participants;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }
}
