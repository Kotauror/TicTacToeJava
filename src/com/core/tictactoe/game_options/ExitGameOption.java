package com.core.tictactoe.game_options;

public class ExitGameOption extends GameOption {

    @Override
    public boolean run(int boardSize) {
        return false;
    }

    @Override
    public int getBoardSize() {
        return 0;
    }
}
