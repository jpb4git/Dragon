package edu.cnita.dragon.dragonException;

import edu.cnita.dragon.enumArchetype.EnumError;

public class GeneralMenuException extends Exception {

    public GeneralMenuException(){
        System.out.println(EnumError.ERROR_GENERAL_MENU_SELECTION.message);
    }
}
