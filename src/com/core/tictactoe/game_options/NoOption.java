package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUi;

public class NoOption extends GameOption {

    private CommandLineUi commandLineUi;

    public NoOption(CommandLineUi commandLineUi){
        this.commandLineUi = commandLineUi;
    }

    @Override
    public boolean run(int boardSize) {
        this.commandLineUi.noSuchOption();
        return true;
    }

    @Override
    public int getBoardSize() {
        return 0;
    }
}
