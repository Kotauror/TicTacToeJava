package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GamesControllerTests {

    public GamesController gamesController;

    @BeforeEach
    public void instantiate() {
        gamesController = new GamesController(new CommandLineUI(System.out, System.in));
    }

    @Test
    public void GameCreatesAnInstanceOfDisplayer() {
        assertThat(gamesController.commandLineUI, isA(CommandLineUI.class));
    }

    @Test
    public void option1PlaysAGame() {
        String[] fakeUsersInputs = {"1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "2"};
        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));

        gamesController.gamesMenu();

        assertTrue(gamesController.game.board.isWon());
    }

    @Test
    public void option2ExitsTheProgram() {
        String[] fakeUsersInputs = {"2"};
        gamesController = new GamesController(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));

        gamesController.gamesMenu();

        assertNull(gamesController.game);
    }

}
