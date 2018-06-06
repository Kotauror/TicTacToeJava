package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamesControllerTests {

    private GamesController gamesController;

    @BeforeEach
    void instantiate() {
        gamesController = new GamesController(new CommandLineUI(System.out, System.in));
    }

    @Test
    void runsTheWholeGame() {
        String[] fakeUsersInputs = {"1", "1", "2", "3", "4", "5", "6", "7", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertEquals("played", gamesController.getGameStatus());
    }
}
