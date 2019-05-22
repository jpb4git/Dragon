package edu.cnita.dragon.dragonException;

public class NameLengthException extends Exception {


    private String msg;



    public NameLengthException(String msg){
        this.msg = msg;

    }


    public String getMsg() {
        return msg;
    }
}
