package com.core.tictactoe;

import com.core.tictactoe.game_options.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommandLineGameOptionsFactoryTests {

    private GameOptionsFactory gameOptionsFactory;

    @BeforeEach
    public void instantiate() {
        gameOptionsFactory = new GameOptionsFactory(new CommandLineUi(System.out, System.in));
    }

    @Test
    public void returnsInstanceOfNoOption() {
        GameOption option = gameOptionsFactory.getGameOption("7");
        assertThat(option, instanceOf(NoOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor2() {
        GameOption option = gameOptionsFactory.getGameOption("2H");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor1() {
        GameOption option = gameOptionsFactory.getGameOption("2C");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfExitGameOption() {
        GameOption option = gameOptionsFactory.getGameOption("E");
        assertThat(option, instanceOf(ExitGameOption.class));
    }
}
