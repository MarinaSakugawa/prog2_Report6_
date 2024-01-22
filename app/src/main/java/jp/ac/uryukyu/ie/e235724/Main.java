package jp.ac.uryukyu.ie.e235724;

import java.util.ArrayList;
import java.util.Scanner;

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

        CommandSelector commandSelector = new CommandSelector();
            for(var action : actions) {
                commandSelector.addCommand(action);
            }

        while(true) {
            int commandNumber = commandSelector.waitForUsersCommand("Which do you choose?");
            
            if(commandNumber == 0) {
                playerHand.addCard(deck.drawCard());
                playerHand.display();
                System.out.println("Your score : " + playerHand.calculateScore());
            } else if(commandNumber == 1) {
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
