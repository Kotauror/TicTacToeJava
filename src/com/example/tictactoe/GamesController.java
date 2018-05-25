package com.example.tictactoe;

public class GamesController {

    public Displayer displayer;
    public IOHelper iohelper;
    public Validator validator;

    GamesController(Displayer displayer, Validator validator, IOHelper iohelper) {
        this.displayer = displayer;
        this.iohelper = iohelper;
        this.validator = validator;
    }

    protected void gamesMenu() {
        boolean loopThroughOptions = true;
        while (loopThroughOptions) {
            String pickedOption = this.getUserOption();
            loopThroughOptions = this.actOnOption(pickedOption);
        }
    }

    protected String getUserOption() {
        this.displayer.gamingMenu();
        return this.iohelper.getUserInput();
    }

    protected boolean actOnOption(String pickedOption) {
        if (this.validator.playAgainValid(pickedOption)) {
            this.playANewGame();
            return true;
        } else if (this.validator.exitValid(pickedOption)) {
            return false;
        } else {
            return true;
        }
    }

    protected void playANewGame() {
        Game newGame = new Game(this.displayer, this.iohelper, this.validator);
        newGame.run();
    }

}
