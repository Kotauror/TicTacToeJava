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
            this.commandLineUi.gamingMenu();
            String userInput = this.commandLineUi.getUserInput();
            userInput = this.commandLineUi.askWhoGoesFirst(userInput);
            GameOption gameOption = GameOptionsFactory.get(userInput);
            this.isRunning = gameOption.run(this.commandLineUi);
        }
    }

//    public boolean getRunProgramStatus() {
//        return this.isRunning;
//    }
}
