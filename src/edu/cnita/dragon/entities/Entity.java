package edu.cnita.dragon.entities;

import edu.cnita.dragon.items.Item;
import edu.cnita.dragon.enumArchetype.TypeEntity;

import java.util.List;
/**
 * Entity
 *
 * La classe Entity est la classe parent
 * Pour les personnages.
 *
 * (@author)
 * @version 1.0
 * */
public abstract class Entity {

    private String Nom;
    private int Health;
    private int Strength;

    public void setType(TypeEntity type) {
        this.type = type;
    }

    private TypeEntity type;

    //Getters
    public TypeEntity getType() {
        return type;
    }
    public String getNom() {
        return Nom;
    }
    public int getHealth() {
        return Health;
    }
    public int getStrength() {
        return Strength;
    }
    public abstract Item getOffense();
    public abstract String  getDefense();
    public abstract List<Item> getListOffense();

    //setters
    public void setNom(String nom) {
        Nom = nom;
    }
    public void setHealth(int health) {
        Health = health;
    }
    public void setStrength(int strength) {
        Strength = strength;
    }
    public abstract void setDefense(String defense);
    public abstract void initOffense();

    /**
     * Constructor
     */
    public Entity(){

        //Health = generateRandom(this.getType().minHealth,this.getType().maxHealth);
        //Strength = generateRandom(this.getType().minStrength,this.getType().maxStrength);
    }
    public Entity(TypeEntity t){
        this.setType(t);
        Health = generateRandom(this.getType().minHealth,this.getType().maxHealth);
        Strength = generateRandom(this.getType().minStrength,this.getType().maxStrength);
    }
    public Entity(String nom, TypeEntity type){
        this.Nom = nom;
        this.type = type;
        Health = generateRandom(this.getType().minHealth,this.getType().maxHealth);
        Strength = generateRandom(this.getType().minStrength,this.getType().maxStrength);
    }
    public int generateRandom(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }


}
