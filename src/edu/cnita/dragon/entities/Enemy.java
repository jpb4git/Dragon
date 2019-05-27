package edu.cnita.dragon.entities;

import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.Interfaces.UI;
import edu.cnita.dragon.items.food.Apple;
import edu.cnita.dragon.ui.PlayerConsole;

import java.util.Random;
import java.util.Scanner;

public class Enemy implements Event {

    private Entity entity;



    private UI console;

    public Entity getEntity() {
        return entity;
    }


    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public UI getConsole() {
        return console;
    }


    public Enemy(Entity entity){
        //TODO recevoir en parametre L'ui !
        this.console = new PlayerConsole();

        this.setEntity(entity);
    }

    @Override
    public String whoIs() {
        return this.getEntity().getNom();
    }

    @Override
    public String actionEvent(Entity entity) {


        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Combat interaction while loop
        //TODO:gjgh
        while (bothStillAlive(entity)){
            this.getEntity().setHealth(playerAttack(entity, rand));
            if (isAlive()){
                System.out.println(this.getEntity().getNom() + " Died.");
                System.out.println("You loot the body ....");
                Event loot = generateLoot();
                loot.actionEvent(entity);
            }else{
                entity.setHealth(enemyAttack(entity, rand));
                if (!entity.isAlive() ){
                    System.out.println("you died.");
                }
            }
            this.getConsole().showEntityOneLine(entity.getNom(),entity.getHealth(),entity.getStrength());
            this.getConsole().showEntitysOneLine(entity,this);
            System.out.println("Next turn  (press any key)");
            sc.nextLine();
        }
        return ".";
    }

    private int enemyAttack(Entity entity, Random rand) {
        // enemy attak
        int playerLife;
        if (attackMissed(rand)){
            System.out.println(this.getEntity().getNom() +  " missed  his Attack ... ");
            playerLife = (entity.getHealth());

        }else{
            System.out.println(this.getEntity().getNom() + " reposte !");
            playerLife = (entity.getHealth() - this.getEntity().getOffense().getStrength());
            System.out.println(this.getEntity().getNom() + " bash you " +  " for " + this.getEntity().getOffense().getStrength());
        }
        return Math.max(0, playerLife);
    }



    private int playerAttack(Entity entity, Random rand) {
        int enemyLife;
        // player attak
        if (attackMissed(rand)){
            enemyLife = (this.getEntity().getHealth());
            System.out.println("You completly missed your attack ....");
        }else{
            enemyLife = (this.getEntity().getHealth() - entity.getOffense().getStrength());
            System.out.println("You bash this " + this.getEntity().getNom() + " for " + entity.getOffense().getStrength());
        }
        return Math.max(0, enemyLife);
    }


    private boolean isAlive() {
        return getEntity().getHealth() > 0;
    }

    private boolean bothStillAlive(Entity other) {
        return other.isAlive() && isAlive();
    }

    private boolean attackMissed(Random rand) {
        return rand.nextInt(4)==0;
    }

    @Override
    public String displayGraphicalString() {
        return "";
    }

    private Event generateLoot(){
        Event  event;
        Random rand = new Random();
        boolean loot = rand.nextInt(5)==0;
        if (loot){
            event = new Apple("half-Apple",2);
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
