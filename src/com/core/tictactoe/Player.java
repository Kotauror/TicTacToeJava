package com.core.tictactoe;

public abstract class Player {

    private String sign;
    private CommandLineUi commandLineUi;

    public Player(){}

    public Player(String sign, CommandLineUi commandLineUi){
        this.sign = sign;
        this.commandLineUi = commandLineUi;
    }

    public String getSign() {
        return this.sign;
    }

    public abstract int pickPosition(Board board);

    public abstract String getType();

    public CommandLineUi getCommandLineUi() {
        return this.commandLineUi;
    }

    public String getPositionPrompt() {
        return this.sign + ", pick a position";
    }
}
