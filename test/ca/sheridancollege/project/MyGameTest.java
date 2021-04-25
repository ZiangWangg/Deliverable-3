
package ca.sheridancollege.project;

import java.util.LinkedList;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author 22112
 */
public class MyGameTest {
    
    public MyGameTest() {
        
    }
    
    @Test
    public void testplayer1Win() {
        LinkedList<Card> deck1 = new LinkedList<>();
        LinkedList<Card> deck2 = new LinkedList<>();
        LinkedList<Card> deck = new LinkedList<>();
        for (int j = 2; j < 15; j++) {
            for (int i = 0; i < 4; i++) {
                deck.add(new Card(i, j));
            }
        }
        deck2.addAll(deck.subList(0, 26));
        deck1.addAll(deck.subList(26, 52));
        MyGame myGame = new MyGame("test-game", deck1, deck2);
        myGame.play();
        assertEquals("player1", myGame.getWinner());
    }
    
        @Test
    public void testplayer2Win() {
        LinkedList<Card> deck1 = new LinkedList<>();
        LinkedList<Card> deck2 = new LinkedList<>();
        LinkedList<Card> deck = new LinkedList<>();
        for (int j = 2; j < 15; j++) {
            for (int i = 0; i < 4; i++) {
                deck.add(new Card(i, j));
            }
        }
        deck1.addAll(deck.subList(0, 26));
        deck2.addAll(deck.subList(26, 52));
        MyGame myGame = new MyGame("test-game", deck1, deck2);
        myGame.play();
        assertEquals("player2", myGame.getWinner());
    }
    

    
   
}
