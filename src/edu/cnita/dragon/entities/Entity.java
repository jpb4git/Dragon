package edu.cnita.dragon.entities;

import edu.cnita.dragon.Obj;
import edu.cnita.dragon.EnumArchetype.TypeEntity;

import java.util.List;

public abstract class Entity {

    private String Nom;
    private int Health;
    private int Strength;
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
    public abstract Obj getOffense();
    public abstract String  getDefense();
    public abstract List<Obj> getListOffense();

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
