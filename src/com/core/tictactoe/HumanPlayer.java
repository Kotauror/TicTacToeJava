package com.core.tictactoe;

public class HumanPlayer extends Player {

    public HumanPlayer(String sign, CommandLineUi commandLineUi) {
        super(sign, commandLineUi);
    }

    @Override
    public int pickPosition(Board board) {
        String position = getCommandLineUi().getMoveChoice(board, this.getPositionPrompt());
        return Integer.parseInt(position);
    }

    @Override
    public String getType() {
        return "Player";
    }
}
