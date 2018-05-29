package com.core.tictactoe;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
       // Displayer displayer = new Displayer();
       // Validator validator = new Validator();
       //  IOHelper ioHelper = new IOHelper();
        CommandLineUI commandLineUI = new CommandLineUI();
        GamesController gamesController  = new GamesController(commandLineUI);
        gamesController.gamesMenu();
    }
}