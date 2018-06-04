package com.core.tictactoe;

import com.core.tictactoe.game_options.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOptionsFactoryTests {

    @Test
    public void returnsInstanceOfNoOption() {
        GameOption option = GameOptionsFactory.get("5");
        assertThat(option, instanceOf(NoOption.class));
    }

    @Test
    public void returnsInstanceOfExitGameOption() {
        GameOption option = GameOptionsFactory.get("2");
        assertThat(option, instanceOf(ExitGameOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOption() {
        GameOption option = GameOptionsFactory.get("1");
        assertThat(option, instanceOf(RunGameOption.class));
    }
}
