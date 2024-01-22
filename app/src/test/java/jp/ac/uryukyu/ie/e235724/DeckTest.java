package jp.ac.uryukyu.ie.e235724;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;;

public class DeckTest {

    @Test
    void testInitializeDeck() {
        Deck deck = new Deck();
        deck.initializeDeck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    void testShuffle() {
        Deck deck = new Deck();
        deck.initializeDeck();

        // シャッフル前とシャッフル後で順序が変わっていることを確認
        ArrayList<Card> originalOrder = new ArrayList<>(deck.getCards());
        
        deck.shuffle();

        assertNotEquals(originalOrder, deck.getCards());
    }

    @Test
    void testDrawCard() {
        Deck deck = new Deck();
        deck.initializeDeck();

        int initialSize = deck.getCards().size();
        Card drawnCard = deck.drawCard();

        assertEquals(initialSize - 1, deck.getCards().size());
        assertNotNull(drawnCard);
    }

    @Test
    void testDrawCardFromEmptyDeck() {
        Deck deck = new Deck();

        // 空のデッキからカードを引くと例外が発生することを確認
        assertThrows(IllegalStateException.class, () -> {
            deck.drawCard();
        });
    }
}

