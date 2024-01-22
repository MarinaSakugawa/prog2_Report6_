package jp.ac.uryukyu.ie.e235724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandSelector {
    private ArrayList<String> commands;

    public CommandSelector() {
        commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public int waitForUsersCommand(String prompt) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println(prompt);
                displayCommands();

                // 標準入力からの入力がない場合は待機
                while (!reader.ready()) {
                    try {
                        Thread.sleep(100);  // 少し待機して再試行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String userInput = reader.readLine();

                try {
                    int commandNumber = Integer.parseInt(userInput);
                    if (commandNumber >= 0 && commandNumber < commands.size()) {
                        return commandNumber;
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayCommands() {
        System.out.println("Available commands:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + ". " + commands.get(i));
        }
    }
}

