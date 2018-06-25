package com.core.tictactoe;

public class StubComputerPlayer extends ComputerPlayer {

    private final int RUNNING_MINIMAX = 1;
    private final int RANDOMIZING = 2;

    public StubComputerPlayer(String sign) {
        super(sign);
    }

    @Override
    protected int miniMaxAlgorithm(Board board, Integer depth, Integer alpha, Integer beta, String maxPlayerSign, String minPlayer) {
        return RUNNING_MINIMAX;
    }

    @Override
    protected int randomMove(String[] availableMoves) {
        return RANDOMIZING;
    }

}






