package com.core.tictactoe;

import com.core.tictactoe.game_options.RunGameOption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunGameOptionTests {

    @Test
    public void runsAGame() {
        String[] fakeUsersInputs = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        RunGameOption runGameOption = new RunGameOption(new HumanPlayer("X"), new HumanPlayer("Y"));

        runGameOption.run(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));

        assertTrue(runGameOption.getGame().getBoard().isWon());
    }
}
