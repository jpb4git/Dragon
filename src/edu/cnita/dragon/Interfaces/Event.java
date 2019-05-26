package edu.cnita.dragon.Interfaces;

import edu.cnita.dragon.entities.Entity;

public interface Event {

    String whoIs();

    /**
     *
     * @param entity the active player will interact with this event
     * @return String Status
     */
    String actionEvent(Entity entity);

    /**
     * Console display for this event
     * @return the graphical sprite
     */
    String displayGraphicalString();

}
