package com.example.tictactoe;

public class GamesController {

    public void gamesMenu() {
        boolean loopThroughOptions = true;
        while (loopThroughOptions) {
            String pickedOption = this.getUserOption();
            loopThroughOptions = this.actOnOption(pickedOption);
        }
    }

    public String getUserOption() {
        Displayer.gamingMenu();
        return IOHelper.getUserInput();
    }

    public boolean actOnOption(String pickedOption) {
        if (Validator.playAgainValid(pickedOption)) {
            this.playANewGame();
            return true;
        } else if (Validator.exitValid(pickedOption)) {
            return false;
        } else {
            return true;
        }
    }

    public void playANewGame() {
        Game newGame = new Game();
        newGame.playOneGame();
    }

}
