package edu.cnita.dragon.tiles;

import edu.cnita.dragon.Interfaces.Event;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.entities.archetype.Guerrier;
import edu.cnita.dragon.items.food.Apple;

import java.util.ArrayList;
import java.util.List;

public class Board {


    private List<Tile> tiles = new ArrayList<>();


    public Board(int numTile) {
        initBoard(numTile);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }


    private void initBoard(int numTiles) {
        for (int i = 0; i < numTiles; i++) {

            //create Tile
            Tile t = new Tile(i);


            // create Item Or Enemy
            // affect Enemy or Item to TIle
            t.setEvent(setEvent());

            // add tile To tiles<Tile>
            this.getTiles().add(t);
        }
    }

    /**
     * Create a random event for a Tile
     * event can be (Entity Item or nothing )
     * @return Event
     */
    private Event setEvent() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 3 + 1;
        int randomInt = (int) randomDouble;
        Event  event;

        if (randomInt == 1){
            event = new Apple("apple", 5);
        }else if (randomInt == 2){
            Guerrier g = new Guerrier();
            g.setNom("Orc");
            event =g;
        }else {
            //Empty event
            event = new Event() {
                @Override
                public String whoIs() {
                    return "Cette case est vide !";
                }

                @Override
                public String actionEvent(Entity entity) {
                    return "Rien ne se passe ici.";
                }

                @Override
                public String displayGraphicalString() {
                    return "_";
                }
            };
        }
       return event;
    }
    public void  resetBoard(){
        this.getTiles().clear();
        initBoard(10);
    }
    public void ShowBoard(int index ) {
        StringBuilder LineGraphic = new StringBuilder();
        for (int i = 0; i < this.getTiles().size(); i++) {
            if (i == index ){
                LineGraphic.append("@");
                LineGraphic.append(" ");
            }else {
                LineGraphic.append(this.getTiles().get(i).getEvent().displayGraphicalString());
                LineGraphic.append(" ");
            }
        }

        System.out.println(LineGraphic);

    }
}