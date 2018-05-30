package com.core.tictactoe;

public class GamesController {

    public CommandLineUI commandLineUI;

    GamesController(){}

    GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
    }

    protected void gamesMenu() {
        boolean loopThroughOptions = true;
        while (loopThroughOptions) {
            this.commandLineUI.gamingMenu();
            loopThroughOptions = this.actOnOption(this.getUserOption());
        }
    }

    protected String getUserOption() {
        return this.commandLineUI.getUserInput();
    }

    protected boolean actOnOption(String pickedOption) {
        if (pickedOption.matches("[1]")) {
            this.playANewGame();
        } else if (pickedOption.matches("[2]")) {
            return false;
        }
        return true;
    }

    protected void playANewGame() {
        Game newGame = new Game(this.commandLineUI);
        newGame.run();
    }

}
