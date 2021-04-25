package ca.sheridancollege.project;

import java.util.*;

public class CardPlayer extends Player {

    GroupOfCards cards = new GroupOfCards();

    public CardPlayer(String name, LinkedList<Card> cards) {
        super(name);
        this.cards.setDeck(cards);
        this.cards.shuffle();
    }

    @Override
    public void play() {

    }
}
