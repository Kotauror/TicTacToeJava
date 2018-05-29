package com.core.tictactoe;

public class GamesController {

    public CommandLineUI commandLineUI;
    // public IOHelper iohelper;
    // public Validator validator;

    GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
        // this.iohelper = iohelper;
        // this.validator = validator;
    }

    protected void gamesMenu() {
        boolean loopThroughOptions = true;
        while (loopThroughOptions) {
            String pickedOption = this.getUserOption();
            loopThroughOptions = this.actOnOption(pickedOption);
        }
    }

    protected String getUserOption() {
        this.commandLineUI.gamingMenu();
        return this.commandLineUI.getUserInput();
    }

    protected boolean actOnOption(String pickedOption) {
        if (this.commandLineUI.playAgainValid(pickedOption)) {
            this.playANewGame();
            return true;
        } else if (this.commandLineUI.exitValid(pickedOption)) {
            return false;
        } else {
            return true;
        }
    }

    protected void playANewGame() {
        Game newGame = new Game(this.commandLineUI);
        newGame.run();
    }

}
