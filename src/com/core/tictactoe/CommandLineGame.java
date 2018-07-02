package com.core.tictactoe;

public class CommandLineGame extends Game {

    private CommandLineUi commandLineUi;

    public CommandLineGame(){}

    public CommandLineGame(CommandLineUi commandLineUi, Board board, Player playerOne, Player playerTwo) {
        super(board, playerOne, playerTwo);
        this.commandLineUi = commandLineUi;
    }

    public void run() {
        this.commandLineUi.greetUsers();
        while (!this.getBoard().isWon() && !this.getBoard().isTie()) {
            this.playTurn();
        }
        this.postGame();
    }

    private void playTurn() {
        this.commandLineUi.showBoard(this.getBoard());
        int position = this.getActivePlayer().pickPosition(this.getBoard());
        this.commandLineUi.informOfMove(this.getActivePlayer(), position);
        this.getBoard().putSignOnBoard(this.getActivePlayer().getSign(), position);
        this.switchPlayers();
    }

    private void postGame() {
        this.commandLineUi.showBoard(this.getBoard());
        this.commandLineUi.announceWinner(this.getBoard());
    }
}
