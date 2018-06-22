package com.core.tictactoe;

import com.core.tictactoe.game_options.RunGameOption;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunGameOptionTests {

    private final static String BOARD_3_x_3 = "3";

    @Test
    public void runsAHumanVsHumanGame() {
        String[] fakeUsersInputs = {BOARD_3_x_3, "1", "2", "3", "4", "5", "6", "7", "8"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        RunGameOption runGameOption = new RunGameOption(new HumanPlayer("X"), new HumanPlayer("O"), stubCommandLineUi);

        runGameOption.run();

        assertTrue(runGameOption.getGame().getBoard().isWon());
    }

    @Test
    public void runsAHumanVsComputerGame() {
        String[] fakeUsersInputs = {BOARD_3_x_3, "1", "2", "7", "6", "9"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        RunGameOption runGameOption = new RunGameOption(new HumanPlayer("X"), new ComputerPlayer("O"), stubCommandLineUi);

        runGameOption.run();

        assertFalse(runGameOption.getGame().getBoard().isWon());
        assertTrue(runGameOption.getGame().getBoard().isTie());
    }
}
