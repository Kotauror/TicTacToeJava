package com.core.tictactoe;

public class App {

    public static void main(String[] args) {
        CommandLineUi commandLineUi = new CommandLineUi(System.out, System.in);
        GamesController gamesController  = new GamesController(commandLineUi);
        gamesController.run();
    }
}