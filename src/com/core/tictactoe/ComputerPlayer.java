package com.core.tictactoe;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String sign) {
        super(sign);
    }

    protected int playMove(Board board) {
        ArrayList<String> freePlaces = board.getFreePlaces();
        for (String freePlace : freePlaces) {
            board.putSignOnBoard(this.getSign(), Integer.parseInt(freePlace));
            if (board.isWon()) {
                return Integer.parseInt(freePlace);
            }
            board.putSignOnBoard(freePlace, Integer.parseInt(freePlace));
        }
        return 0;
    }
}
