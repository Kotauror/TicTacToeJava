package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GamesControllerTests {

    private GamesController gamesController;

    @BeforeEach
    void instantiate() {
        gamesController = new GamesController(new CommandLineUi(System.out, System.in));
    }

    @Test
    void runsTheWholeGameHumanVsHuman() {
        String[] fakeUsersInputs = {"1", "1", "2", "3", "4", "5", "6", "7", "E"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs));

        gamesController.run();
    }

    @Test
    void runsTheWholeGameHumanVsComputerAndExits() {
        String[] fakeUsersInputs = {"2", "H", "1", "2", "7", "6", "9", "E"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs));

        gamesController.run();
    }

    @Test
    void runsTheWholeGameHumanVsComputerTwiceAndExits() {
        String[] fakeUsersInputs = {"2", "H", "1", "2", "7", "6", "9", "2", "H", "1", "2", "7", "6", "9", "E"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs));

        gamesController.run();
    }

    @Test
    void runsTheWholeGameComputerVsHumanAndExits() {
        String[] fakeUsersInputs = {"2", "C", "5", "3", "4", "8", "E"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs));

        gamesController.run();
    }

    @Test
    void exitsTheGame() {
        String[] fakeUsersInputs = {"E"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs));

        gamesController.run();
    }
}
