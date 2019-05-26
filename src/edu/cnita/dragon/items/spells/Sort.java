package edu.cnita.dragon.items.spells;

import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.items.Item;
/**
 * Sort
 *
 * La classe Sort Extends Item
 *
 *
 * (@author)
 * @version 1.0
 * */
public class Sort extends Item {

    public Sort(String name, int strength){
        super(name,strength);
    }


    @Override
    public String whoIs() {
        return "I'm a Spell.";
    }

    @Override
    public String actionEvent(Entity entity) {
        return " ";
    }
    @Override
    public String displayGraphicalString() {
        return null;
    }
}
