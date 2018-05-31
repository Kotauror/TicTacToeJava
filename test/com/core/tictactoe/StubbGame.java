package com.core.tictactoe;

public class StubbGame extends Game {

    public StubbGame() {
        this.board = new Board();
        this.active = new Player("X");
        this.passive = new Player("Y");
        this.commandLineUI = new CommandLineUI(System.out, System.in);
    }

    protected String runFake() {
        return "tested";
    }
}
