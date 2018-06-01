package com.core.tictactoe;

public class GamesController implements GamesTypes {

    CommandLineUI commandLineUI;
    Game game;

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
        Game newGame = new Game(this.commandLineUI, new Board());
        this.game = newGame;
        newGame.run();
    }
}
