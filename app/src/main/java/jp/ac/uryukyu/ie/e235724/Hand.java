package jp.ac.uryukyu.ie.e235724;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    Hand() {

    }
    
    ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void display() {
        for(Card card : cards) {
            System.out.println(toString());
        }
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for(Card card :cards) {
            if("Ace".equals(card.getRank())) {
                score += 11;
                numAces ++;
            } else if("Jack".equals(card.getRank()) || "Queen".equals(card.getRank()) || "King".equals(card.getRank())) {
                score += 10;
            } else {
                score += Integer.parseInt(card.getRank());
            }
        }

        if(score > 21 && numAces > 0) {
            score -= 10;
            numAces --;
        }

        return score;
    }
}
