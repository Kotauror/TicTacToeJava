package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanPlayerTests {

    private HumanPlayer humanPlayer;

    @BeforeEach
    void instantiate() {
        humanPlayer = new HumanPlayer("X");
    }

    @Test
    void hasSign() {
        assertEquals(humanPlayer.getSign(), "X");
    }

    @Test
    void returnsAMove() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String[] fakeUserInputs = {"1"};
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUserInputs);

        assertEquals(1, humanPlayer.pickPosition(stubCommandLineUi, new Board(3)));
    }

    @Test
    void returnsATypeOfPlayerAsAString() {
        String playerType = humanPlayer.getType();

        assertEquals("Player", playerType);
    }
}





