package edu.cnita.dragon.tiles;

import edu.cnita.dragon.Interfaces.Event;
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

    private Event setEvent() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 3 + 1;
        int randomInt = (int) randomDouble;
        Event  event = null;

        if (randomInt == 1){
            event = new Apple("apple", 5);
        }else if (randomInt == 2){
            Guerrier g = new Guerrier();
            g.setNom("Orc");
            event =g;

        }else {
            event = new Event() {
                @Override
                public String whoIs() {
                    return "Cette case est vide !";
                }

                @Override
                public String actionEvent() {
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

    public void ShowBoard(int index ) {
        String LineGraphic = "";
        for (int i = 0; i < this.getTiles().size(); i++) {
           /* System.out.println("Tile no : " + i);
            System.out.println(this.getTiles().get(i).getEvent().whoIs());
            this.getTiles().get(i).getEvent().actionEvent();

            */


        if (i == index ){
            LineGraphic +=  "@";
            LineGraphic +=  " ";
        }else {
            LineGraphic +=  this.getTiles().get(i).getEvent().displayGraphicalString();
            LineGraphic +=  " ";
        }

        }

        System.out.println(LineGraphic);

    }
}