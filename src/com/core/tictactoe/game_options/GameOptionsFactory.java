package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUi;
import com.core.tictactoe.ComputerPlayer;
import com.core.tictactoe.HumanPlayer;

import java.util.HashMap;
import java.util.Map;

public class GameOptionsFactory {

    private HashMap<GameMode, GameOption> gameOptionsMap;
    private CommandLineUi commandLineUi;

    public GameOptionsFactory(CommandLineUi commandLineUi) {
        this.commandLineUi = commandLineUi;
        this.gameOptionsMap = new HashMap();
        createGameOptions();
    }

    public GameOption getGameOption(String userInput) {
        for(Map.Entry<GameMode, GameOption> gameOption : this.gameOptionsMap.entrySet()) {
            GameMode gameMode = gameOption.getKey();
            if (gameMode.value().equals(userInput)) {
                return gameOption.getValue();
            }
        }
        return new NoOption(this.commandLineUi);
    }

    private void createGameOptions() {
        gameOptionsMap.put(GameMode.HUMAN_VS_HUMAN, new RunGameOption(new HumanPlayer("X"), new HumanPlayer("O"), this.commandLineUi));
        gameOptionsMap.put(GameMode.HUMAN_VS_COMPUTER_HUMAN_GOES_FIRST, new RunGameOption(new HumanPlayer("X"), new ComputerPlayer("O"), this.commandLineUi));
        gameOptionsMap.put(GameMode.COMPUTER_VS_HUMAN_COMPUTER_GOES_FIRST, new RunGameOption(new ComputerPlayer("X"), new HumanPlayer("O"), this.commandLineUi));
        gameOptionsMap.put(GameMode.EXIT, new ExitGameOption());
    }
}
