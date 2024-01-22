package jp.ac.uryukyu.ie.e235724;

public class Main {
    private final Deck deck;
    private final Hand playerHand;
    private final Hand dealerHand;

    public Main() {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
    }

    public static void main(String[] args) {
        Main blackjackGame = new Main();
        blackjackGame.play();
    }

    private void initializeGame() {
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

    private void playGame() {
        // ゲームループ
        CommandSelector commandSelector = new CommandSelector();
        commandSelector.addCommand("hit");
        commandSelector.addCommand("stand");

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
    }

    private void displayResult() {
        // 最終結果を表示
        System.out.println("Game Result !!");
        System.out.println("Your score : " + playerHand.calculateScore());
        System.out.println("Dealer score : " + dealerHand.calculateScore());

        BlackJackGame result = new BlackJackGame();
        System.out.println(result.determineWinner(playerHand, dealerHand));
    }

    private void play() {
        initializeGame();
        playGame();
        displayResult();
    }
}
