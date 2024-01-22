package jp.ac.uryukyu.ie.e235724;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        ArrayList<String> actions = new ArrayList<>();
        actions.add("hit");
        actions.add("stand");

        deck.initializeDeck();
        deck.shuffle();

        // ゲーム開始時に2枚ずつカードを配る
        for (int i = 0; i < 2; i++) {
            playerHand.addCard(deck.drawCard());
            dealerHand.addCard(deck.drawCard());
        }

        // 初回の表示
        System.out.println("Your card : ");
        playerHand.display();
        System.out.println("Dealer card : ");
        dealerHand.display(); 

        System.out.println("Your score : " + playerHand.calculateScore());
        System.out.println("Dealer score : " + dealerHand.calculateScore());

        // ゲームループ
        CommandSelector commandSelector = new CommandSelector();
        for(var action : actions) {
            commandSelector.addCommand(action);
    }
        while (playerHand.calculateScore() < 21) {
            int commandNumber = commandSelector.waitForUsersCommand("Which do you choose?");

            if (commandNumber == 0) {
                // プレイヤーがヒットを選択
                playerHand.addCard(deck.drawCard());
                System.out.println("Your card : ");
                playerHand.display();
                System.out.println("Your score : " + playerHand.calculateScore());
            } else if (commandNumber == 1) {
                // プレイヤーがスタンドを選択
                while (dealerHand.calculateScore() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }
                break;
            }
        }

        // 最終結果を表示
        System.out.println("Game Result !!");
        System.out.println("Your score : " + playerHand.calculateScore());
        System.out.println("Dealer score : " + dealerHand.calculateScore());
        
        BlackJackGame result = new BlackJackGame();
        System.out.println(result.determineWinner(playerHand, dealerHand));
    }
}
