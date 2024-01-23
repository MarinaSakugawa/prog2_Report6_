package jp.ac.uryukyu.ie.e235724;

/**
 * ブラックジャックゲームを実際に動かすクラス．．
 */
public class Main {

    /**
     * ブラックジャックゲームを行う．
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        BlackJackGame.startGame(deck, playerHand, dealerHand);
    }
}
