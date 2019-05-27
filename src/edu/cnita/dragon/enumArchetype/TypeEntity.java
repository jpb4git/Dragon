package edu.cnita.dragon.enumArchetype;

import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.entities.archetype.Guerrier;

/**
 * Enumération des Types d'entities.
 *
 */
public enum TypeEntity {
    GUERRIER (5,10,5,10,"Bouclier", "edu.cnita.dragon.entities.archetype.Guerrier") {
        @Override
        public Entity createEntity() throws Exception {
            return new Guerrier();
        }
    },
    MAGICIEN (3,6,8,15,"Philtre", "edu.cnita.dragon.entities.archetype.Magicien") {
        @Override
        public Entity createEntity() throws Exception {
            return null;
        }
    },
    ARCHER  (3,6,8,15,"Philtre", "edu.cnita.dragon.entities.archetype.Magicien") {
        @Override
        public Entity createEntity() throws Exception {
            return null;
        }
    };

    TypeEntity(int minH,int maxH,int minS,int maxS,String defense, String entityName) {
        this.minHealth   = minH;
        this.maxHealth   = maxH;
        this.minStrength = minS;
        this.maxStrength = maxS;
        this.defense = defense;
        this.entityName = entityName;
    }
    public final int minHealth;
    public final int maxHealth;
    public final int minStrength;
    public final int maxStrength;
    public final String defense;
    public final String entityName;

    /**
     *  création à la volée d'une instance
     * @return
     * @throws Exception
     */
    public abstract Entity createEntity() throws Exception;

}
