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

    public void informOfMove(Player player, int move) {
        output.print(player.getType());
        output.println(" " + player.getSign() + " picked position: " + move);
    }

    public String mainMenu() {
        String[] validGamesTypes = {"1", "2", "E", "e"};
        String[] validGameOrders = {"c", "C", "h", "H"};

        String gameModeString = getUserOption(validGamesTypes, UserPrompts.getGameModePrompt());
        String orderString = "";
        if (gameModeString.equals(GameMode.PLAY_WITH_COMPUTER.value())) {
            orderString = getUserOption(validGameOrders, UserPrompts.getGameOrderPrompt());
        }
        return gameModeString + orderString;
    }

    public String getUserOption(String[] validOptions, String infoForUser) {
        while (true) {
            this.printMessage(infoForUser);
            String input = this.getUserInput();
            if (Arrays.asList(validOptions).contains(input)) return input.toUpperCase();
        }
    }

    public String getUserInput() {
        return input.nextLine();
    }

    private void printMessage(String message) {
        output.println(message);
    }
}
