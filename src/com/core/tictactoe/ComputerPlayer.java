package com.core.tictactoe;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String sign) {
        super(sign);
    }

    private final static int MAX_VALUE_OF_PLACE = 10;
    private final static int TIE_VALUE = 0;


    @Override
    public int pickPosition(CommandLineUI commandLineUI, Board board) {
        String maxPlayer = board.getActivePlayerSign();
        String minPlayer = board.getPassivePlayerSign();
        return miniMaxAlgorithm(board, 0, maxPlayer, minPlayer);
    }

    private int miniMaxAlgorithm(Board board, Integer depth, String maxPlayer, String minPlayer) {
        if (board.isWon() && board.winnerSign().equals(maxPlayer)) {
            return (MAX_VALUE_OF_PLACE - depth);
        } else if (board.isWon() && board.winnerSign().equals(minPlayer)) {
            return -(MAX_VALUE_OF_PLACE - depth);
        } else if (board.isTie()) {
            return TIE_VALUE;
        }

        ArrayList<String> freePlaces = board.getFreePlaces();

        if (isMaxPlayerDepth(depth)) {
            int bestScoreMaxPlayer = -1000;
            String bestPlace = "temporary";
            for (String freePlace : freePlaces) {
                Board boardClone = putSignOnNewBoard(board, maxPlayer, freePlace);
                int output = miniMaxAlgorithm(boardClone, depth + 1, maxPlayer, minPlayer);
                if (output > bestScoreMaxPlayer) {
                    bestPlace = freePlace;
                    bestScoreMaxPlayer = output;
                }
            }
            return depth == 0 ? Integer.parseInt(bestPlace) : bestScoreMaxPlayer;
        } else {
            int bestScoreMinPlayer = 1000;
            for (String freePlace : freePlaces) {
                Board boardClone = putSignOnNewBoard(board, minPlayer, freePlace);
                int output = miniMaxAlgorithm(boardClone, depth + 1, maxPlayer, minPlayer);
                if (output < bestScoreMinPlayer) bestScoreMinPlayer = output;
            }
            return bestScoreMinPlayer;
        }
    }

    private Board putSignOnNewBoard(Board board, String signOfPlayer, String freePlace) {
        Board boardClone = new Board(board.getPlaces());
        boardClone.putSignOnBoard(signOfPlayer, Integer.parseInt(freePlace));
        return boardClone;
    }

    private boolean isMaxPlayerDepth(int depth) {
        return (depth % 2 == 0);
    }
}
