package com.core.tictactoe;

public class GamesController implements GamesTypes {

    CommandLineUI commandLineUI;
    Game game;

    GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
        this.game = null;
    }

    void gamesMenu() {
        boolean loopThroughOptions = true;
        while (loopThroughOptions) {
            this.commandLineUI.gamingMenu();
            loopThroughOptions = this.actOnOption(this.getUserOption());
        }
    }

    private String getUserOption() {
        return this.commandLineUI.getUserInput();
    }

    private boolean actOnOption(String pickedOption) {
        if (pickedOption.equals(HUMAN_VS_HUMAN)) {
            this.playANewGame();
        } else return !(pickedOption.equals(EXIT));
        return true;
    }

    private void playANewGame() {
        Game newGame = new Game(this.commandLineUI);
        this.game = newGame;
        newGame.run();
    }

}
