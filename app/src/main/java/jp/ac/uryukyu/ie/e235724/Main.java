package jp.ac.uryukyu.ie.e235724;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        deck.initializeDeck();
        deck.shuffle();

        for(int i = 0; i < 2; i++) {
            playerHand.addCard(deck.drawCard());
            System.out.println("Your card : ");
            playerHand.display();
            dealerHand.addCard(deck.drawCard());
            System.out.println("Dealer card : ");
            dealerHand.display();
        }

        System.out.println("Your score : " + playerHand.calculateScore());
        System.out.println("Dealer score : " + dealerHand.calculateScore());

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("hit or stand?");
            String choice = scanner.nextLine().toLowerCase();

            if("hit".equals(choice)) {
                playerHand.addCard(deck.drawCard());
                playerHand.display();
                System.out.println("Your score : " + playerHand.calculateScore());
            } else if("stand".equals(choice)) {
                while (dealerHand.calculateScore() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }
                break;
            }
        }

        System.out.println("Game Result !!");
        System.out.println("Your score : " + playerHand.calculateScore());
        System.out.println("Dealer score : " + dealerHand.calculateScore());

        BlackJackGame result = new BlackJackGame();
        System.out.println(result.determineWinner(playerHand, dealerHand));

    }
    
}
