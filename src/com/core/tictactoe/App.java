package com.core.tictactoe;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        CommandLineUI commandLineUI = new CommandLineUI(System.out, System.in);
        GamesController gamesController  = new GamesController(commandLineUI);
        gamesController.gamesMenu();
    }
}