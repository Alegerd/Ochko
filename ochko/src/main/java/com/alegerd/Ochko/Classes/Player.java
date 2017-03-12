package com.alegerd.Ochko.Classes;

import com.alegerd.Ochko.Interfaces.*;

import java.util.*;
import com.alegerd.Ochko.Interfaces.Observable;
import com.alegerd.Ochko.Interfaces.Observer;

/**
 * Created by alegerd on 12.03.17.
 */
public class Player extends Thread implements Observable{


    public int number;
    private Integer sum;
    private boolean wasInterrupted;
    private float probabilityToPeek;
    private List<Card> cardList = new ArrayList<Card>();
    private List<Observer> observers = new LinkedList<Observer>();

    public Player(int number, float probabilityToPeek) {
        this.number = number;
        this.probabilityToPeek = probabilityToPeek;
    }

    @Override
    public void run() {
        wasInterrupted = false;
        while (true) {
            if(!Thread.interrupted() && !wasInterrupted) {
                makeTurn();
            }
            else return;
        }
    }

    private void makeTurn(){
        try {
            Thread.sleep(10000 * 1/number);
            System.out.println(number + " - ой игрок");
        } catch (InterruptedException e) {
           wasInterrupted = true;
        }
    }

    public Integer getSum() {
        return sum;
    }

    private boolean wishToPeekAnotherCard() {
        if(sum < 21){
            return (Math.random() < probabilityToPeek)? true : false;
        }
        return false;
    }

    public int compareTo(Player player) {
        return this.sum.compareTo(player.getSum());
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver(int whatToDo) {
        for (Observer o:observers ) {
            switch (whatToDo)
            {
                case 0 : o.giveCard(); break;
                case 1 : o.makeBet(this);
            }

        }
    }
}
