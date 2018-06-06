package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {

    private Player player;

    @BeforeEach
    void instantiate() {
        player = new Player("X");
    }

    @Test
    void hasSign() {
        assertEquals(player.getSign(), "X");
    }

    @Test
    void returnsLevel() {
        assertEquals(1, player.playMove(new CommandLineUI(System.out, System.in), new Board(), 1, "X", "Y"));
    }
}
