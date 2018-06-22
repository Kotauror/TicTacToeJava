package com.core.tictactoe;

public class StubComputerPlayer extends ComputerPlayer {

    private final int RUNNINGM_INIMAX = 1;
    private final int RANDOMIZING = 2;

    public StubComputerPlayer(String sign) {
        super(sign);
    }

    @Override
    public int pickPosition(CommandLineUi commandLineUi, Board board) {
        String[] freePlacesInBoard = board.getFreePlaces();
        if (freePlacesInBoard.length < 14) {
            return RUNNINGM_INIMAX;
        } else {
            return RANDOMIZING;
        }
    }
}






