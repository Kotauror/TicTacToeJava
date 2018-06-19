package com.core.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineUi {

    PrintStream output;
    Scanner input;

    public CommandLineUi(){}

    public CommandLineUi(PrintStream output, InputStream input){
        this.output = output;
        this.input = new Scanner(input);
    }

    public void noSuchOption() {
        output.println("There is no such option");
    }

    void showBoard(Board board) {
        output.println();
        output.println(board.valueAtIndex(0) + " | " + board.valueAtIndex(1) + " | " + board.valueAtIndex(2));
        output.println(board.valueAtIndex(3) + " | " + board.valueAtIndex(4) + " | " + board.valueAtIndex(5));
        output.println(board.valueAtIndex(6) + " | " + board.valueAtIndex(7) + " | " + board.valueAtIndex(8));
        output.println();
    }

    void greetUsers(){
        output.println("Hello and welcome to Tic-Tac-Toe");
    }

    void askForPosition(String playerSign) {
        output.println(playerSign + ", pick a position");
    }

    void announceWinner(Board board) {
        output.println(!board.winnerSign().equals("none") ? board.winnerSign() + " won!" : "It's a tie!");
    }

    String twoLevelMenu() {
        while (true) {
            this.showFirstLevelMenu();
            String userInputInFirstMenu = this.getUserInput();
            if (inputIsValidInFirstMenu(userInputInFirstMenu)) {
                if (userInputInFirstMenu.equals("2")) {
                    return secondLevelMenu();
                } else {
                    return userInputInFirstMenu;
                }
            }
        }
    }

    String secondLevelMenu() {
        while (true) {
            this.showSecondLevelMenu();
            String userInputInSecondMenu = this.getUserInput();
            if (inputIsValidInSecondMenu(userInputInSecondMenu)) {
                return userInputInSecondMenu;
            }
        }
    }

    void informOfMove(Player player, int move) {
        output.print(player instanceof ComputerPlayer ? "Computer " : "Player ");
        output.println(player.getSign() + " picked position: " + move);
    }

    String getUserInput() {
        return input.nextLine();
    }

    int getPositionFromUser(Board board, String playerSign) {
        while (true) {
           this.askForPosition(playerSign);
           String position = this.getUserInput();
            if (this.isNumeric(position) && board.isNonTaken(position)) {
                return Integer.parseInt(position);
            }
        }
    }

    private void showSecondLevelMenu() {
        output.println("~~~~ Pick who goes first ~~~~");
        output.println("> type H if you want the Human to start");
        output.println("> type C if you want the Computer to start");
    }

    private void showFirstLevelMenu() {
        output.println("~~~~ Select the type of game ~~~~");
        output.println("> type 1 for a Human vs Human game");
        output.println("> type 2 to play with unbeatable Computer");
        output.println("> type E to Exit");
    }

    private boolean isNumeric(String position) {
        String regex = "[1-9]";
        return position.matches(regex);
    }

    private boolean inputIsValidInFirstMenu(String input) {
        String regex = "[1, 2, E]";
        return input.matches(regex);
    }

    private boolean inputIsValidInSecondMenu(String input) {
        String regex = "[C, H]";
        return input.matches(regex);
    }
}
