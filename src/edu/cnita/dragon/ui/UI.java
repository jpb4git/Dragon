package edu.cnita.dragon.ui;

import edu.cnita.dragon.dragonException.EntityTypeException;
import edu.cnita.dragon.dragonException.NameLengthException;
import edu.cnita.dragon.entities.Entity;

/**
 * UI
 * <p>
 * L'Interface UI renseigne les methods
 * Pour l'affichage du jeu.
 * <p>
 * (@author)
 *
 * @version 1.0
 */
public interface UI {

    int  showMenu();
    void showMenuHeader();
    void showMenuEditHeader();
    void showMenuDeleteHeader();


    Entity createEntity(String name);
    String setNameEntity() throws NameLengthException;
    int showEditMenuEntity(String[] action);
    int showDeleteMenuEntity(String[] action);
    void showEntity(String type,String nom,int health,int strength,String offense,int strengthOffense, String defense);
    Entity formEditionEntity(Entity entity);

}
