package ca.sheridancollege.project;

import java.util.*;

public class MyGame extends Game{

    String winner;
    String p1_name = "player1";
    String p2_name = "player2";
    CardPlayer p1;
    CardPlayer p2;

    public MyGame(String name) {
        super(name);
        
        List<Card> cardDeck = new ArrayList<Card>(); 

        for(int x=0; x<4; x++){        
            for(int y=2; y<15; y++){    
                cardDeck.add(new Card(x,y)); 
            } 
        }

        Collections.shuffle(cardDeck, new Random()); 

        
        LinkedList<Card> deck1 = new LinkedList<Card>(cardDeck.subList(0, 26));
        LinkedList<Card> deck2 = new LinkedList<Card>(cardDeck.subList(26, cardDeck.size()));
        
        p1 = new CardPlayer(p1_name, deck1);
        p2 = new CardPlayer(p2_name, deck2);
    }

    public MyGame(String name, LinkedList<Card> deck1, LinkedList<Card> deck2) {
        super(name);
        p1 = new CardPlayer(p1_name, deck1);
        p2 = new CardPlayer(p2_name, deck2);
    }
    
    @Override
    public void play() {
        while (true) {
            
            if (p1.cards.getDeck().size() == 0) {
                winner = p2_name;
                break;
            }
            if (p2.cards.getDeck().size() == 0) {
                winner = p1_name;
                break;
            }
            
            System.out.printf("%s has %d cards.\n", p1_name, p1.cards.getDeck().size());
            System.out.printf("%s has %d cards.\n", p2_name, p2.cards.getDeck().size());
           
            LinkedList<Card> used = new LinkedList<>();
            Card card1 = p1.cards.getDeck().remove();
            Card card2 = p2.cards.getDeck().remove();
            System.out.printf("%s plays card is %s\n", p1_name, card1.toString());
            System.out.printf("%s plays card is %s\n", p2_name, card2.toString());
            used.add(card1);
            used.add(card2);
            if (card1.getNumber() > card2.getNumber()) {
                System.out.printf("%s wins this round.\n", p1_name);
                p1.cards.getDeck().addAll(used);
            } else if (card2.getNumber() > card1.getNumber()) {
                System.out.printf("%s wins this round.\n", p2_name);
                p2.cards.getDeck().addAll(used);
            } else { 
                System.out.println("The war begin!");
                
                boolean tie = true;
                while ((p1.cards.getDeck().size() >= 4 || p2.cards.getDeck().size() >= 4) && tie) {
                    if (p1.cards.getDeck().size() < 4) {
                        winner = p2_name;
                        break;
                    }
                    if (p2.cards.getDeck().size() < 4) {
                        winner = p1_name;
                        break;
                    }
                   
                    card1 = p1.cards.getDeck().get(3);
                    card2 = p2.cards.getDeck().get(3);
                    for (int i = 0; i < 4; i++) {
                        used.add(p1.cards.getDeck().remove());
                    }
                    for (int i = 0; i < 4; i++) {
                        used.add(p2.cards.getDeck().remove());
                    }
                    tie = card1.getNumber() == card2.getNumber();
                    if (card1.getNumber() > card2.getNumber()) {
                        p1.cards.getDeck().addAll(used);
                    }
                    if (card2.getNumber() > card1.getNumber()) {
                        p2.cards.getDeck().addAll(used);
                    }
                }
                if (tie) {
                    winner = "no winner";
                                  
                }
            }
        }
        System.out.println("The game is over!");
    }

    @Override
    public void declareWinner() {
        System.out.printf("The winner is : %s", getWinner());
    }

    public String getWinner() {
        return winner;
    }
}
