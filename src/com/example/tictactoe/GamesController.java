package com.example.tictactoe;

import java.util.Scanner;

public class GamesController {

    public Displayer displayer;

    GamesController(Displayer displayer) {
        this.displayer = displayer;
    }

    public void gamesMenu() {
        boolean loopThroughOptions = true;
        while (loopThroughOptions) {
            String pickedOption = this.getUserOption();
            loopThroughOptions = this.actOnOption(pickedOption);
        }
    }

    public String getUserOption() {
        this.displayer.gamingMenu();
        Scanner scanner = new Scanner(System.in);
        String outputString = scanner.nextLine();
        return outputString;
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
        Game newGame = new Game(displayer);
        newGame.playOneGame();
    }

}
