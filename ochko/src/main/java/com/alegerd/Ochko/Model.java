package com.alegerd.Ochko;

import com.alegerd.Ochko.Classes.Card;
import com.alegerd.Ochko.Classes.Player;
import com.alegerd.Ochko.Interfaces.Observer;

import java.util.*;

/**
 * Created by alegerd on 12.03.17.
 */
public class Model<T> extends Thread implements Observer<T>{

    List<T> spareCards = new ArrayList<T>();
    List<Player> players = new ArrayList<Player>();
    List<Player> winners = new ArrayList<Player>();
    List<Player> bets = new ArrayList<Player>();


    public Model() {
        spareCards.add((T)new Card(6));
        spareCards.add((T)new Card(6));
        spareCards.add((T)new Card(6));
        spareCards.add((T)new Card(6));
        spareCards.add((T)new Card(7));
        spareCards.add((T)new Card(7));
        spareCards.add((T)new Card(7));
        spareCards.add((T)new Card(7));
        spareCards.add((T)new Card(8));
        spareCards.add((T)new Card(8));
        spareCards.add((T)new Card(8));
        spareCards.add((T)new Card(8));
        spareCards.add((T)new Card(9));
        spareCards.add((T)new Card(9));
        spareCards.add((T)new Card(9));
        spareCards.add((T)new Card(9));
        spareCards.add((T)new Card(10));
        spareCards.add((T)new Card(10));
        spareCards.add((T)new Card(10));
        spareCards.add((T)new Card(10));


        spareCards.add((T)new Card(2));
        spareCards.add((T)new Card(2));
        spareCards.add((T)new Card(2));
        spareCards.add((T)new Card(2));
        spareCards.add((T)new Card(3));
        spareCards.add((T)new Card(3));
        spareCards.add((T)new Card(3));
        spareCards.add((T)new Card(3));
        spareCards.add((T)new Card(4));
        spareCards.add((T)new Card(4));
        spareCards.add((T)new Card(4));
        spareCards.add((T)new Card(4));
        spareCards.add((T)new Card(11));
        spareCards.add((T)new Card(11));
        spareCards.add((T)new Card(11));
        spareCards.add((T)new Card(11));

        Player player1 = new Player(1,0.3f);
        Player player2 = new Player(2,0.7f);
        Player player3 = new Player(3,0.9f);
        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    @Override
    public void run() {
        for (Player player: players) {
            player.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Player player: players) {
            player.interrupt();
        }
//        while (!Thread.interrupted())
//        {
//
//        }
    }

    public <T> T giveCard() {
        return (T)spareCards.remove((int)Math.random() * spareCards.size());
    }

    public void makeBet(Player player) {
        bets.add(player);
    }

    private void chooseWinner() {

        winners.clear();

        if (!bets.isEmpty()) {
            boolean weHaveTheWinner = false;

            for (int i = 0; i < bets.size(); i++) {
                if (bets.get(i).getSum() == 21) {
                    winners.add(bets.get(i));
                    bets.remove(i);
                    weHaveTheWinner = true;
                }
                if (bets.get(i).getSum() > 21) {
                    bets.remove(i);
                }
            }

            if (!weHaveTheWinner && !bets.isEmpty()) {
                Collections.sort(bets, new Comparator<Player>() {
                    public int compare(Player o1, Player o2) {
                        return o1.compareTo(o2);
                    }
                });

                Player max = bets.get(0);
                winners.add(max);
                int i = 1;
                while (i < bets.size()) {
                    if(bets.get(i).getSum() == max.getSum()) winners.add(bets.get(i));
                    else break;
                }
            }
        }
    }

}
