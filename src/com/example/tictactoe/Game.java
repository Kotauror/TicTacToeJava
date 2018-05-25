package com.example.tictactoe;

import java.util.Scanner;

public class Game {

    Board board;
    Displayer displayer;
    public Player active;
    public Player passive;
    Validator validator;


    Game(Displayer displayer) {
        this.board = new Board();
        this.displayer = displayer;
        this.active = new Player("X");
        this.passive = new Player("Y");
        this.validator = new Validator();
    }

     protected void playOneGame() {
        this.displayer.greetUsers();
        while (!this.board.won && !this.board.tie) {
            this.playOneRound();
        }
        this.postGame();
    }

    protected void playOneRound() {
        boolean loopThrough = true;
        while (loopThrough) {
            this.displayer.showBoard(this.board.places);
            String position = this.getUserPosition();
            loopThrough = this.actUponOption(position);
        }
    }

    protected void switchPlayers() {
        Player playerTemp = this.active;
        this.active = this.passive;
        this.passive = playerTemp;
    }

    protected String getUserPosition() {
        this.displayer.askForPosition(this.active.sign);
        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();
        return position;
    }

    protected boolean actUponOption(String position) {
        if (Validator.isNumeric(position) && this.board.isNonTaken(position)) {
            this.board.putSignOnBoard(this.active.sign, Integer.parseInt(position));
            this.switchPlayers();
            return false;
        } else {
            return true;
        }
    }

    protected void postGame() {
        this.displayer.showBoard(this.board.places);
        this.displayer.announceWinner(this.board.winnerSign);
    }
}
