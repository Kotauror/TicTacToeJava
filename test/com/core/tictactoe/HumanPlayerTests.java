package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String[] fakeUserInputs = {"1"};
        StubbCommandLineUI stubbCommandLineUI = new StubbCommandLineUI(new PrintStream(output), System.in, fakeUserInputs);

        assertEquals(1, humanPlayer.playMove(stubbCommandLineUI, new Board()));
    }
}





