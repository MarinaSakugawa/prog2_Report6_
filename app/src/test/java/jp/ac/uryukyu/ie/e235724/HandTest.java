package jp.ac.uryukyu.ie.e235724;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class HandTest {
    @Test
    void testAddCard() {
        Hand hand = new Hand();
        Card card = new Card("Spade", "Ace");

        hand.addCard(card);

        ArrayList<Card> cards = hand.getCards();
        assertTrue(cards.contains(card));
    }

    @Test
    void testCalculateScore() {
        Hand hand = new Hand();

        // カードの追加とスコア計算の確認
        hand.addCard(new Card("Spade", "2"));
        hand.addCard(new Card("Club", "King"));
        assertEquals(12, hand.calculateScore());

        // エースがある場合、適切に1として計算されるか確認
        hand.addCard(new Card("Heart", "Ace"));
        assertEquals(13, hand.calculateScore());

    }
}