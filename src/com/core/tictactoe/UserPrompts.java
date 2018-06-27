package com.core.tictactoe;

public abstract class UserPrompts {

    public static String getBoardSizePrompt() {
        return "~~~~ Select the size of board ~~~~\n> Type a number from 2 to 8 to define the size of board \n> eg. enter 3 for 3x3, enter 4 for 4x4";
    }

    public static String getGameModePrompt() {
        return "~~~~ Select the type of game ~~~~\n> type 1 for a Human vs Human game\n> type 2 to play with Computer\n> type E to Exit";
    }

    public static String getGameOrderPrompt() {
        return "~~~~ Pick who goes first ~~~~\n> type H if you want the Human to start\n> type C if you want the COmputer to start";
    }
}
