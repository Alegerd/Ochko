package com.alegerd.Ochko.Interfaces;

import com.alegerd.Ochko.Classes.Player;

/**
 * Created by alegerd on 12.03.17.
 */
public interface Observer<T> {
    <T> T giveCard();
    void makeBet(Player player);
}
