package edu.cnita.dragon.game;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.ui.Console;
import edu.cnita.dragon.ui.UI;

import java.util.ArrayList;
import java.util.List;

import static edu.cnita.dragon.EnumArchetype.EnumActionMenu.*;

public class Game {

    UI console;
    List<Entity> entities = new ArrayList<>();

    // Getters
    public List<Entity> getEntities() {
        return entities;
    }
    public UI getConsole() {
        return console;
    }

    /**  Constructor  */
    public Game (){
         this.console = new Console(this.getEntities());
    }

    /**
     * Menu General
     */
    public void playGame(){
        int response = 0;

        response = this.getConsole().showMenu();

        while (response !=  EXIT_GLOBAL.getValue()) {
            if (CREATE_ENTITY.getValue() == response){
                AddEntity();
            }else if (EDIT_ENTITY.getValue() == response){
                SubMenuPrepareEntries();
            }else if (LISTE_ENTITIES.getValue() == response){
                showListEntity();
            }else if (DELETE_ENTITY.getValue() == response){
                SubMenuPrepareEntriesDelete();
            }else{
                this.getConsole().showMenuHeader();
            }
            response = this.getConsole().showMenu();
        }
    }

    //EDITING ENTITY -----------------------------------------------------
    /**
     * prepare les Actions possibles  et update le choix utilisateur
     * updade Entity
     */
    public void SubMenuPrepareEntries(){
        int response;
        response = EntityToStringMenu();
        // Sub menu edit Entity
        while (response != 999){
            this.getEntities().set(response, this.getConsole().formEntity(this.getEntities().get(response)));
            response = EntityToStringMenu();
        }
    }

    /**
     *
     * @return String (liste des actions possibles )
     */
    private int  EntityToStringMenu(){

        String[] actionArr = new  String[this.getEntities().size() + 1];
        for (int i = 0 ; i < this.getEntities().size() ;i++) {
            actionArr[i] =  this.getEntities().get(i).getNom() + " Tapez " + i + "  |  ";
        }
        actionArr[actionArr.length - 1 ] = " Quittez le mode édition :: 999 ";
        return this.getConsole().showEditMenuEntity(actionArr);
    }
    //DELETE ENTITY -----------------------------------------------------
    /**
     * Affiche la liste des entities par index et supprime la selection
     */
    public void SubMenuPrepareEntriesDelete(){
        int response;
        response = EntityToStringMenuDelete();
        while (response != 999){
          //this.getEntities(removeEntityFromArray(this.getEntities(),response));
          try{
              this.getEntities().remove(response);
          }catch(Exception e){
              System.out.println("Erreur lors de la suppression  de l'element")  ;
          }
          response = EntityToStringMenuDelete();
        }
    }

    /**
     * Format list of entities  by showing index in arrayList Entities
     * @return String Possible actions
     */
    private int  EntityToStringMenuDelete(){
        String[] actionArr = new  String[this.getEntities().size() + 1];
        for (int i = 0 ; i < this.getEntities().size() ;i++) {
            actionArr[i] =  this.getEntities().get(i).getNom() + " Tapez " + i + "  |  ";
        }
        actionArr[actionArr.length - 1 ] = " Quittez le mode Suppression :: 999 ";
        return this.getConsole().showDeleteMenuEntity(actionArr);
    }

    /**
     * add new entity in AllayList Entities
     */
    public void AddEntity(){
        Entity newEntity = this.getConsole().createEntity();
        this.getEntities().add(newEntity);
    }
    /**
     * ShowListEntity envoie les informations des entités à la console
     */
    public void  showListEntity (){
        for (int i = 0 ; i < this.getEntities().size() ;i++) {

            this.getConsole().showEntity(this.getEntities().get(i).getType().toString(), this.getEntities().get(i).getNom(), this.getEntities().get(i).getHealth(),this.getEntities().get(i).getStrength(), this.getEntities().get(i).getOffense().getNom(), this.getEntities().get(i).getOffense().getStrength(), this.getEntities().get(i).getDefense());
        }
    }


}
