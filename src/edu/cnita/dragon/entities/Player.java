package edu.cnita.dragon.entities;

import edu.cnita.dragon.items.Item;

import java.util.List;

public class Player  extends Entity{

    private Entity entity;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }



    public Player(Entity entity){
        this.entity = entity;
    }


    @Override
    public Item getOffense() {
        return this.getEntity().getOffense();
    }

    @Override
    public String getDefense() {
        return this.getEntity().getDefense();
    }

    @Override
    public List<Item> getListOffense() {
        return this.getEntity().getListOffense();
    }

    @Override
    public void setDefense(String defense) {
            this.getEntity().setDefense(defense);
    }

    @Override
    public void initOffense() {
            this.getEntity().initOffense();
    }
}
