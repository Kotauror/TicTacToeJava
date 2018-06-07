package com.core.tictactoe;

import com.core.tictactoe.game_options.RunGameOption;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunGameOptionTests {

    @Test
    public void runsAGame() {
        CommandLineUI commandLineUI = new CommandLineUI(System.out, System.in);
        String[] fakeUsersInputs = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        RunGameOption runGameOption = new RunGameOption(new HumanPlayer("X", commandLineUI), new HumanPlayer("Y", commandLineUI));

        runGameOption.run(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        assertTrue(runGameOption.getGame().getBoard().isWon());
    }
}
