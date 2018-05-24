package com.example.tictactoe;

import java.util.Scanner;

public class Game {

    Board board;
    Displayer displayer;
    public Player active;
    public Player passive;


    Game(Displayer displayer) {
        this.board = new Board();
        this.displayer = displayer;
        this.active = new Player("X");
        this.passive = new Player("Y");
    }

     protected void playGame() {
        this.displayer.greetUsers();
        while (!this.board.won && !this.board.tie) {
            this.displayer.showBoard(this.board.places);
            int position = this.getPositionFromUser();
            this.board.putSignOnBoard(this.active.sign, position);
            this.switchPlayers();
        }
        this.displayer.showBoard(this.board.places);
        this.displayer.announceWinner(this.board.winnerSign);
        this.playAgainMenu();
    }

    protected void switchPlayers() {
        Player playerTemp = this.active;
        this.active = this.passive;
        this.passive = playerTemp;
    }

    protected int getPositionFromUser() {
        Scanner scanner = new Scanner(System.in);
        this.displayer.askForPosition(this.active.sign);
        while (true) {
            String position = scanner.nextLine();
            if (Validator.isNumeric(position) && this.board.isNonTaken(position)) {
                return Integer.parseInt(position);
            }
            this.displayer.askAgainForPosition(this.active.sign);
        }
    }

    protected void playAgainMenu() {

    }

}
