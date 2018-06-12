package com.core.tictactoe.game_options;

import com.core.tictactoe.ComputerPlayer;
import com.core.tictactoe.HumanPlayer;

import java.util.HashMap;
import java.util.Map;

public class GameOptionsFactory {

    private HashMap<GameMode, GameOption> gameOptions;

    public GameOptionsFactory() {
        this.gameOptions = new HashMap();
        createGameOptions();
    }

    private void createGameOptions() {
        gameOptions.put(GameMode.HUMAN_VS_HUMAN, new RunGameOption(new HumanPlayer("X"), new HumanPlayer("O")));
        gameOptions.put(GameMode.HUMAN_VS_COMPUTER, new RunGameOption(new HumanPlayer("X"), new ComputerPlayer("O")));
        gameOptions.put(GameMode.COMPUTER_VS_HUMAN, new RunGameOption(new ComputerPlayer("X"), new HumanPlayer("O")));
        gameOptions.put(GameMode.EXIT, new ExitGameOption());
    }

    public GameOption get(String type) {
        for(Map.Entry<GameMode, GameOption> entry : this.gameOptions.entrySet()) {
            GameMode key = entry.getKey();
            if (key.value().equals(type)) {
                return entry.getValue();
            }
        }
        return new NoOption();
    }
}
