package com.core.tictactoe;

public class HumanPlayer extends Player {

    public HumanPlayer(String sign) {
        super(sign);
    }

    @Override
    public int pickPosition(CommandLineUi commandLineUi, Board board) {
        int position = commandLineUi.getPositionFromUser(board, this.getSign());
        return position;
    }

    @Override
    public String getType() {
        return "Player";
    }
}
