package com.core.tictactoe;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String sign) {
        super(sign);
    }

    protected int playMove(Board board, String opponentsSign) {
        return 0;
    }
}
