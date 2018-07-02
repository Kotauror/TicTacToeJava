package com.core.tictactoe;

public class Game {

    private Board board;
    private Player active;
    private Player passive;

    public Game(){}

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.active = playerOne;
        this.passive =  playerTwo;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getActivePlayer() {
        return this.active;
    }

    public Player getPassivePlayer() { return this.passive; }

    protected void putSingOnBoard(int position) {
        this.getBoard().putSignOnBoard(this.getActivePlayer().getSign(), position);
    }

    protected void switchPlayers() {
        Player playerTemp = this.active;
        this.active = this.passive;
        this.passive = playerTemp;
    }
}
