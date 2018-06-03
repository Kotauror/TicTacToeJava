package com.core.tictactoe;

import com.core.tictactoe.GameOption;

public class ExitGameOption extends GameOption {

    @Override
    public void run() {
        System.exit(0);
    }
}
