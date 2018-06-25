package com.core.tictactoe;

import com.core.tictactoe.game_options.GameMode;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
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

    public void showBoard(Board board) {
        String[][] rowsInBoard = board.getRowsInBoard();
        for (String[] row : rowsInBoard) {
            for (int i = 0; i < row.length; i++) {
                output.print(row[i]);
                if (!row[i].equals("X") && !row[i].equals("O") && Integer.parseInt(row[i]) < 10 ) output.print(" ");
                if (row[i].equals("X") || row[i].equals("O")) output.print(" ");
                if (i != row.length - 1) output.print(" | ");
            }
            output.println();
        }
        output.println();
    }

    public void greetUsers(){
        output.println("Hello and welcome to Tic-Tac-Toe");
    }

    public void askForPosition(String playerSign) {
        output.println(playerSign + ", pick a position");
    }

    public void announceWinner(Board board) {
        output.println(!board.winnerSign().equals("none") ? board.winnerSign() + " won!" : "It's a tie!");
    }

    public String mainMenu() {
        String gameModeString = typeOfGameMenu();
        String orderString = orderMenu(gameModeString);
        return gameModeString + orderString;
    }

    public void informOfMove(Player player, int move) {
        output.print(player.getType());
        output.println(" " + player.getSign() + " picked position: " + move);
    }

    public String getUserInput() {
        return input.nextLine();
    }

    public int getPositionFromUser(Board board, String playerSign) {
        while (true) {
            this.askForPosition(playerSign);
            String position = this.getUserInput();
            if (validateInput(position, board.getFreePlaces())) return Integer.parseInt(position);
        }
    }

    public int getBoardSize() {
        String[] validBoardSizes = {"1", "2", "3", "4", "5", "6", "7", "8"};
        while(true) {
            this.showBoardSizeOptions();
            String size = this.getUserInput();
            if (validateInput(size, validBoardSizes)) return Integer.parseInt(size);
        }
    }

    private String typeOfGameMenu() {
        String[] validGamesTypes = {"1", "2", "E", "e"};
        while(true) {
            this.showGameModeMenu();
            String mode = this.getUserInput();
            if (validateInput(mode, validGamesTypes)) return mode.toUpperCase();
        }
    }

    private String orderMenu(String typeOfGame) {
        if (!typeOfGame.equals(GameMode.PLAY_WITH_COMPUTER.value())) return "";
        String[] validGameOrders = {"c", "C", "h", "H"};
        while (true) {
            this.showOrderMenu();
            String order = this.getUserInput();
            if (validateInput(order, validGameOrders)) return order.toUpperCase();
        }
    }

    private boolean validateInput(String input, String[] matchingElements) {
        return Arrays.asList(matchingElements).contains(input);
    }

    private void showOrderMenu() {
        output.println("~~~~ Pick who goes first ~~~~");
        output.println("> type H if you want the Human to start");
        output.println("> type C if you want the Computer to start");
    }

    private void showGameModeMenu() {
        output.println("~~~~ Select the type of game ~~~~");
        output.println("> type 1 for a Human vs Human game");
        output.println("> type 2 to play with Computer");
        output.println("> type E to Exit");
    }

    private void showBoardSizeOptions() {
        output.println("~~~~ Select the size of board ~~~~");
        output.println("> Type a number from 2 to 8 to define the size of board ");
        output.println("> eg. enter 3 for 3x3, enter 4 for 4x4");
    }
}
