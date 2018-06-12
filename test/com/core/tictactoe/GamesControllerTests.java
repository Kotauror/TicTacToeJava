package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//import java.lang.reflect.Field;

public class GamesControllerTests {

    private GamesController gamesController;

    @BeforeEach
    void instantiate() {
        gamesController = new GamesController(new CommandLineUi(System.out, System.in));
    }

    @Test
    void runsTheWholeGameHumanVsHuman() {
        String[] fakeUsersInputs = {"1", "1", "2", "3", "4", "5", "6", "7", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        // assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void runsTheWholeGameHumanVsComputerAndExits() {
        String[] fakeUsersInputs = {"2", "4", "1", "2", "7", "6", "9", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        // assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void runsTheWholeGameHumanVsComputerTwiceAndExits() {
        String[] fakeUsersInputs = {"2", "4", "1", "2", "7", "6", "9", "2", "4", "1", "2", "7", "6", "9", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        // assertFalse(gamesController.getRunProgramStatus());
    }

    @Test
    void runsTheWholeGameComputerVsHumanAndExits() throws NoSuchFieldException, IllegalAccessException {
        String[] fakeUsersInputs = {"2", "5", "5", "3", "4", "8", "3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        // Field field = GamesController.class.getDeclaredField("isRunning");
        // field.setAccessible(true);
        // field.get(gamesController);


        // assertFalse((Boolean) field.get(gamesController));
    }

    @Test
    void exitsTheGame() {
        String[] fakeUsersInputs = {"3"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        gamesController = new GamesController(new StubCommandLineUi(new PrintStream(output), System.in, fakeUsersInputs));

        gamesController.run();

        // assertFalse(gamesController.getRunProgramStatus());
    }

}
