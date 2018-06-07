package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {

    private Player player;
    private CommandLineUI commandLineUI;

    @BeforeEach
    void instantiate() {
        commandLineUI = new CommandLineUI(System.out, System.in);
        player = new Player("X", commandLineUI);
    }

    @Test
    void hasSign() {
        assertEquals(player.getSign(), "X");
    }

    @Test
    void hasCommandLineUI() {
        assertEquals(player.getCommandLineUI(), commandLineUI);
    }

    @Test
    void returnsLevel() {
        assertEquals(1, player.playMove(new CommandLineUI(System.out, System.in), new Board(), 1, "X", "Y"));
    }
}
