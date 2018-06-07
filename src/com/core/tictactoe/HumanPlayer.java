package com.core.tictactoe;

public class HumanPlayer extends Player {

    public HumanPlayer(String sign, CommandLineUI commandlineUI) {
        super(sign, commandlineUI);
    }

    @Override
    public int playMove(CommandLineUI commandLineUI, Board board, int level, String maxPlayer, String minPlayer) {
        int position = commandLineUI.getPositionFromUser(board, maxPlayer);
        //return super.playMove(board, level, maxPlayer, minPlayer);
        return position;
    }
}
