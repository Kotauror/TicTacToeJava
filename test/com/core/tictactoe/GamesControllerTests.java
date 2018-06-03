package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class GamesControllerTests {

    private GamesController gamesController;

    @BeforeEach
    void instantiate() {
        gamesController = new GamesController(new CommandLineUI(System.out, System.in));
    }

    @Test
    void gameCreatesAnInstanceOfDisplayer() {
        assertThat(gamesController.commandLineUI, isA(CommandLineUI.class));
    }

    @Test
    void getUserOptionReturnsRunGameOption() {
        String[] fakeUsersInputs = {"1"};
        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));
        GameOption option = gamesController.getUserOption();
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    void getUserOptionReturnsExitGameOption() {
        String[] fakeUsersInputs = {"2"};
        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));
        GameOption option = gamesController.getUserOption();
        assertThat(option, instanceOf(ExitGameOption.class));
    }
    @Test
    void getUserOptionReturnsNoOption() {
        String[] fakeUsersInputs = {"3"};
        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));
        GameOption option = gamesController.getUserOption();
        assertThat(option, instanceOf(NoOption.class));
    }

//    @Test
//    void option1PlaysAGame() {
//        String[] fakeUsersInputs = {"1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "2"};
//        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));
//
//        gamesController.run();
//
//        assertTrue(gamesController.game.board.isWon());
//    }
//
//    @Test
//    void option2ExitsTheProgram() {
//        String[] fakeUsersInputs = {"2"};
//        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));
//
//        gamesController.run();
//
//        assertNull(gamesController.game);
//    }
}
