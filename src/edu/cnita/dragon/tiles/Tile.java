package edu.cnita.dragon.tiles;

import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.items.Item;

/**
 * Tile
 * class Tile correspond à une case du plateau de jeu.
 * chaque Tile contient un enemy ou un Item
 */
public class Tile {

    private int num;
    private Event event;


    public void setEvent(Event event) {
        this.event = event;
    }



    /**
     *
     * @param num uniq num
     */
    public Tile(int num) {
        this.num = num;
    }
    //getters
    public int getNum() {
        return num;
    }
    public Event getEvent() { return event; }
    //setters
    public void setNum(int num) {
        this.num = num;
    }





}
