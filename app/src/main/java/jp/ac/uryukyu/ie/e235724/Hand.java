package jp.ac.uryukyu.ie.e235724;

import java.util.ArrayList;

/**
 * ブラックジャックのプレイヤーまたはディーラーの手札を表すクラス．
 */
public class Hand {

    /**
     * 手札に含まれるカードのリスト．
     */
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * Hand クラスのコンストラクタ．
     */
    Hand() {

    }
    
    /**
     * 手札のカードリストを取得．
     * 
     * @return カードのリスト
     */
    ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * 手札にカードを追加する．
     * 
     * @param card 追加するカード
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * 手札のカードを表示する．
     */
    public void display() {
        for(var card : getCards()) {
            System.out.println(card.toString());
        }
    }

    /**
     * 手札のカードによる合計スコアを計算する．
     * 
     * @return 手札カードの合計スコア
     */
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
