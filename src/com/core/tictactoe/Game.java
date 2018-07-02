package com.core.tictactoe;

public class Game {

    private Board board;
    private Player active;
    private Player passive;
    private CommandLineUi commandLineUi;

    public Game(){}

    public Game(CommandLineUi commandLineUi, Board board, Player playerOne, Player playerTwo) {
        this.commandLineUi = commandLineUi;
        this.board = board;
        this.active = playerOne;
        this.passive =  playerTwo;
    }

    public void run() {
        this.commandLineUi.greetUsers();
        while (!this.board.isWon() && !this.board.isTie()) {
            this.playTurn();
        }
        this.postGame();
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getActivePlayer() {
        return this.active;
    }

    public Player getPassivePlayer() {
        return this.passive;
    }

    protected void switchPlayers() {
        Player playerTemp = this.active;
        this.active = this.passive;
        this.passive = playerTemp;
    }

    private void playTurn() {
        this.commandLineUi.showBoard(this.board);
        int position = this.active.pickPosition(this.commandLineUi, this.board);
        this.commandLineUi.informOfMove(this.active, position);
        this.board.putSignOnBoard(this.active.getSign(), position);
        this.switchPlayers();
    }

    private void postGame() {
        this.commandLineUi.showBoard(this.board);
        this.commandLineUi.announceWinner(this.board);
    }

}
