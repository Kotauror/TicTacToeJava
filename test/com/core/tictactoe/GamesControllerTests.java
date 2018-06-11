package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

        assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void runsTheWholeGameHumanVsComputerAndExits() {
        String[] fakeUsersInputs = {"2", "4", "1", "2", "7", "6", "9", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void runsTheWholeGameHumanVsComputerTwiceAndExits() {
        String[] fakeUsersInputs = {"2", "4", "1", "2", "7", "6", "9", "2", "4", "1", "2", "7", "6", "9", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void runsTheWholeGameComputerVsHumanAndExits() {
        String[] fakeUsersInputs = {"2", "5", "5", "3", "4", "8", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void exitsTheGame() {
        String[] fakeUsersInputs = {"3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        assertFalse(gamesController.getRunProgramStatus());
    }

}
