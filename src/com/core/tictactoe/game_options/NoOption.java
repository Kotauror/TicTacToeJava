package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUI;

public class NoOption extends GameOption {

    public NoOption(){}

    @Override
    public void run(CommandLineUI commandLineUI) {
        commandLineUI.noSuchOption();
    }
}
