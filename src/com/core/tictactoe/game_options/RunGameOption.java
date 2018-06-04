package com.core.tictactoe.game_options;

import com.core.tictactoe.Board;
import com.core.tictactoe.CommandLineUI;
import com.core.tictactoe.Game;

public class RunGameOption extends GameOption {

    CommandLineUI commandLineUI;
    Game game;

    public RunGameOption(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
    }

    @Override
    public void run() {
        this.game = new Game(this.commandLineUI, new Board());
        this.game.run();
    }

    public Game getGame() {
        return this.game;
    }
}
