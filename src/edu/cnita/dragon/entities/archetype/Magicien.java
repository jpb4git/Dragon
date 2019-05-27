package edu.cnita.dragon.entities.archetype;


import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.items.Item;
import edu.cnita.dragon.items.spells.Sort;
import edu.cnita.dragon.enumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;

import java.util.ArrayList;
import java.util.List;
/**
 * Magicien
 *
 * La classe Magicien  extend la classe Entity
 *
 *
 * (@author)
 * @version 1.0
 * */
public class Magicien extends Entity {

    private List<Item> ListOffense;
    private Item sort;
    private String Philtre;


    //getters
    public Item getSort() {
        return sort;
    }
    private String getPhiltre() {
        return Philtre;
    }
    @Override
    public Item getOffense() {
        return this.getSort();
    }
    @Override
    public String getDefense() {
        return this.getPhiltre();
    }
    @Override
    public List<Item> getListOffense() {
        return this.ListOffense;
    }
    //setters
    public void initOffense(){
        this.sort = this.getListOffense().get(generateRandom(0,this.getListOffense().size()-1));
    }
    public void setDefense(String philtre){
        this.Philtre = philtre;
    }


    /**
     * Constructor
     */
    public Magicien (){
        super(TypeEntity.MAGICIEN);
        this.ListOffense =  createListSort();
        this.initOffense();
        this.setDefense("Barrière Spirituelle");
    }
    public Magicien(String name,TypeEntity type){
        super(name,type);
        this.ListOffense =  createListSort();
        this.initOffense();
        this.setDefense("Barrière Spirituelle");
    }

    // Methods
    private List<Item>  createListSort(){
        List<Item> sort = new ArrayList<>();
        sort.add(new Sort("frail FireBall",3));
        sort.add(new Sort("weak FireBall",3));
        sort.add(new Sort("feeble FireBall" ,3));
        return sort;
    }
}

