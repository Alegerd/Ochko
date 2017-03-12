package com.alegerd.Ochko.Classes;

/**
 * Created by alegerd on 12.03.17.
 */
public class Card {

    private Integer value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(Card anotherCard) {
        return this.value.compareTo(anotherCard.value);
    }
}
