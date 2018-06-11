package com.core.tictactoe;

import com.core.tictactoe.game_options.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOptionsFactoryTests {

    @Test
    public void returnsInstanceOfNoOption() {
        GameOption option = GameOptionsFactory.get("9");
        assertThat(option, instanceOf(NoOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor2() {
        GameOption option = GameOptionsFactory.get("4");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfRunGameOptionFor1() {
        GameOption option = GameOptionsFactory.get("5");
        assertThat(option, instanceOf(RunGameOption.class));
    }

    @Test
    public void returnsInstanceOfExitGameOption() {
        GameOption option = GameOptionsFactory.get("3");
        assertThat(option, instanceOf(ExitGameOption.class));
    }

}
