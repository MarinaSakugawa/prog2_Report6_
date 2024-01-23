package jp.ac.uryukyu.ie.e235724;

import java.util.ArrayList;

/**
 * ゲームの進行や結果表示を管理するクラス．
 */
public class BlackJackGame {

    /**
     * ゲームの初期化および実行を行う．
     * 
     * @param deck        初期化するデッキ
     * @param playerHand  プレイヤーの手札
     * @param dealerHand  ディーラーの手札
     */
    public static void startGame(Deck deck, Hand playerHand, Hand dealerHand) {
        initializeGame(deck, playerHand, dealerHand);
        playGame(deck, playerHand, dealerHand);
        displayResult(playerHand, dealerHand);
    }

    /**
     * ゲームの初期化を行う．
     * デッキの初期化，シャッフル，プレイヤーとディーラーの初期手札配布を行う．
     * 初回のカード表示とスコア表示も行われる．
     * 
     * @param deck        初期化するデッキ
     * @param playerHand  プレイヤーの手札
     * @param dealerHand  ディーラーの手札
     */
    private static void initializeGame(Deck deck, Hand playerHand, Hand dealerHand) {
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
    }

    /**
     * ゲームの実行を行う．
     * プレイヤーが hit または stand を選択し，ディーラーがカードを引く．
     * 
     * @param deck        ゲームで使用するデッキ
     * @param playerHand  プレイヤーの手札
     * @param dealerHand  ディーラーの手札
     */
    private static void playGame(Deck deck, Hand playerHand, Hand dealerHand) {
        // ゲームループ
        ArrayList<String> actions = new ArrayList<>();
        actions.add("hit");
        actions.add("stand");
        CommandSelector commandSelector = new CommandSelector();
        for (var action : actions) {
            commandSelector.addCommand(action);
        }
        while (playerHand.calculateScore() < 21) {
            int commandNumber = commandSelector.waitForUsersCommand("Which do you choose?");

            if (commandNumber == 0) {
                // プレイヤーがhitを選択
                playerHand.addCard(deck.drawCard());
                System.out.println("Your card : ");
                playerHand.display();
                System.out.println("Your score : " + playerHand.calculateScore());
                if(dealerHand.calculateScore() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }
            } else if (commandNumber == 1) {
                // プレイヤーがstandを選択
                while (dealerHand.calculateScore() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }
                break;
            }
        }
    }

    /**
     * ゲームの結果を表示．
     * 最終結果と勝者の表示を行う．
     * 
     * @param playerHand  プレイヤーの手札
     * @param dealerHand  ディーラーの手札
     */
    private static void displayResult(Hand playerHand, Hand dealerHand) {
        // 最終結果を表示
        System.out.println("Game Result !!");
        System.out.println("Your score : " + playerHand.calculateScore());
        System.out.println("Dealer score : " + dealerHand.calculateScore());

        Winner result = new Winner();
        System.out.println(result.determineWinner(playerHand, dealerHand));
    }

}
