package com.core.tictactoe;

public class GamesController {

    public CommandLineUI commandLineUI;
    public Game game;

    GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
        this.game = null;
    }

    protected void gamesMenu() {
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
        if (pickedOption.matches("[1]")) {
            this.playANewGame();
        } else if (pickedOption.matches("[2]")) {
            return false;
        }
        return true;
    }

    private void playANewGame() {
        Game newGame = new Game(this.commandLineUI);
        this.game = newGame;
        newGame.run();
    }

}
