package com.example.tictactoe;

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
        return IOHelper.getUserInput();
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
