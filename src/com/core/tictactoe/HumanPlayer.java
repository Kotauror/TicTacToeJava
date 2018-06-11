package com.core.tictactoe;

public class HumanPlayer extends Player {

    private CommandLineUI commandLineUI;

    public HumanPlayer(String sign) {
        super(sign);
        this.commandLineUI = new CommandLineUI(System.out, System.in);
    }

    @Override
    public int playMove(CommandLineUI commandLineUI, Board board, String maxPlayer, String minPlayer) {
        int position = commandLineUI.getPositionFromUser(board, maxPlayer);
        return position;
    }
}
