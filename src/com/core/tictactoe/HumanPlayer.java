package com.core.tictactoe;

public class HumanPlayer extends Player {

    public HumanPlayer(String sign) {
        super(sign);
    }

    @Override
    public int pickPosition(CommandLineUi commandLineUi, Board board) {
        String position = commandLineUi.getMoveChoice(board, this.getPositionPrompt());
        return Integer.parseInt(position);
    }

    @Override
    public String getType() {
        return "Player";
    }
}
