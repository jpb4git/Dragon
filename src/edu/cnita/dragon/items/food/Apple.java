package edu.cnita.dragon.items.food;

import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.items.Item;

public class Apple extends Item {

    public String getGraphicalString() {
        return graphicalString;
    }

    public void setGraphicalString(String graphicalString) {
        this.graphicalString = graphicalString;
    }

    private String graphicalString;
    public Apple(String name, int Strength){

        super(name, Strength);
        this.setGraphicalString("A");
    }

    @Override
    public String whoIs() {
        return "an Apple on the floor.";
    }

    @Override
    public String actionEvent(Event event) {

        return null;
    }


    @Override
    public String actionEvent() {

        return "i'll regen you  !!! for an amount of  ." + this.getStrength();


    }

    @Override
    public String displayGraphicalString() {
        return this.getGraphicalString();
    }
}
