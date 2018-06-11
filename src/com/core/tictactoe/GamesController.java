package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.GameOptionsFactory;

public class GamesController {

    private CommandLineUI commandLineUI;
    private Boolean runProgram;

    public GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
        this.runProgram = true;
    }

    public void run() {
        while (this.runProgram) {
            this.commandLineUI.gamingMenu();
            String userInput = this.commandLineUI.getUserInput();
            userInput = this.commandLineUI.askWhoGoesFirst(userInput);
            GameOption gameOption = GameOptionsFactory.get(userInput);
            this.runProgram = gameOption.run(this.commandLineUI);
        }
    }

    public boolean getRunProgramStatus() {
        return this.runProgram;
    }
}
