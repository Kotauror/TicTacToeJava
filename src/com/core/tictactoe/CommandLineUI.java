package com.core.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineUI {

    private final PrintStream output;

    CommandLineUI(PrintStream output){
        this.output = output;
    }

    protected void showBoard(Board board) {
        System.out.println();
        System.out.println(board.places.get(0) + " | " + board.places.get(1) + " | " + board.places.get(2));
        System.out.println(board.places.get(3) + " | " + board.places.get(4) + " | " + board.places.get(5));
        System.out.println(board.places.get(6) + " | " + board.places.get(7) + " | " + board.places.get(8));
        System.out.println();
    }

    protected void greetUsers(){
        System.out.println("Hello and welcome to Tic-Tac-Toe");
    }

    protected void askForPosition(Player player) {
        System.out.println(player.sign + ", pick a position");
    }

    protected void announceWinner(Board board) {
        System.out.println(board.winnerSign() != "none" ? board.winnerSign() + " won!" : "It's a tie!");
    }

    protected void gamingMenu() {
        System.out.println("If you want to play type 1, if you want to exit type 2");
    }

    protected String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userString = scanner.nextLine();
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
