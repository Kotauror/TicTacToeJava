package com.core.tictactoe;

import com.core.tictactoe.game_options.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOptionsFactoryTests {

    GameOptionsFactory gameOptionsFactory;

    @BeforeEach
    void initiate() {
        gameOptionsFactory = new GameOptionsFactory();
    }

    @Test
    public void returnsInstanceOfNoOption() {
        GameOption option = gameOptionsFactory.get("5");
        assertThat(option, instanceOf(NoOption.class));
    }

    @Test
    public void returnsInstanceOfExitGameOption() {
        GameOption option = gameOptionsFactory.get("2");
        assertThat(option, instanceOf(ExitGameOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOption() {
        GameOption option = gameOptionsFactory.get("1");
        assertThat(option, instanceOf(RunGameOption.class));
    }
}
