package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamesControllerTests {

    private GamesController gamesController;

    @BeforeEach
    void instantiate() {
        gamesController = new GamesController(new CommandLineUI(System.out, System.in));
    }

    @Test
    void runsTheWholeGameHumanVsHuman() {
        String[] fakeUsersInputs = {"1", "1", "2", "3", "4", "5", "6", "7", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertEquals("played", gamesController.getGameStatus());
    }

    @Test
    void runsTheWholeGameHumanVsComputer() {
        String[] fakeUsersInputs = {"2", "4", "1", "2", "7", "6", "9", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertThat(gamesController.fitstPlayer, instanceOf(HumanPlayer.class));
    }

    @Test
    void runsTheWholeGameComputerVsHuman() {
        String[] fakeUsersInputs = {"2", "5", "5", "3", "4", "8", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertThat(gamesController.fitstPlayer, instanceOf(ComputerPlayer.class));
    }

}
