package com.example.tictactoe;

import java.util.Scanner;

public class GamesController {

    public Displayer displayer;

    GamesController(Displayer displayer) {
        this.displayer = displayer;
    }

    public void gamesMenu() {
        String pickedOption = this.getUserOption();
        if (Validator.playAgainValid(pickedOption)) {
            this.playANewGame();
        } else if (Validator.exitValid(pickedOption)) {
            System.exit(0);
        } else {
            this.gamesMenu();
        }
    }

    public String getUserOption() {
        this.displayer.gamingMenu();
        Scanner scanner = new Scanner(System.in);
        String outputString = scanner.nextLine();
        return outputString;
    }

    public void playANewGame() {
        Game newGame = new Game(displayer);
        newGame.playGame();
    }

}
