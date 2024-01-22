package jp.ac.uryukyu.ie.e235724;

import java.util.ArrayList;
import java.util.Collections;

/**
 * トランプのデッキを表すクラス．
 */
public class Deck {

    /**
     * デッキに含まれるカードのリスト．
     */
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * デッキのカードを取得．
     * 
     * @return カードのリスト
     */
    ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * デッキのコンストラク．
     */
    Deck() {

    }

    /**
     * デッキの初期化を行う．
     * 全てのスートとランクのカード（計52枚分）作成し，デッキに追加する．
     */
    public void initializeDeck() {
        String[] suits = {"Spade", "Club", "Heart", "Diamond"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for(String suit : suits) {
            for(String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * デッキのカードをシャッフルする．
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * デッキからカードを一枚引く．
     * @return 引かれたカード
     * @throws IllegalStateException デッキが空の場合
     */
    public Card drawCard() {
        if(cards.isEmpty()) {
            throw new IllegalStateException("Deck is Empty");
        }
        return cards.remove(0);
    }
}
