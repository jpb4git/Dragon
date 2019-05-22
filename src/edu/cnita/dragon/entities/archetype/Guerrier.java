package edu.cnita.dragon.entities.archetype;


import edu.cnita.dragon.Arme;
import edu.cnita.dragon.Obj;
import edu.cnita.dragon.EnumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Entity {

    private Obj activeWeapon;
    private List<Obj> ListOffense = new ArrayList<>();
    private String bouclier;

    // getters
    public String getBouclier() {
        return bouclier;
    }
    public Obj getActiveWeapon() {
        return activeWeapon;
    }
    public List<Obj> getListOffense() {
        return ListOffense;
    }
    @Override
    public Obj getOffense() {
        return this.getActiveWeapon();
    }
    @Override
    public String getDefense() {
        return this.getBouclier();
    }
    public void setListOffense(List<Obj> listOffense) {
        ListOffense = listOffense;
    }

    //setters
    @Override
    public void initOffense(){
        this.activeWeapon = this.getListOffense().get(generateRandom(0,this.getListOffense().size()-1));
    }
    @Override
    public void setDefense(String defense) {
        this.bouclier = defense;
    }



    /**
     * Constructor
     */
    public Guerrier(){
        super();
    }
    /**
     * overload Constructor
     *
     */
    public Guerrier(String name){
        super();
    }

    /**
     * construct and initializes a Guerrier with a name, health and strength
     *
     *
     * @param name name String format
     * @param type archétype for this guerrier
     */
    public Guerrier(String name, TypeEntity type){
        super(name,type);
        this.setListOffense(createListWeapon());
        this.initOffense();
        this.setDefense("Bouclier En Bois");

    }

    //Methods
    private List<Obj>  createListWeapon(){
        List<Obj> armes = new ArrayList<>();
        armes.add(new Arme("cleave Hachette",3));
        armes.add(new Arme ("spliter Hachette",3));
        armes.add(new Arme ("crackle Hachette",3));
        return armes;
    }


}
