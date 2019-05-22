package edu.cnita.dragon;

public class Obj {

    private String Nom;
    private int Strength;

    Obj(String name, int Strength){
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
