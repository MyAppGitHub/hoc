package com.example.jholland20.myapp;

/**
 * Created by jholland20 on 1/19/17.
 */

public class Block_Input {

    String action;

    public Block_Input(String action) {
        this.action = action;
    }

    public void setAction(String action){
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public boolean delay(long milli){
        long old = System.currentTimeMillis();

        while (System.currentTimeMillis() - old == milli){
            return true;
        }
        return false;
    }

}
