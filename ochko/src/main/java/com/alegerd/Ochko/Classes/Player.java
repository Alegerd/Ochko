package com.alegerd.Ochko.Classes;

import java.util.*;

/**
 * Created by alegerd on 12.03.17.
 */
public class Player extends Thread {

    private int sum;
    private float probabilityToPeek;
    private List<Card> cardList = new ArrayList<Card>();

    public Player(float probabilityToPeek) {
        this.probabilityToPeek = probabilityToPeek;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            makeTurn();
        }
    }

    private void makeTurn(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) { }
    }

    private boolean wishToPeekAnotherCard() {
        if(sum < 21){
            return (Math.random() < probabilityToPeek)? true : false;
        }
        return false;
    }
}
