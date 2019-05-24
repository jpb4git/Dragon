package edu.cnita.dragon.items;

import edu.cnita.dragon.Interfaces.Event;

/**
 * Item
 *
 * La classe Item est la classe parent
 *
 *
 * (@author)
 * @version 1.0
 * */
public  abstract class Item implements Event {

    private String Nom;
    private int Strength;

    public Item(String name, int Strength){
        this.Nom = name;
        this.Strength = Strength;
    }
    public String getNom() {
        return Nom;
    }
    public int getStrength() { return Strength; }
    public void setNom(String nom) {
        Nom = nom;
    }
    public void setStrength(int strength) {
        Strength = strength;
    }


}
