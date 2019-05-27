package edu.cnita.dragon.ui;

import edu.cnita.dragon.Interfaces.UI;
import edu.cnita.dragon.dragonException.NameLengthException;
import edu.cnita.dragon.entities.Enemy;
import edu.cnita.dragon.entities.Entity;

public class PlayerConsole implements UI {
    @Override
    public int showMenu() {
        return 0;
    }

    @Override
    public void showMenuHeader() {

    }

    @Override
    public void showMenuEditHeader() {

    }

    @Override
    public void showMenuDeleteHeader() {

    }

    @Override
    public Entity createEntity(String name) {
        return null;
    }

    @Override
    public String setNameEntity() throws NameLengthException {
        return null;
    }

    @Override
    public int showEditMenuEntity(String[] action) {
        return 0;
    }

    @Override
    public int showDeleteMenuEntity(String[] action) {
        return 0;
    }

    @Override
    public void showEntity(String type, String nom, int health, int strength, String offense, int strengthOffense, String defense) {

    }

    @Override
    public void showEntityOneLine(String nom, int health, int strength) {
        System.out.println("|----------------------------|");
        System.out.print("|Name: " + nom);
        System.out.print(" |Health: " + health);
        System.out.println(" |Strength: " + strength);
        System.out.println("|----------------------------|");
    }

    @Override
    public void showEntitysOneLine(Entity player, Enemy ennemy) {
        System.out.println("|---------------------------------------------------------------------------|");
        System.out.println("|Name: " + player.getNom()  + "              |Name: " + ennemy.getEntity().getNom());
        System.out.println("|health: " + player.getHealth()  + "              |health: " + ennemy.getEntity().getHealth());
        System.out.println("|Strength: " + player.getStrength()  + "              |Strength: " + ennemy.getEntity().getStrength());
        System.out.println("|---------------------------------------------------------------------------|");
    }

    @Override
    public Entity formEditionEntity(Entity entity) {
        return null;
    }

    @Override
    public int playerSelect() {
        return 0;
    }

    @Override
    public void showPlayerPosition(int index) {

    }

    @Override
    public void showStatusRoom(String status) {

    }

    @Override
    public String nextStepDungeon() {
        return null;
    }

    @Override
    public void statusCombatLoop(int attk, String message) {

    }
}
