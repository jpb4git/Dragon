package edu.cnita.dragon.entities.archetype;


import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.Interfaces.UI;
import edu.cnita.dragon.items.food.Apple;
import edu.cnita.dragon.items.weapons.Arme;
import edu.cnita.dragon.items.Item;
import edu.cnita.dragon.enumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.ui.PlayerConsole;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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



    private UI console;

    public String getGraphicString() {
        return graphicString;
    }

    public void setGraphicString(String graphicString) {
        this.graphicString = graphicString;
    }

    private String graphicString;
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
    public UI getConsole() { return console; }
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
        this.setGraphicString("G");
        //
        this.console = new PlayerConsole();

    }


    //Methods
    private List<Item>  createListWeapon(){
        List<Item> armes = new ArrayList<>();
        armes.add(new Arme("cleave Hachette",3));
        armes.add(new Arme ("spliter Hachette",3));
        armes.add(new Arme ("crackle Hachette",3));
        return armes;
    }


    @Override
    public String whoIs() {
        return "an "+ this.getNom()  +"over their ..."  ;
    }

    @Override
    public String actionEvent(Entity entity){
        int newlife;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        boolean miss = rand.nextInt(4)==0;

        // Flip coin for starting combat turn

        //Combat interaction while loop
        while (entity.getHealth() > 0 && this.getHealth() > 0){

          // player attak
            if (miss){
                newlife = (this.getHealth());
                System.out.println("You completly missed your attack ....");
            }else{
                newlife = (this.getHealth() - entity.getOffense().getStrength());
                System.out.println("You bash this " + this.getNom() + " for " + entity.getOffense().getStrength());
            }


            if (newlife <= 0 ){
                System.out.println(this.getNom() + " Died.");

                this.setHealth(0);
                System.out.println("You loot the body ....");
                Event loot = generateLoot();
                //
                System.out.println(loot.whoIs());
                loot.actionEvent(entity);

            }else{
               this.setHealth(newlife);
                miss = rand.nextInt(4)==0;
                // enemy attak
                if (miss){
                    System.out.println(this.getNom() +  " missed  his Attack ... ");
                    newlife = (entity.getHealth());

                }else{
                    System.out.println(this.getNom() + " reposte !");
                    newlife = (entity.getHealth() - this.getOffense().getStrength());
                    System.out.println(this.getNom() + " bash you " +  " for " + this.getOffense().getStrength());
                }

                entity.setHealth(newlife);
                if (entity.getHealth() <= 0 ){
                    System.out.println("you died.");

                }
            }
            miss = rand.nextInt(4)==0;
            this.getConsole().showEntityOneLine(entity.getNom(),entity.getHealth(),entity.getStrength());
            this.getConsole().showEntitysOneLine(entity,this);
            System.out.println("Next turn  (press any key)");
            sc.nextLine();
        }

        return ".";
    }

    @Override
    public String displayGraphicalString() {
        return this.getGraphicString();
    }

    private Event generateLoot(){
        Event  event = null;
        Random rand = new Random();
        boolean loot = rand.nextInt(5)==0;

        if (loot){
            Item A = new Apple("half-Apple",2);
            event = A;
        }else{
            event = new Event(){
                @Override
                public String whoIs() {
                    return "You found nothing valuable ...";
                }

                @Override
                public String actionEvent(Entity entity) {
                    return " ";
                }

                @Override
                public String displayGraphicalString() {
                    return " ";
                }
            };

        }

        return event;
    }

}
