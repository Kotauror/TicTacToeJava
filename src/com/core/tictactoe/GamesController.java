package com.core.tictactoe;

import com.core.tictactoe.game_options.ExitGameOption;
import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.GameOptionsFactory;
import com.core.tictactoe.game_options.RunGameOption;

public class GamesController {

    private CommandLineUI commandLineUI;
    private String gameStatus;

    public GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
    }

    public String getGameStatus() {
        return this.gameStatus;
    }

    public void run() {
        while (true) {
            this.commandLineUI.gamingMenu();
            String userInput = this.commandLineUI.getUserInput();
            GameOption gameOption = GameOptionsFactory.get(userInput);
            gameOption.run(this.commandLineUI);
            if (gameOption instanceof ExitGameOption) break;
            if (gameOption instanceof RunGameOption) this.gameStatus = "played";
        }
    }
}
