package jp.ac.uryukyu.ie.e235724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * ユーザーのコマンドを選択するためのクラス．
 */
public class CommandSelector {

    /**
     * 選択可能なコマンドのリスト．
     */
    private ArrayList<String> commands;

    /**
     * CommandSelector クラスのコンストラクタ．
     */
    public CommandSelector() {
        commands = new ArrayList<>();
    }

    /**
     * 選択可能なコマンドを追加する．
     * 
     * @param command 追加するコマンド
     */
    public void addCommand(String command) {
        commands.add(command);
    }

    /**
     * ユーザーからのコマンドを待つ．
     * 
     * @param prompt ユーザーに表示するプロンプト
     * @return 選択されたコマンドの番号
     */
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

    /**
     * 選択可能なコマンドを表示．
     */
    private void displayCommands() {
        System.out.println("Available commands:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + ". " + commands.get(i));
        }
    }
}

