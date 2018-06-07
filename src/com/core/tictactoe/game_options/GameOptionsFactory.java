package com.core.tictactoe.game_options;

import com.core.tictactoe.CommandLineUI;
import com.core.tictactoe.HumanPlayer;
import com.core.tictactoe.ComputerPlayer;

import java.util.HashMap;
import java.util.Map;

public class GameOptionsFactory {

    private static final Map<String, GameOption> gameOptions;

    private static final String HUMAN_VS_HUMAN = "1";
    private static final String HUMAN_VS_COMPUTER ="2";
    private static final String EXIT = "3";

    private GameOptionsFactory() {}

    static {
        CommandLineUI clui = new CommandLineUI(System.out, System.in);
        gameOptions = new HashMap();
        gameOptions.put(HUMAN_VS_HUMAN, new RunGameOption(new HumanPlayer("X", clui), new HumanPlayer("Y", clui)));
        gameOptions.put(HUMAN_VS_COMPUTER, new RunGameOption(new HumanPlayer("X", clui), new ComputerPlayer("Y", clui)));
        gameOptions.put(EXIT, new ExitGameOption());
    }

    public static GameOption get(String type) {
        return (gameOptions.get(type) != null) ? gameOptions.get(type) : new NoOption();
    }
}
