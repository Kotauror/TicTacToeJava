package com.core.tictactoe;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String sign) {
        super(sign, null);
    }

    private final static int MAX_VALUE_OF_PLACE = 10;
    private final static int TIE_VALUE = 0;
    private final static int INITIAL_ALPHA = -10000000;
    private final static int INITIAL_BETA = 10000000;
    private final static int MINIMAX_THRESHOLD = 14;


    @Override
    public String getType() {
        return "Computer";
    }

    @Override
    public int pickPosition(Board board) {
        String maxPlayerSign = board.getActivePlayerSign();
        String minPlayerSign = board.getPassivePlayerSign();
        String[] freePlacesInBoard = board.getFreePlaces();
        if (freePlacesInBoard.length < MINIMAX_THRESHOLD) {
            return miniMaxAlgorithm(board, 0, INITIAL_ALPHA, INITIAL_BETA, maxPlayerSign, minPlayerSign);
        } else {
            return randomMove(freePlacesInBoard);
        }
    }

     protected int miniMaxAlgorithm(Board board, Integer depth, Integer alpha, Integer beta, String maxPlayerSign, String minPlayer) {
        if (board.isWon() && board.winnerSign().equals(maxPlayerSign)) {
            return (MAX_VALUE_OF_PLACE - depth);
        } else if (board.isWon() && board.winnerSign().equals(minPlayer)) {
            return -(MAX_VALUE_OF_PLACE - depth);
        } else if (board.isTie()) {
            return TIE_VALUE;
        }

        String[] freePlaces = board.getFreePlaces();

        if (isMaxPlayerDepth(depth)) {
            int bestScoreMaxPlayer = -1000;
            String bestPlace = "temporary";
            for (String freePlace : freePlaces) {
                Board boardClone = putSignOnNewBoard(board, maxPlayerSign, freePlace);
                int output = miniMaxAlgorithm(boardClone,depth + 1, alpha, beta, maxPlayerSign, minPlayer);
                if (output > bestScoreMaxPlayer) {
                    bestPlace = freePlace;
                    bestScoreMaxPlayer = output;
                }
                if (bestScoreMaxPlayer > alpha) alpha = bestScoreMaxPlayer;
                if (beta <= alpha) break;
            }
            return depth == 0 ? Integer.parseInt(bestPlace) : bestScoreMaxPlayer;
        } else {
            int bestScoreMinPlayer = 1000;
            for (String freePlace : freePlaces) {
                Board boardClone = putSignOnNewBoard(board, minPlayer, freePlace);
                int output = miniMaxAlgorithm(boardClone, depth + 1, alpha, beta, maxPlayerSign, minPlayer);
                if (output < bestScoreMinPlayer) bestScoreMinPlayer = output;
                if (bestScoreMinPlayer < beta) beta = bestScoreMinPlayer;
                if (beta <= alpha) break;
            }
            return bestScoreMinPlayer;
        }
    }

    protected int randomMove(String[] availableMoves) {
        int random = new Random().nextInt(availableMoves.length);
        return random+1;
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
