package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.GameOptionsFactory;

public class GamesController {

    private CommandLineUi commandLineUi;
    private Boolean isRunning;

    public GamesController(CommandLineUi commandLineUi) {
        this.commandLineUi = commandLineUi;
        this.isRunning = true;
    }

    public void run() {
        while (this.isRunning) {
            GameOptionsFactory factory = new GameOptionsFactory(this.commandLineUi);
            String gameMode = this.commandLineUi.twoLevelMenu();
            GameOption gameOption = factory.getGameOption(gameMode);
            this.isRunning = gameOption.run();
        }
    }

//    public boolean getRunProgramStatus() {
//        return this.isRunning;
//    }
}
