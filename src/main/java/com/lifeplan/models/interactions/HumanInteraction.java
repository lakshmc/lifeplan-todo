package com.lifeplan.models.interactions;

/**
 * Created on 2/17/14.
 */
public class HumanInteraction extends Interaction {

    private InteractionType interactionType;

    public boolean isOneOnOne() {
        return getParticipantCount() == 1;
    }

    public boolean isGroupInteracation() {
        return getParticipantCount() > 1;
    }


}
