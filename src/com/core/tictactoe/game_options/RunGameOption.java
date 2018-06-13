package com.core.tictactoe.game_options;

import com.core.tictactoe.Board;
import com.core.tictactoe.CommandLineUi;
import com.core.tictactoe.Game;
import com.core.tictactoe.Player;

public class RunGameOption extends GameOption {

    private Game game;
    private Player playerOne;
    private Player playerTwo;
    private CommandLineUi commandLineUi;

    public RunGameOption(Player playerOne, Player playerTwo, CommandLineUi commandLineUi){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.commandLineUi = commandLineUi;
    }

    @Override
    public boolean run(CommandLineUi commandLineUi) {
        this.game = new Game(commandLineUi, new Board(), playerOne, playerTwo);
        this.game.run();
        return true;
    }

    public Game getGame() {
        return this.game;
    }
}
