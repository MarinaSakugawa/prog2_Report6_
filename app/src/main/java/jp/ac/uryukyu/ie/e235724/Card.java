package jp.ac.uryukyu.ie.e235724;

/**
 * カードを表すクラス．
 */
public class Card {

    /**
     * カードのスート（マーク）を表す文字列．
     */
    private String suit;

    /**
     * カードのランク（数字または絵柄）を表す文字列．
     */
    private String rank;

    /**
     * Card クラスのコンストラクタ．
     * 
     * @param suit カードのスート
     * @param rank カードのランク
     */
    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * カードのスートを取得．
     * 
     * @return カードのスート
     */
    String getSuit() {
        return suit;
    }

    /**
     * カードのランクを取得．
     * 
     * @return カードのランク
     */
    String getRank() {
        return rank;
    }

    /**
     * カードのスートとランクの文字列を一緒に返す．
     * 
     * @return カードの文字列
     */
    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
}
