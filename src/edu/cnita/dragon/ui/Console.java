package edu.cnita.dragon.ui;

import edu.cnita.dragon.EnumArchetype.EnumActionMenu;
import edu.cnita.dragon.EnumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.entities.archetype.Guerrier;
import edu.cnita.dragon.entities.archetype.Magicien;
import edu.cnita.dragon.game.Game;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
public class Console implements UI{


    //Attributs
    private List<Entity> entities;
    private Scanner  sc;
    //getters
    public List<Entity> getEntities() {
        return entities;
    }
    public Scanner getSc() { return sc; }
    // Constructor
    public Console(List<Entity> entities){
        this.entities =  entities;
        this.sc = new Scanner(System.in);
    }

    /**
     * Affichage menu Principal
     */
    public void showMenuHeader(){

        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("Ajouter une Entité :: "+ EnumActionMenu.CREATE_ENTITY.getValue() +
                           " | Liste Entités :: "+EnumActionMenu.LISTE_ENTITIES.getValue()+
                           " | éditer une Entité :: "+EnumActionMenu.EDIT_ENTITY.getValue()+
                           " | Supprimer une entité :: "+EnumActionMenu.DELETE_ENTITY.getValue() +
                           " | Quitter :: "+ EnumActionMenu.EXIT_GLOBAL.getValue() + " |" );
        System.out.println("_______________________________________________________________________________________________________________" );

    }
    public void showMenuEditHeader(){

        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println(" EDITION  ");
        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("_______________________________________________________________________________________________________________" );



    }
    public void showMenuDeleteHeader(){
        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.println(" DELETE  ");
        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("_______________________________________________________________________________________________________________" );
    }
    /**
     * ask for user choice
     * @return int user choice
     */
    public int showMenu(){
        showMenuHeader();
        String str = this.getSc().nextLine();
        //this.getSc().close();// memory ....
        return  Integer.parseInt(str);
    }
    /**
     *
     * @param type              enum archétype de l'entité
     * @param nom               String nom de l'entité
     * @param health            int niveau de vie de l'entité
     * @param strength          int niveau de force de l'entité
     * @param offense           String nom de [ l'arme / sort ] de l'entité
     * @param strengthOffense   int force de [ l'arme / sort ] de l'entité
     * @param defense           String nom de la defense
     */
    public void showEntity(String type,String nom,int health,int strength,String offense,int strengthOffense, String defense){

            System.out.println("____________________________");
            System.out.println("|---------- " +type + " -------");
            System.out.println("|Name : " + nom);
            System.out.println("|Health : " + health);
            System.out.println("|Strength : " + strength);
            System.out.println("|----------------------------");
            System.out.println("|Weapon : " + offense);
            System.out.println("|Strength Weapon : " + strengthOffense);
            System.out.println("|----------------------------");
            System.out.println("|Defensif : " + defense);

    }
    public Entity createEntity(){

        String name;
        System.out.println("Choisissez un Nom pour votre personnage  : " );
        name = this.getSc().nextLine();
        System.out.println(" L'archétype  de votre personnage :: 1 pour " + TypeEntity.GUERRIER + "  |  2 pour  " + TypeEntity.MAGICIEN + " ? :");
        String str = this.getSc().nextLine();
        if (Integer.parseInt(str) == 1 ){
            System.out.println("Vous avez choisi : " + TypeEntity.GUERRIER.toString());
            return new Guerrier(name , TypeEntity.GUERRIER);
        }else{
            System.out.println("Vous avez choisi : " + TypeEntity.MAGICIEN);
            return  new Magicien(name ,TypeEntity.MAGICIEN);
        }
    }
    public int showEditMenuEntity(String[] action){
        showMenuEditHeader();
        String output=" ";
        for (String s : action) {
            output += s;
        }
        System.out.println(output);
        return  Integer.parseInt(this.getSc().nextLine());
    }
    public int showDeleteMenuEntity(String[] action){
        showMenuDeleteHeader();
        String output=" ";
        for (String s : action) {
            output += s;
        }
        System.out.println(output);
        return  Integer.parseInt(this.getSc().nextLine());
    }
    public Entity formEntity(Entity entity){
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println(entity.getNom() + " | Health:" + entity.getHealth()+ " | Strength:" + entity.getStrength()+ " | Defense :" + entity.getDefense() + " | Offense :"+ entity.getOffense().getNom());
        System.out.println("EDITION ][ Nom Entity  : " );
        str = sc.nextLine();
        if (!str.equals("")){
            entity.setNom(str);
        }


        System.out.println("EDITION ][ Nom "+entity.getType().defense +"  : " );
        str = sc.nextLine();
        if (!str.equals("")) {
            entity.setDefense(str);
        }

        System.out.println("EDITION ][ Relancer les dés de vie ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
             entity.setHealth(entity.generateRandom(entity.getType().minHealth,entity.getType().maxHealth));
        }

        System.out.println("EDITION ][ Relancer les dés de puissance ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
             entity.setStrength(entity.generateRandom(entity.getType().minStrength,entity.getType().maxStrength));
        }

        System.out.println("EDITION ][ Relancer les dés pour l'arme ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            //souhait
            entity.initOffense();
        }

        //------------------------------------------------------------------------------
        System.out.println("Modification récapitulatif :");
        System.out.println(entity.getNom() + " | Health:" + entity.getHealth()+ " | Strength:" + entity.getStrength()+ " | Defense :" + entity.getDefense() + " | Offense :"+ entity.getOffense().getNom());

        return entity;
    }
    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
    }

}
