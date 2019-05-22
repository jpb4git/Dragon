package edu.cnita.dragon.entities.archetype;


import edu.cnita.dragon.Obj;
import edu.cnita.dragon.Sort;
import edu.cnita.dragon.EnumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Magicien extends Entity {

    private List<Obj> ListOffense;
    private Obj sort;
    private String Philtre;


    //getters
    public Obj getSort() {
        return sort;
    }
    private String getPhiltre() {
        return Philtre;
    }
    @Override
    public Obj getOffense() {
        return this.getSort();
    }
    @Override
    public String getDefense() {
        return this.getPhiltre();
    }
    @Override
    public List<Obj> getListOffense() {
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
    public Magicien(String name,TypeEntity type){
        super(name,type);
        this.ListOffense =  createListSort();
        this.initOffense();
        this.setDefense("Barrière Spirituelle");
    }

    // Methods
    private List<Obj>  createListSort(){
        List<Obj> sort = new ArrayList<>();
        sort.add(new Sort("frail FireBall",3));
        sort.add(new Sort("weak FireBall",3));
        sort.add(new Sort("feeble FireBall" ,3));
        return sort;
    }

}

