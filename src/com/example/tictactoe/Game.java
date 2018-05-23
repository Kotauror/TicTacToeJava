package com.example.tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    Board board;
    Displayer displayer;
    Validator validator;
    Player playerOne;
    Player playerTwo;
    public Player active;
    public Player passive;


    Game(Displayer displayer, Validator validator) {
        this.board = new Board();
        this.displayer = displayer;
        this.validator = validator;
        this.playerOne = new Player("X");
        this.playerTwo = new Player("Y");
        this.active = playerOne;
        this.passive = playerTwo;
    }

    public void playGame() throws IOException {
        this.displayer.greetUsers();
        while (!this.board.won && !this.board.tie) {
            this.displayer.showBoard(this.board.places);
            int position = this.getPositionFromUser();
            this.board.putSignOnBoard(this.active.sign, position);
            this.switchPlayers();
        }
        this.displayer.showBoard(this.board.places);
    }

    public void switchPlayers() {
        if (this.active == this.playerOne) {
            this.active = this.playerTwo;
            this.passive = this.playerOne;
        } else {
            this.passive = this.playerTwo;
            this.active = this.playerOne;
        }
    }

    public int getPositionFromUser() {
        Scanner scanner = new Scanner(System.in);
        this.displayer.askForPosition();
        while (true) {
            String position = scanner.nextLine();
            if (this.validator.isNumeric(position)) {
                if (this.board.isNonTaken(position)) {
                    return Integer.parseInt(position);
                }
            }
            this.displayer.askAgainForPosition();
        }
    }

}
