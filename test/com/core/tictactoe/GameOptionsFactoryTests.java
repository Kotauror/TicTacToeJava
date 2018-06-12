package com.core.tictactoe;

import com.core.tictactoe.game_options.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOptionsFactoryTests {

    @Test
    public void returnsInstanceOfNoOption() {
        GameOption option = GameOptionsFactory.get("7");
        assertThat(option, instanceOf(NoOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor2() {
        GameOption option = GameOptionsFactory.get("H");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor1() {
        GameOption option = GameOptionsFactory.get("C");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfExitGameOption() {
        GameOption option = GameOptionsFactory.get("E");
        assertThat(option, instanceOf(ExitGameOption.class));
    }

}
