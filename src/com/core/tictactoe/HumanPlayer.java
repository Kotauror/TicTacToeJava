package com.core.tictactoe;

public class HumanPlayer extends Player {

    private CommandLineUi commandLineUi;

    public HumanPlayer(String sign) {
        super(sign);
        this.commandLineUi = new CommandLineUi(System.out, System.in);
    }

    @Override
    public int pickPosition(CommandLineUi commandLineUi, Board board) {
        int position = commandLineUi.getPositionFromUser(board, this.getSign());
        return position;
    }

    @Override
    public String getTypeAsAString() {
        return "Player";
    }
}
