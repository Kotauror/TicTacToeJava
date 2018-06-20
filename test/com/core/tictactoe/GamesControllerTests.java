package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOptionsFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GamesControllerTests {

    @Test
    void runsTheWholeGameHumanVsHuman() {
        String[] fakeUsersInputs = {"1", "1", "2", "3", "4", "5", "6", "7", "E"};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void runsTheWholeGameHumanVsComputerAndExits() {
        String[] fakeUsersInputs = {"2", "H", "1", "2", "7", "6", "9", "E"};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void runsTheWholeGameHumanVsComputerTwiceAndExits() {
        String[] fakeUsersInputs = {"2", "H", "1", "2", "7", "6", "9", "2", "H", "1", "2", "7", "6", "9", "E"};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void runsTheWholeGameComputerVsHumanAndExits() {
        String[] fakeUsersInputs = {"2", "C", "5", "3", "4", "8", "E"};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void exitsTheGame() {
        String[] fakeUsersInputs = {"E"};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    private GamesController gamesControllerCreator(String[] fakeUserInputs) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUserInputs);
        GameOptionsFactory gameOptionsFactory = new GameOptionsFactory(stubCommandLineUi);
        return new GamesController(stubCommandLineUi, gameOptionsFactory);
    }

}
