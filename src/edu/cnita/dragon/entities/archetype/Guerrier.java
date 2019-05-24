package edu.cnita.dragon.entities.archetype;


import edu.cnita.dragon.items.weapons.Arme;
import edu.cnita.dragon.items.Item;
import edu.cnita.dragon.enumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;

import java.util.ArrayList;
import java.util.List;
/**
 * Guerrier
 *
 * La classe Guerrier extends Entity
 *
 *
 * (@author)
 * @version 1.0
 * */
public class Guerrier extends Entity {

    private Item activeWeapon;
    private List<Item> ListOffense = new ArrayList<>();
    private String bouclier;

    // getters
    public String getBouclier() {
        return bouclier;
    }
    public Item getActiveWeapon() {
        return activeWeapon;
    }
    public List<Item> getListOffense() {
        return ListOffense;
    }
    @Override
    public Item getOffense() {
        return this.getActiveWeapon();
    }
    @Override
    public String getDefense() {
        return this.getBouclier();
    }
    public void setListOffense(List<Item> listOffense) {
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
     */

    public Guerrier(){

        super(TypeEntity.GUERRIER);
        this.setListOffense(createListWeapon());
        this.initOffense();
        this.setDefense("Bouclier En Bois");

    }


    //Methods
    private List<Item>  createListWeapon(){
        List<Item> armes = new ArrayList<>();
        armes.add(new Arme("cleave Hachette",3));
        armes.add(new Arme ("spliter Hachette",3));
        armes.add(new Arme ("crackle Hachette",3));
        return armes;
    }



}
