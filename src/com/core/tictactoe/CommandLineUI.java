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

    protected void showBoard(Board board) {
        output.println();
        output.println(board.valueAtPosition(0) + " | " + board.valueAtPosition(1) + " | " + board.valueAtPosition(2));
        output.println(board.valueAtPosition(3) + " | " + board.valueAtPosition(4) + " | " + board.valueAtPosition(5));
        output.println(board.valueAtPosition(6) + " | " + board.valueAtPosition(7) + " | " + board.valueAtPosition(8));
        output.println();
    }

    protected void greetUsers(){
        output.println("Hello and welcome to Tic-Tac-Toe");
    }

    protected void askForPosition(Player player) {
        output.println(player.getSign() + ", pick a position");
    }

    protected void announceWinner(Board board) {
        output.println(!board.winnerSign().equals("none") ? board.winnerSign() + " won!" : "It's a tie!");
    }

    protected void gamingMenu() {
        output.println("If you want to play type 1, if you want to exit type 2");
    }

    protected String getUserInput() {
        return input.nextLine();
    }

    private boolean isNumeric(String position) {
        String regex = "[0-8]";
        return position.matches(regex);
    }

    public void noSuchOption() {
        output.println("There is no such option");
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
}
