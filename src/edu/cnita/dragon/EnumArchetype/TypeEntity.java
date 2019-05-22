package edu.cnita.dragon.EnumArchetype;

public enum TypeEntity {
    GUERRIER (5,10,5,10,"Bouclier"),
    MAGICIEN (3,6,8,15,"Philtre");

    TypeEntity(int minH,int maxH,int minS,int maxS,String defense) {
        this.minHealth   = minH;
        this.maxHealth   = maxH;
        this.minStrength = minS;
        this.maxStrength = maxS;
        this.defense = defense;
    }
    public final int minHealth;
    public final int maxHealth;
    public final int minStrength;
    public final int maxStrength;
    public final String defense;

}
