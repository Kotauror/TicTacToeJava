package com.core.tictactoe;

import com.core.tictactoe.game_options.ExitGameOption;
import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.NoOption;
import com.core.tictactoe.game_options.RunGameOption;

public class GamesController {

    private CommandLineUI commandLineUI;

    private static final String HUMAN_VS_HUMAN = "1";
    private static final String EXIT = "2";
    private String gameStatus;

    public GamesController(CommandLineUI commandLineUI) {
        this.commandLineUI = commandLineUI;
    }

    public void run() {
        boolean runThroughOptions = true;
        while (runThroughOptions) {
            GameOption userOption = this.getUserOption();
            userOption.run();
            if (userOption instanceof ExitGameOption) runThroughOptions = false;
        }
    }

    protected GameOption getUserOption() {
        this.commandLineUI.gamingMenu();
        String userInput = this.commandLineUI.getUserInput();
        switch (userInput) {
            case HUMAN_VS_HUMAN:
                this.gameStatus = "played";
                return new RunGameOption(this.commandLineUI);
            case EXIT:
                return new ExitGameOption();
            default:
                return new NoOption(this.commandLineUI);
        }
    }

    public CommandLineUI getCommandLineUI() {
        return this.commandLineUI;
    }

    public String getGameStatus() {
        return this.gameStatus;
    }
}
