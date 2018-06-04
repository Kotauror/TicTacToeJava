package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {

    private Player player;

    @BeforeEach
    void instantiatePlayer() {
        player = new Player("X");
    }

    @Test
    void playerHasSign() {
        assertEquals(player.getSign(), "X");
    }
}
