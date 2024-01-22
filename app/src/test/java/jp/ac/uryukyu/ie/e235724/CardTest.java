package jp.ac.uryukyu.ie.e235724;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void testCardConstructor() {
        Card card = new Card("Spade", "Ace");
        assertEquals("Spade", card.getSuit());
        assertEquals("Ace", card.getRank());
    }

    @Test
    void testGetSuit() {
        Card card = new Card("Heart", "King");
        assertEquals("Heart", card.getSuit());
    }

    @Test
    void testGetRank() {
        Card card = new Card("Diamond", "7");
        assertEquals("7", card.getRank());
    }

    @Test
    void testToString() {
        Card card = new Card("Club", "Jack");
        assertEquals("Jack of Club", card.toString());
    }
}
