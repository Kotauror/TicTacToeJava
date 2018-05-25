package com.example.tictactoe;

public class Game {

    Board board;
    Player active;
    Player passive;
    Displayer displayer;
    IOHelper iohelper;
    Validator validator;


    Game (Displayer displayer, IOHelper iohelper, Validator validator) {
        this.board = new Board();
        this.active = new Player("X");
        this.passive = new Player("Y");
        this.displayer = displayer;
        this.iohelper = iohelper;
        this.validator = validator;
    }

     protected void run() {
        this.displayer.greetUsers();
        while (!this.board.isWon() && !this.board.isTie()) {
            this.playTurn();
        }
        this.postGame();
    }

    protected void playTurn() {
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
        return this.iohelper.getUserInput();
    }

    protected boolean actUponOption(String position) {
        if (this.validator.isNumeric(position) && this.board.isNonTaken(position)) {
            this.board.putSignOnBoard(this.active.sign, Integer.parseInt(position));
            this.switchPlayers();
            return false;
        } else {
            return true;
        }
    }

    protected void postGame() {
        this.displayer.showBoard(this.board.places);
        this.displayer.announceWinner(this.board.winnerSign());
    }
}
