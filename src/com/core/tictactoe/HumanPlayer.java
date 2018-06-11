package com.core.tictactoe;

public class HumanPlayer extends Player {

    private CommandLineUI commandLineUI;

    public HumanPlayer(String sign) {
        super(sign);
        this.commandLineUI = new CommandLineUI(System.out, System.in);
    }

    @Override
    public int playMove(CommandLineUI commandLineUI, Board board) {
        int position = commandLineUI.getPositionFromUser(board, this.getSign());
        return position;
    }
}
