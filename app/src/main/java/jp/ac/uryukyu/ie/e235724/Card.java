package jp.ac.uryukyu.ie.e235724;

public class Card {
    private String suit;
    private String rank;

    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    String getSuit() {
        return suit;
    }

    String getRank() {
        return rank;
    }

    public String toString() {
        return getRank() + " of " + getSuit();
    }
}
