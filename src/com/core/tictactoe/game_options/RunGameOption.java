package com.core.tictactoe.game_options;

import com.core.tictactoe.Board;
import com.core.tictactoe.CommandLineUI;
import com.core.tictactoe.Game;

public class RunGameOption extends GameOption {

    private Game game;

    public RunGameOption(){}

    @Override
    public void run(CommandLineUI commandLineUI) {
        this.game = new Game(commandLineUI, new Board());
        this.game.run();
    }

    public Game getGame() {
        return this.game;
    }
}
