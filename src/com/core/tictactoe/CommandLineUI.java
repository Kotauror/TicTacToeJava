package com.core.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineUI {

    PrintStream output;
    Scanner input;
    // Collections.addAll(this.numbers, array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);

    CommandLineUI(){}

    CommandLineUI(PrintStream output, InputStream input){
        this.output = output;
        this.input = new Scanner(input);
    }

    protected void showBoard(Board board) {
        output.println();
        output.println(board.places.get(0) + " | " + board.places.get(1) + " | " + board.places.get(2));
        output.println(board.places.get(3) + " | " + board.places.get(4) + " | " + board.places.get(5));
        output.println(board.places.get(6) + " | " + board.places.get(7) + " | " + board.places.get(8));
        output.println();
    }

    protected void greetUsers(){
        output.println("Hello and welcome to Tic-Tac-Toe");
    }

    protected void askForPosition(Player player) {
        output.println(player.sign + ", pick a position");
    }

    protected void announceWinner(Board board) {
        output.println(board.winnerSign() != "none" ? board.winnerSign() + " won!" : "It's a tie!");
    }

    protected void gamingMenu() {
        output.println("If you want to play type 1, if you want to exit type 2");
    }

    protected String getUserInput() {
//        Scanner scanner = new Scanner(System.in);
        String userString = input.nextLine();
        return userString;
    }

    protected boolean isNumeric(String position) {
        String regex = "[0-8]";
        return position.matches(regex) ? true : false;
    }

    protected int getPosition(Board board, Player player) {
        while (true) {
           this.askForPosition(player);
           String position = this.getUserInput();
            if (this.isNumeric(position) && board.isNonTaken(position)) {
                return Integer.parseInt(position);
            }
        }
    }

}
