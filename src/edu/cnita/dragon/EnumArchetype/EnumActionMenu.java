package edu.cnita.dragon.EnumArchetype;

public enum  EnumActionMenu {
    LISTE_ENTITIES(2),
    CREATE_ENTITY(1),
    EDIT_ENTITY(3),
    DELETE_ENTITY(4),
    EXIT_GLOBAL(5);

    private int value;
    EnumActionMenu(int value) { this.value = value; }
    public int getValue(){ return value;}

}
