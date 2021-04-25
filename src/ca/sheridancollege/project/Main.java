package ca.sheridancollege.project;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Card> deck1 = new LinkedList<>();
        LinkedList<Card> deck2 = new LinkedList<>();
        LinkedList<Card> deck = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                deck.add(new Card(i, j));
            }
        }
        deck1.addAll(deck.subList(0, 26));
        deck2.addAll(deck.subList(26, 52));
        MyGame myGame = new MyGame("Game of Throne.");
        myGame.play();
        myGame.declareWinner();
    }
}
