package com.core.tictactoe;

public class GamesController {

    CommandLineUI commandLineUI;
//    Game game;

    private static final String HUMAN_VS_HUMAN = "1";
    private static final String EXIT = "2";

    GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
//        this.game = null;
    }

    void run() {
        while (true) {
            GameOption userOption = this.getUserOption();
            userOption.run();
        }
    }

    private GameOption getUserOption() {
        this.commandLineUI.gamingMenu();
        String userInput = this.commandLineUI.getUserInput();
        if (userInput.equals(HUMAN_VS_HUMAN)) {
            return new RunGameOption();
        } else if (userInput.equals(EXIT)) {
            return new ExitGameOption();
        } else {
            return new NoOption();
        }
    }
}
