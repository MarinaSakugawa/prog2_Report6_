package jp.ac.uryukyu.ie.e235724;

/*
 * ブラックジャックゲームの実装．
 * 
 * ゲームの勝者判定をする．
 */

public class BlackJackGame {

    /*
     * 勝利判定を行う．
     * プレイヤーとディーラーの手札のスコアを比較して、ゲームの結果を返す．
     *
     * @param playerHand プレイヤーの手札
     * @param dealerHand ディーラーの手札
     * @return 勝者判定に基づく結果の文字列
     *         - "You win!!": プレイヤーの勝利
     *         - "This game is draw...": 引き分け
     *         - "Dealer wins!!": ディーラーの勝利
     *         - "You burst! Dealer wins!!": プレイヤーがバーストした場合のディーラーの勝利
     */
    public String determineWinner(Hand playerHand, Hand dealerHand) {
        int playerScore = playerHand.calculateScore();
        int dealerScore = dealerHand.calculateScore();

        if(playerScore <= 21) {
            if(dealerScore > 21 || playerScore > dealerScore) {
                return "You win!!";
            } else if(playerScore == dealerScore) {
                return "This game is draw...";
            } else {
                return "Dealer wins!!";
            }
        } else {
            return "You burst! Dealer wins!!";
        }
    }
    
}
