package com.example.tictactoe;

public class Game {

    Board board;
    public Player active;
    public Player passive;

    Game () {
        this.board = new Board();
        this.active = new Player("X");
        this.passive = new Player("Y");
    }

     protected void playOneGame() {
        Displayer.greetUsers();
        while (!this.board.won && !this.board.tie) {
            this.playOneRound();
        }
        this.postGame();
    }

    protected void playOneRound() {
        boolean loopThrough = true;
        while (loopThrough) {
            Displayer.showBoard(this.board.places);
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
        Displayer.askForPosition(this.active.sign);
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
        Displayer.showBoard(this.board.places);
        Displayer.announceWinner(this.board.winnerSign);
    }
}
