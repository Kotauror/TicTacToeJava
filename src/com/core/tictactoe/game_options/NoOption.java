package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUi;

public class NoOption extends GameOption {

    public NoOption(){}

    @Override
    public boolean run(CommandLineUi commandLineUi) {
        commandLineUi.noSuchOption();
        return true;
    }
}
