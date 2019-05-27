package edu.cnita.dragon.items.food;

import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.items.Item;

public class Apple extends Item {

    private String getGraphicalString() {
        return graphicalString;
    }

    private void setGraphicalString(String graphicalString) {
        this.graphicalString = graphicalString;
    }

    private String graphicalString;
    public Apple(String name, int Strength){

        super(name, Strength);
        this.setGraphicalString("A");
    }

    @Override
    public String whoIs() {
        return this.getNom();
    }

    @Override
    public String actionEvent(Entity entity) {
        entity.setHealth(entity.getHealth()  + this.getStrength());
        System.out.println("You found an Apple.   You gained " + this.getStrength() + " points life");
        return null;
    }




    @Override
    public String displayGraphicalString() {
        return this.getGraphicalString();
    }
}
