package com.core.tictactoe.game_options;

import com.core.tictactoe.Board;
import com.core.tictactoe.CommandLineUI;
import com.core.tictactoe.Game;
import com.core.tictactoe.Player;

public class RunGameOption extends GameOption {

    private Game game;
    private Player playerOne;
    private Player playerTwo;

    public RunGameOption(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Override
    public boolean run(CommandLineUI commandLineUI) {
        this.game = new Game(commandLineUI, new Board(), playerOne, playerTwo);
        this.game.run();
        return true;
    }

    public Game getGame() {
        return this.game;
    }
}
