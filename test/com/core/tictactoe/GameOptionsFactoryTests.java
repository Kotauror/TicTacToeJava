package com.core.tictactoe;

import com.core.tictactoe.game_options.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOptionsFactoryTests {

    private GameOptionsFactory factory;

    @BeforeEach
    public void instantiate() {
        factory = new GameOptionsFactory(new CommandLineUi(System.out, System.in));
    }

    @Test
    public void returnsInstanceOfNoOption() {
        GameOption option = factory.get("7");
        assertThat(option, instanceOf(NoOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor2() {
        GameOption option = factory.get("H");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor1() {
        GameOption option = factory.get("C");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfExitGameOption() {
        GameOption option = factory.get("E");
        assertThat(option, instanceOf(ExitGameOption.class));
    }

}
