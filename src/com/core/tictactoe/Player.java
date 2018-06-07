package com.core.tictactoe;

public abstract class Player {

    private String sign;

    public Player(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public abstract int playMove(CommandLineUI commandLineUI, Board board, int level, String maxPlayer, String minPlayer);
}
