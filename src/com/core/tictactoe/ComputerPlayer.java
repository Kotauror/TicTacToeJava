package com.core.tictactoe;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    String opponentSign;

    public ComputerPlayer(String sign, String opponentSign) {
        super(sign);
        this.opponentSign = opponentSign;
    }


    public int playMove(Board board, int level, String maxPlayer, String minPlayer) {
        int output = 0;
        ArrayList<String> freePlaces = board.getFreePlaces();
        if (level % 2 == 0) {
            int bestScore = -1000;
            String bestPlace = "temporary";
             if (board.isWon() && board.winnerSign() == maxPlayer) {
                    return (10 -level);
                } else if (board.isWon() && board.winnerSign() == minPlayer) {
                    return -(10 - level);
                } else if (board.isTie()) {
                    return 0;
                }
            for (String freePlace : freePlaces) {
                Board boardClone = new Board(board.getPlaces());
                boardClone.putSignOnBoard(maxPlayer, Integer.parseInt(freePlace));
                output = playMove(boardClone, level + 1, maxPlayer, minPlayer);
                if (output > bestScore) {
                    bestPlace = freePlace;
                    bestScore = output;
                }
            }
            if (level == 0 ) {
                return Integer.parseInt(bestPlace);
            } else {
                return bestScore;
            }
        } else {
            ArrayList<String> freePlaces2 = board.getFreePlaces();
            int bestScore2 = 1000;
            if (board.isWon() && board.winnerSign() == minPlayer) {
                return -(10 - level);
            } else if (board.isWon() && board.winnerSign() == maxPlayer) {
                return 10 - level;
            } else if (board.isTie()) {
                return 0;
            }
            for (String freePlace : freePlaces2) {
                Board boardClone = new Board(board.getPlaces());
                boardClone.putSignOnBoard(minPlayer, Integer.parseInt(freePlace));
                output = playMove(boardClone, level + 1, maxPlayer, minPlayer);
                if (output < bestScore2) bestScore2 = output;
            }
            return bestScore2;
        }
    }
}
