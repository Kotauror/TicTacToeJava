package com.core.tictactoe;

public class GamesController {

    CommandLineUI commandLineUI;
    Game game;

    private static final String HUMAN_VS_HUMAN = "1";
    private static final String EXIT = "2";

    GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
        this.game = null;
    }

    void run() {
        boolean exitGame = false;
        while (!exitGame) {
            String userOption = this.getUserOption();
            if (userOption.equals(HUMAN_VS_HUMAN)) {
                this.playANewGame();
            } else if (userOption.equals(EXIT))
                exitGame = true;
        }
    }

    private String getUserOption() {
        this.commandLineUI.gamingMenu();
        return this.commandLineUI.getUserInput();
    }

    private void playANewGame() {
        this.game = new Game(this.commandLineUI, new Board());
        this.game.run();
    }
}
