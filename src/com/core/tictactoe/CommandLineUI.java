package com.core.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineUI {

    PrintStream output;
    Scanner input;

    public CommandLineUI(){}

    public CommandLineUI(PrintStream output, InputStream input){
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

    void askForPosition(Player player) {
        output.println(player.getSign() + ", pick a position");
    }

    void announceWinner(Board board) {
        output.println(!board.winnerSign().equals("none") ? board.winnerSign() + " won!" : "It's a tie!");
    }

    void gamingMenu() {
        output.println("If you want to play type 1, if you want to exit type 2");
    }

    String getUserInput() {
        return input.nextLine();
    }

    int getPosition(Board board, Player player) {
        while (true) {
           this.askForPosition(player);
           String position = this.getUserInput();
            if (this.isNumeric(position) && board.isNonTaken(position)) {
                return Integer.parseInt(position);
            }
        }
    }

    private boolean isNumeric(String position) {
        String regex = "[1-9]";
        return position.matches(regex);
    }
}
