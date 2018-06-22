package com.core.tictactoe;

import com.core.tictactoe.game_options.GameOptionsFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GamesControllerTests {

    private final static String HUMAN_VS_HUMAN_GAME = "1";
    private final static String HUMAN_VS_COMPUTER_GAME = "2";
    private final static String BOARD_3_x_3 = "3";
    private final static String COMPUTER_GOES_FIRST = "C";
    private final static String HUMAN_GOES_FIRST = "H";
    private final static String EXIT_GAME = "E";


    @Test
    void runsTheWholeGameHumanVsHuman() {
        String[] fakeUsersInputs = {HUMAN_VS_HUMAN_GAME, BOARD_3_x_3, "1", "2", "3", "4", "5", "6", "7", EXIT_GAME};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void runsTheWholeGameHumanVsComputerAndExits() {
        String[] fakeUsersInputs = {HUMAN_VS_COMPUTER_GAME, HUMAN_GOES_FIRST, BOARD_3_x_3, "1", "2", "7", "6", "9", EXIT_GAME};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void runsTheWholeGameHumanVsComputerTwiceAndExits() {
        String[] fakeUsersInputs = {HUMAN_VS_COMPUTER_GAME, HUMAN_GOES_FIRST, BOARD_3_x_3, "1", "2", "7", "6", "9", HUMAN_VS_COMPUTER_GAME, HUMAN_GOES_FIRST, BOARD_3_x_3, "1", "2", "7", "6", "9", EXIT_GAME};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void runsTheWholeGameComputerVsHumanAndExits() {
        String[] fakeUsersInputs = {HUMAN_VS_COMPUTER_GAME, COMPUTER_GOES_FIRST, BOARD_3_x_3, "5", "3", "4", "8", EXIT_GAME};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void exitsTheGame() {
        String[] fakeUsersInputs = {EXIT_GAME};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void asksAgainForBoardSizeAndRunsTheWholeGameOnValidInput() {
        String[] fakeUsersInputs = {HUMAN_VS_HUMAN_GAME, "invalid input", "3", "1", "2", "3", "4", "5", "6", "7", EXIT_GAME};
        GamesController gamesController = gamesControllerCreator(fakeUsersInputs);

        gamesController.run();
    }

    @Test
    void asksAgainWhenUserInputIsOutsideOfRangeOfBoardAndRunsTheWholeGameOnValidInput() {
        String[] fakeUsersInputs = {HUMAN_VS_HUMAN_GAME, "invalid input", BOARD_3_x_3, "1", "200", "2", "3", "4", "5", "6", "7", EXIT_GAME};
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
