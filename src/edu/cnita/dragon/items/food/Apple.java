package edu.cnita.dragon.items.food;

import edu.cnita.dragon.items.Item;

public class Apple extends Item {


    public Apple(String name, int Strength){
        super(name, Strength);
    }

    @Override
    public String whoIs() {
        return "I'm an Apple";
    }


    @Override
    public void actionEvent() {
        System.out.println("i'll regen you  !!! for an amount of  ." + this.getStrength());
    }
}
