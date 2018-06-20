package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.GameOptionsFactory;

public class GamesController {

    private CommandLineUi commandLineUi;
    private GameOptionsFactory gameOptionsFactory;
    private Boolean isRunning;

    public GamesController(CommandLineUi commandLineUi, GameOptionsFactory gameOptionsFactory) {
        this.commandLineUi = commandLineUi;
        this.gameOptionsFactory = gameOptionsFactory;
        this.isRunning = true;
    }

    public void run() {
        while (this.isRunning) {
            String gameMode = this.commandLineUi.mainMenu();
            GameOption gameOption = this.gameOptionsFactory.getGameOption(gameMode);
            this.isRunning = gameOption.run();
        }
    }
}
