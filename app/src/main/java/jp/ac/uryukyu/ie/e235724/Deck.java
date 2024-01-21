package jp.ac.uryukyu.ie.e235724;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    ArrayList<Card> getCards() {
        return cards;
    }

    Deck() {

    }

    public void initializeDeck() {
        String[] suits = {"Spade", "Club", "Heart", "Diamond"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for(String suit : suits) {
            for(String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if(cards.isEmpty()) {
            throw new IllegalStateException("Deck is Empty");
        }
        return cards.remove(0);
    }
}
