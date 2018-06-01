package com.core.tictactoe;

public class App {

    public static void main(String[] args) {
        CommandLineUI commandLineUI = new CommandLineUI(System.out, System.in);
        GamesController gamesController  = new GamesController(commandLineUI);
        gamesController.run();
    }
}