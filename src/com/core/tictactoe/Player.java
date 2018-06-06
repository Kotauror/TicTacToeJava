package com.core.tictactoe;

public class Player {

    private String sign;

    public Player(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public int playMove(Board board, int level, String maxPlayer, String minPlayer) {
        return level;
    }
}
