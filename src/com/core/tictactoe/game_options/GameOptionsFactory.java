package com.core.tictactoe.game_options;

import java.util.HashMap;
import java.util.Map;

public class GameOptionsFactory {

    private static final Map<String, GameOption> gameOptions;

    private static final String HUMAN_VS_HUMAN = "1";
    private static final String EXIT = "2";

    private GameOptionsFactory() {}

    static {
        gameOptions = new HashMap();
        gameOptions.put(HUMAN_VS_HUMAN, new RunGameOption());
        gameOptions.put(EXIT, new ExitGameOption());
    }

    public static GameOption get(String type) {
        return (gameOptions.get(type) != null) ? gameOptions.get(type) : new NoOption();
    }
}
