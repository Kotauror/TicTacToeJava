package com.core.tictactoe;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String sign) {
        super(sign);
    }

    @Override
    public int playMove(CommandLineUI commandLineUI, Board board, int level, String maxPlayer, String minPlayer) {
        ArrayList<String> freePlaces = board.getFreePlaces();
        if (level % 2 == 0) {
            int bestScoreMaxPlayer = -1000;
            String bestPlace = "temporary";
            if (board.isWon() && board.winnerSign() == maxPlayer) {
                return (10 -level);
            } else if (board.isWon() && board.winnerSign() == minPlayer) {
                return -(10 - level);
            } else if (board.isTie()) {
                return 0;
            }
            for (String freePlace : freePlaces) {
                Board boardClone = putSignOnNewBoard(board, maxPlayer, freePlace);
                int output = playMove(commandLineUI, boardClone, level + 1, maxPlayer, minPlayer);
                if (output > bestScoreMaxPlayer) {
                    bestPlace = freePlace;
                    bestScoreMaxPlayer = output;
                }
            }
            return level == 0 ? Integer.parseInt(bestPlace) : bestScoreMaxPlayer;
        } else {
            int bestScoreMinPlayer = 1000;
            if (board.isWon() && board.winnerSign() == minPlayer) {
                return -(10 - level);
            } else if (board.isWon() && board.winnerSign() == maxPlayer) {
                return 10 - level;
            } else if (board.isTie()) {
                return 0;
            }
            for (String freePlace : freePlaces) {
                Board boardClone = putSignOnNewBoard(board, minPlayer, freePlace);
                int output = playMove(commandLineUI, boardClone, level + 1, maxPlayer, minPlayer);
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
}
