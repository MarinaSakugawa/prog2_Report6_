package jp.ac.uryukyu.ie.e235724;

public class BlackJackGame {

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
