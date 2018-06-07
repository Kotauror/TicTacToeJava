package com.core.tictactoe;

public class Player {

    private String sign;
    private  CommandLineUI commandLineUI;

    public Player(String sign, CommandLineUI commandlineUI){
        this.sign = sign;
        this.commandLineUI = commandlineUI;
    }

    public String getSign() {
        return this.sign;
    }

    public CommandLineUI getCommandLineUI() {
        return  this.commandLineUI;
    }

    public int playMove(CommandLineUI commandLineUI, Board board, int level, String maxPlayer, String minPlayer) {
        return level;
    }
}
