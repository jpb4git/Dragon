package edu.cnita.dragon.dragonException;

import edu.cnita.dragon.enumArchetype.EnumError;

public class EntityTypeException extends Exception{

    public EntityTypeException(){
        System.out.println(EnumError.ERROR_TYPE_ENTITY_NUMBER_SELECTION.message);
    }


    public EntityTypeException(String msg){
        System.out.println(msg);
    }
}
