package com.example.tictactoe;

import java.util.Scanner;

public class GamesController {

    public Displayer displayer;

    GamesController(Displayer displayer) {
        this.displayer = displayer;
    }

    public void gamesMenu() {
        this.displayer.gamingMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String pickedOption = scanner.nextLine();
            if (Validator.playAgainValid(pickedOption)) {
                this.playANewGame();
            } else if (Validator.exitValid(pickedOption)) {
                System.exit(0);
            }
            this.displayer.gamingMenu();
        }
    }

    public void playANewGame() {
        Game newGame = new Game(displayer);
        newGame.playGame();
    }

}
