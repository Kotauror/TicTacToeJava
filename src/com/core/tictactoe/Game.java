package com.core.tictactoe;

public class Game {

    Board board;
    Player active;
    Player passive;
    CommandLineUI commandLineUI;

    Game(CommandLineUI commandLineUI, Board board) {
        this.commandLineUI = commandLineUI;
        this.board = board;
        this.active = new Player("X");
        this.passive = new Player("Y");
    }

     void run() {
        this.commandLineUI.greetUsers();
        while (!this.board.isWon() && !this.board.isTie()) {
            this.playTurn();
        }
        this.postGame();
    }

    private void playTurn() {
        this.commandLineUI.showBoard(this.board);
        int position = this.commandLineUI.getPosition(this.board, this.active);
        this.board.putSignOnBoard(this.active, position);
        this.switchPlayers();
    }

    private void switchPlayers() {
        Player playerTemp = this.active;
        this.active = this.passive;
        this.passive = playerTemp;
    }

    private void postGame() {
        this.commandLineUI.showBoard(this.board);
        this.commandLineUI.announceWinner(this.board);
    }
}
