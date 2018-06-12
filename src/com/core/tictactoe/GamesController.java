package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.GameOptionsFactory;

public class GamesController {

    private CommandLineUi commandLineUi;
    private Boolean runProgram;

    public GamesController(CommandLineUi commandLineUi) {
        this.commandLineUi = commandLineUi;
        this.runProgram = true;
    }

    public void run() {
        while (this.runProgram) {
            this.commandLineUi.gamingMenu();
            String userInput = this.commandLineUi.getUserInput();
            userInput = this.commandLineUi.askWhoGoesFirst(userInput);
            GameOption gameOption = GameOptionsFactory.get(userInput);
            this.runProgram = gameOption.run(this.commandLineUi);
        }
    }

    public boolean getRunProgramStatus() {
        return this.runProgram;
    }
}
