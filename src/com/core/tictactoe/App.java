package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOptionsFactory;

public class App {

    public static void main(String[] args) {
        CommandLineUi commandLineUi = new CommandLineUi(System.out, System.in);
        GameOptionsFactory gameOptionsFactory = new GameOptionsFactory(commandLineUi);
        GamesController gamesController  = new GamesController(commandLineUi, gameOptionsFactory);
        gamesController.run();
    }
}