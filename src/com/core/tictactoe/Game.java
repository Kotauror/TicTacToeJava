package com.core.tictactoe;

public class Game {

    private Board board;
    private Player active;
    private Player passive;
    private CommandLineUI commandLineUI;

    public Game(CommandLineUI commandLineUI, Board board, Player playerOne, Player playerTwo) {
        this.commandLineUI = commandLineUI;
        this.board = board;
        this.active = playerOne;
        this.passive =  playerTwo;
    }

     public void run() {
        this.commandLineUI.greetUsers();
        while (!this.board.isWon() && !this.board.isTie()) {
            this.playTurn();
        }
        this.postGame();
    }

    Board getBoard() {
        return this.board;
    }

    Player getActivePlayer() {
        return this.active;
    }

    Player getPassivePlayer() {
        return this.passive;
    }

    private void playTurn() {
        this.commandLineUI.showBoard(this.board);
        int position = this.active.playMove(this.commandLineUI, this.board, this.active.getSign(), this.passive.getSign());
        this.commandLineUI.informOfMove(this.active, position);
        this.board.putSignOnBoard(this.active.getSign(), position);
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
