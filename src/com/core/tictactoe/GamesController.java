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

    protected GameOption getUserOption() {
        this.commandLineUI.gamingMenu();
        String userInput = this.commandLineUI.getUserInput();
        switch (userInput) {
            case HUMAN_VS_HUMAN:
                return new RunGameOption();
            case EXIT:
                return new ExitGameOption();
            default:
                return new NoOption();
        }
    }
}
