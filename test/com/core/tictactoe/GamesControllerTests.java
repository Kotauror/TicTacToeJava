package com.core.tictactoe;

import com.core.tictactoe.game_options.ExitGameOption;
import com.core.tictactoe.game_options.GameOption;
import com.core.tictactoe.game_options.NoOption;
import com.core.tictactoe.game_options.RunGameOption;
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
}
