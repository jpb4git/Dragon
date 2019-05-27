package edu.cnita.dragon.game;
import edu.cnita.dragon.dragonException.NameLengthException;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.tiles.Board;
import edu.cnita.dragon.ui.Console;
import edu.cnita.dragon.Interfaces.UI;

import java.util.ArrayList;
import java.util.List;

import static edu.cnita.dragon.enumArchetype.EnumActionMenu.*;

/**
 * Game
 * <p>
 * La classe Game est la classe principale
 * Pour la logique du jeu.
 * <p>
 * (@author)
 *
 * @version 1.0
 */
public class Game {

    private UI console;
    private List<Entity> entities = new ArrayList<>();
    private Board board;
    private Entity activePlayer;

    // Getters
    public List<Entity> getEntities() {
        return entities;
    }
    private Board getBoard() { return board; }
    private UI getUi() {
        return console;
    }
    private Entity getActivePlayer() {
        return activePlayer;
    }
    //SETTER
    private void setActivePlayer(Entity activePlayer) {
        this.activePlayer = activePlayer;
    }
    /**
     * Constructor
     */
    public Game() {
        this.console = new Console(this.getEntities());
        this.board = new Board(10);
        this.getBoard().ShowBoard(0);
    }

    /**
     * Handle the General menu
     * <p>
     *  This method always returns immediately,the user response Scanner
     * </p>
     */
    public void playGame(){
        int response = this.getUi().showMenu();
        while (response !=  EXIT_GLOBAL.getValue()) {

            if (CREATE_ENTITY.getValue() == response){
                try {
                    AddEntity();
                }catch (Exception e){ }
            }else if (EDIT_ENTITY.getValue() == response){
                SubMenuPrepareEntries();
            }else if (LISTE_ENTITIES.getValue() == response){
                showListEntity();
            }else if (DELETE_ENTITY.getValue() == response){
                SubMenuPrepareEntriesDelete();
            }else if(ADVENTURE.getValue() == response){
                showGame();
            }
            response = this.getUi().showMenu();
        }
    }

    /**
     * Lance la partie dans le donjon.
     *
     */
    private void showGame(){
            int response;
           // String step; // newt feature show states entity ennemy by turn


            // si aucune Entity presente dans la list
            if (this.getEntities().size() == 0){
             System.out.println("pas de personnage dans la list ! ");
             this.AddEntity();
            }

            response = this.getUi().playerSelect();

            // regen Entity Life
            if (this.getEntities().get(response).getHealth() <= 0){
                Entity e = this.getEntities().get(response);
                e.setHealth(e.generateRandom(e.getType().minHealth, e.getType().maxHealth));
            }


            // set the active player
            this.setActivePlayer(this.getEntities().get(response));
            System.out.println("Entité  sélectionnée : "  + this.getActivePlayer().getNom());


            this.getBoard().resetBoard();
            // on parcours le dungeon piece par piece
            for (int i = 0; i < this.getBoard().getTiles().size();i++){


                // show player position
                this.getUi().showPlayerPosition(i);
                //Status and Event in room  #here combat and loot stuff
                this.getBoard().getTiles().get(i).getEvent().actionEvent(this.getActivePlayer());
                //this.getUi().showStatusRoom( );
                // show   One line Info player  # add enemy
                this.getUi().showEntityOneLine(this.getActivePlayer().getNom(),this.getActivePlayer().getHealth(),this.getActivePlayer().getStrength());
                // show dungeon line
                this.getBoard().ShowBoard(i);
                String step = this.getUi().nextStepDungeon(); //

                if (this.getActivePlayer().getHealth() <= 0 ){
                    break;
                }

            }


     }

    //EDITING ENTITY -----------------------------------------------------
    /**
     * prepare les Actions possibles  et update le choix utilisateur
     * updade Entity
     */
    private void SubMenuPrepareEntries(){
        int response;
        response = EntityToStringMenu();
        // Sub menu edit Entity
        while (response != 999){
            //Mise à jour de l'entity
            this.getEntities().set(response, this.getUi().formEditionEntity(this.getEntities().get(response)));
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

        actionArr[actionArr.length - 1] = " Quittez le mode édition :: 999 ";
        return this.getUi().showEditMenuEntity(actionArr);
    }
    //DELETE ENTITY -----------------------------------------------------
    /**
     * Affiche la liste des entities par index et supprime la selection
     */
    private void SubMenuPrepareEntriesDelete(){
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
        return this.getUi().showDeleteMenuEntity(actionArr);
    }

    /**
     * add new entity in AllayList Entities
     */
    protected void AddEntity(){

        while (true){
            try {
              String name =  this.getUi().setNameEntity();
              this.getEntities().add(this.getUi().createEntity(name));
              return;
            } catch (NameLengthException e) {
                System.out.println(e.getMsg());
            }
        }
    }

    /**
     * ShowListEntity envoie les informations des entités à la console
     */
    private void  showListEntity(){
        for (int i = 0 ; i < this.getEntities().size() ;i++) {

            this.getUi().showEntity(this.getEntities().get(i).getType().toString(), this.getEntities().get(i).getNom(), this.getEntities().get(i).getHealth(),this.getEntities().get(i).getStrength(), this.getEntities().get(i).getOffense().getNom(), this.getEntities().get(i).getOffense().getStrength(), this.getEntities().get(i).getDefense());
        }
    }


}
