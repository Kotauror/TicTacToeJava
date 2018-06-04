package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUI;

public class NoOption extends GameOption {

    CommandLineUI commandLineUI;

    public NoOption(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
    }

    @Override
    public void run() {
        this.commandLineUI.noSuchOption();
    }
}
