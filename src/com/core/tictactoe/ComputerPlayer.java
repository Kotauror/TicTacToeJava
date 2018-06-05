package com.core.tictactoe;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String sign) {
        super(sign);
    }

    protected int playMove(Board board, String firstSign, String secondSign) {
        int output = 0;
        System.out.println("Active player");
        System.out.println(firstSign);
        CommandLineUI clui = new CommandLineUI(System.out, System.in);
        System.out.println("board before move");
        clui.showBoard(board);
        System.out.println("board after move");
        ArrayList<String> freePlaces = board.getFreePlaces();
        for (String freePlace : freePlaces) {
            board.putSignOnBoard(firstSign, Integer.parseInt(freePlace));
            clui.showBoard(board);
            if (board.isWon() && board.winnerSign() == firstSign) {
                System.out.println("i won");
                return 10;
            } else if (board.isWon() && board.winnerSign() == secondSign) {
                System.out.println("other won");
                return -10;
            } else if (board.isTie()) {
                System.out.println("its a tie");
                return 0;
            } else {
                System.out.println("we still play");
                output = playMove(board, secondSign, firstSign);
            }
            board.putSignOnBoard(freePlace, Integer.parseInt(freePlace));
        }
        // return position which led us to 10, if it not available,
        // return position which led us to 0.
        return output;
    }
}
