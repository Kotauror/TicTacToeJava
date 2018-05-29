package com.core.tictactoe;

public class Game {

    Board board;
    Player active;
    Player passive;
    CommandLineUI commandLineUI;

    Game (CommandLineUI commandLineUI) {
        this.board = new Board();
        this.active = new Player("X");
        this.passive = new Player("Y");
        this.commandLineUI = commandLineUI;
    }

     protected void run() {
        this.commandLineUI.greetUsers();
        while (!this.board.isWon() && !this.board.isTie()) {
            this.playTurn();
        }
        this.postGame();
    }

    protected void playTurn() {
        boolean loopThrough = true;
        while (loopThrough) {
            this.commandLineUI.showBoard(this.board);
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
        this.commandLineUI.askForPosition(this.active);
        return this.commandLineUI.getUserInput();
    }

    protected boolean actUponOption(String position) {
        if (this.commandLineUI.isNumeric(position) && this.board.isNonTaken(position)) {
            this.board.putSignOnBoard(this.active, Integer.parseInt(position));
            this.switchPlayers();
            return false;
        } else {
            return true;
        }
    }

    protected void postGame() {
        this.commandLineUI.showBoard(this.board);
        this.commandLineUI.announceWinner(this.board);
    }
}
