package edu.cnita.dragon.enumArchetype;

/**
 * liste des messages error disponibles
 */
public enum EnumError {
    ERROR_TYPE_SELECTION ( "Vous devez choisir un chiffre valide.",0),
    ERROR_GENERAL_MENU_SELECTION ( "Vous devez choisir un chiffre valide.",0),
    ERROR_REDIRECT ( "-",999),
    ERROR_ENTITY_SELECTION ("L'entité n'existe pas.",0),
    ERROR_TYPE_ENTITY_NUMBER_SELECTION ("Sélectionnez 1 ou 2 Pour le Type de l'entité.",0);
    EnumError(String message,int redirect) {
        this.redirect = redirect;
        this.message = message;
    }
    public final String message;
    public final int redirect;
}
