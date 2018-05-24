package com.example.tictactoe;

import java.util.Scanner;

public class GamesController {

    public Displayer displayer;

    GamesController(Displayer displayer) {
        this.displayer = displayer;
    }

    public void gamesMenu() {
        int pickedOption = this.getUserOption();
        if (pickedOption == 1) {
            this.playANewGame();
        } else if (pickedOption == 2) {
            System.exit(0);
        } else {
            this.gamesMenu();
        }
    }

    public int getUserOption() {
        this.displayer.gamingMenu();
        Scanner scanner = new Scanner(System.in);
        String outputString = scanner.nextLine();
        return Integer.parseInt(outputString);
    }

    public void playANewGame() {
        Game newGame = new Game(displayer);
        newGame.playGame();
    }

}
