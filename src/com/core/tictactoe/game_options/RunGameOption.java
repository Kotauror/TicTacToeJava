package com.core.tictactoe.game_options;

import com.core.tictactoe.*;

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
        String boardSize = this.commandLineUi.getBoardChoice(Board.getValidBoardSizes(), UserPrompts.getBoardSizePrompt());
        this.game = new Game(this.commandLineUi, new Board(Integer.parseInt(boardSize)), playerOne, playerTwo);
        this.game.run();
        return true;
    }

    public Game getGame() {
        return this.game;
    }
}
