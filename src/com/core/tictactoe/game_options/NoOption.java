package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUI;

public class NoOption extends GameOption {

    public NoOption(){}

    @Override
    public boolean run(CommandLineUI commandLineUI) {
        commandLineUI.noSuchOption();
        return true;
    }
}
