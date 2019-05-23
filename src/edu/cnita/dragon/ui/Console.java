package edu.cnita.dragon.ui;

import edu.cnita.dragon.dragonException.EntityTypeException;
import edu.cnita.dragon.dragonException.NameLengthException;
import edu.cnita.dragon.enumArchetype.EnumActionMenu;
import edu.cnita.dragon.enumArchetype.EnumError;
import edu.cnita.dragon.enumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.entities.archetype.Guerrier;
import edu.cnita.dragon.entities.archetype.Magicien;

import java.util.List;
import java.util.Scanner;

/**
 * Console
 * <p>
 * La classe Console est la classe principale
 * Pour l'affiche Utilisateur du jeu.
 * <p>
 * Elle implemente UI interface
 * <p>
 * (@author)
 *
 * @version 1.0
 */
public class Console implements UI {
    //Attributs
    private List<Entity> entities;
    private Scanner sc;

    //getters
    public List<Entity> getEntities() {
        return entities;
    }

    public Scanner getSc() {
        return sc;
    }

    // Constructor
    public Console(List<Entity> entities) {
        this.entities = entities;
        this.sc = new Scanner(System.in);
    }

    /**
     * Affichage menu Principal
     */
    public void showMenuHeader() {

        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println("Ajouter une Entité :: " + EnumActionMenu.CREATE_ENTITY.getValue() +
                " | Liste Entités :: " + EnumActionMenu.LISTE_ENTITIES.getValue() +
                " | éditer une Entité :: " + EnumActionMenu.EDIT_ENTITY.getValue() +
                " | Supprimer une entité :: " + EnumActionMenu.DELETE_ENTITY.getValue() +
                " | Quitter :: " + EnumActionMenu.EXIT_GLOBAL.getValue() + " |");
        System.out.println("_______________________________________________________________________________________________________________");

    }

    public void showMenuEditHeader() {

        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println(" EDITION  ");
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println("_______________________________________________________________________________________________________________");


    }

    public void showMenuDeleteHeader() {
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println(" DELETE  ");
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println("_______________________________________________________________________________________________________________");
    }

    /**
     * ask for user choice
     *
     * @return int user choice
     */
    public int showMenu() {
        showMenuHeader();
        String str = this.getSc().nextLine();
        try {

            return Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println(EnumError.ERROR_GENERAL_MENU_SELECTION.message);
        }
        return 0;
    }

    /**
     * @param type            enum archétype de l'entité
     * @param nom             String nom de l'entité
     * @param health          int niveau de vie de l'entité
     * @param strength        int niveau de force de l'entité
     * @param offense         String nom de [ l'arme / sort ] de l'entité
     * @param strengthOffense int force de [ l'arme / sort ] de l'entité
     * @param defense         String nom de la defense
     */
    public void showEntity(String type, String nom, int health, int strength, String offense, int strengthOffense, String defense) {

        System.out.println("____________________________");
        System.out.println("|---------- " + type + " -------");
        System.out.println("|Name : " + nom);
        System.out.println("|Health : " + health);
        System.out.println("|Strength : " + strength);
        System.out.println("|----------------------------");
        System.out.println("|Weapon : " + offense);
        System.out.println("|Strength Weapon : " + strengthOffense);
        System.out.println("|----------------------------");
        System.out.println("|Defensif : " + defense);

    }

    /**
     * Create Entity
     *
     * @return Entity
     */
    public Entity createEntity(String name) {
        Boolean error = true;
        //String name;
        String str = "";
        while (error) {
            System.out.println(" L'archétype  de votre personnage :: 1 pour " + TypeEntity.GUERRIER + "  |  2 pour  " + TypeEntity.MAGICIEN + " ? :");
            str = this.getSc().nextLine();
            try {
                setTypeEntity(str);
                error = false;
                if (Integer.parseInt(str) == 1) {
                    System.out.println("Vous avez choisi : " + TypeEntity.GUERRIER.toString());
                    return new Guerrier(name, TypeEntity.GUERRIER);
                } else {
                    System.out.println("Vous avez choisi : " + TypeEntity.MAGICIEN);
                    return new Magicien(name, TypeEntity.MAGICIEN);
                }
            } catch (Exception e) {
            }
        }
        // never pass here !
        return null;
    }

    public String setNameEntity() throws NameLengthException {
        String name = "";
        System.out.println("Choisissez un Nom pour votre personnage  : ");
        name = this.getSc().nextLine();

        if (name.length() > 10) {
            throw new NameLengthException("le Nom ne doit pas être supérieur à dix caractères.");
        }


        if (name.length() <= 3) {
            throw new NameLengthException("le Nom ne doit pas être minimum  à 3 caractères.");
        }


        return name;
    }

    private void setTypeEntity(String str) throws EntityTypeException {
        int temp = 0;
        try {
            temp = Integer.parseInt(str);
        } catch (Exception e) {
            throw new EntityTypeException();
        }
        if (Integer.parseInt(str) != 1 && Integer.parseInt(str) != 2) {
            throw new EntityTypeException();
        }
    }

    public int showEditMenuEntity(String[] action) {
        showMenuEditHeader();
        String output = " ";
        Boolean error = true;
        for (String s : action) {
            output += s;
        }


        while (error) {
            System.out.println(output);
            try {
                this.getEntities().get(Integer.parseInt(this.getSc().nextLine()));
            } catch (Exception e) {
                System.out.println(EnumError.ERROR_ENTITY_SELECTION.message);
                error = true;
            }

        }

        return Integer.parseInt(this.getSc().nextLine());
    }

    public int showDeleteMenuEntity(String[] action) {
        showMenuDeleteHeader();
        String output = " ";
        for (String s : action) {
            output += s;
        }
        System.out.println(output);
        return Integer.parseInt(this.getSc().nextLine());
    }

    public Entity formEntity(Entity entity) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println(entity.getNom() + " | Health:" + entity.getHealth() + " | Strength:" + entity.getStrength() + " | Defense :" + entity.getDefense() + " | Offense :" + entity.getOffense().getNom());
        System.out.println("EDITION ][ Nom Entity  : ");
        str = sc.nextLine();
        if (!str.equals("")) {
            entity.setNom(str);
        }


        System.out.println("EDITION ][ Nom " + entity.getType().defense + "  : ");
        str = sc.nextLine();
        if (!str.equals("")) {
            entity.setDefense(str);
        }

        System.out.println("EDITION ][ Relancer les dés de vie ?  y/n  : ");
        str = sc.nextLine();
        if (str.equals("y")) {
            entity.setHealth(entity.generateRandom(entity.getType().minHealth, entity.getType().maxHealth));
        }

        System.out.println("EDITION ][ Relancer les dés de puissance ?  y/n  : ");
        str = sc.nextLine();
        if (str.equals("y")) {
            entity.setStrength(entity.generateRandom(entity.getType().minStrength, entity.getType().maxStrength));
        }

        System.out.println("EDITION ][ Relancer les dés pour l'arme ?  y/n  : ");
        str = sc.nextLine();
        if (str.equals("y")) {
            //souhait
            entity.initOffense();
        }

        //------------------------------------------------------------------------------
        System.out.println("Modification récapitulatif :");
        System.out.println(entity.getNom() + " | Health:" + entity.getHealth() + " | Strength:" + entity.getStrength() + " | Defense :" + entity.getDefense() + " | Offense :" + entity.getOffense().getNom());

        return entity;
    }

    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
    }

}
