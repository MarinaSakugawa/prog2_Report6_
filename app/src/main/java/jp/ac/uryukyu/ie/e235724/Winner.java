package jp.ac.uryukyu.ie.e235724;

/**
 * ゲームの勝者判定をする．
 */

public class Winner {

    /**
     * 勝者判定をする．
     * プレイヤーとディーラーの手札から得られるスコアを比較して，ゲームの結果を返す．
     * 
     * @param playerHand プレイヤーの手札
     * @param dealerHand ディーラーの手札
     * @return 勝者判定による結果の文字列
     * 　　　　　- "Black Jack!! You win!!"：プレイヤーのスコアが21でブラックジャックを達成し，プレイヤーの勝利
     * 　　　　　- "You win!!"：プレイヤーの勝利
     *         - "This game is draw..."：引き分け
     *         - "Dealer wins!!"：ディーラーの勝利．
     *         - "You burst! Dealer wins!!"：プレイヤーがバーストして，ディーラーの勝利．
     */
    public String determineWinner(Hand playerHand, Hand dealerHand) {
        int playerScore = playerHand.calculateScore();
        int dealerScore = dealerHand.calculateScore();

        if(playerScore <= 21) {
            if(playerScore == 21 && dealerScore != 21) {
                return "Black Jack!! You win!!";
            } else if(dealerScore > 21 || playerScore > dealerScore) {
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
