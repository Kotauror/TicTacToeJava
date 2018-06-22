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
    public boolean run() {
        int boardSize = this.getBoardSize();
        this.game = new Game(this.commandLineUi, new Board(boardSize), playerOne, playerTwo);
        this.game.run();
        return true;
    }

    public Game getGame() {
        return this.game;
    }

    private int getBoardSize() {
        return this.commandLineUi.getBoardSize();
    }
}
