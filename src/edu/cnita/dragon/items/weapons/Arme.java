package edu.cnita.dragon.items.weapons;


import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.items.Item;
/**
 * Arme
 *
 * La classe Arme extends Item
 *
 *
 * (@author)
 * @version 1.0
 * */
public class Arme extends Item {


    public Arme(String name, int strength){
        super(name,strength);
    }


    @Override
    public String whoIs() {
        return "Im a Warrior.";
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
