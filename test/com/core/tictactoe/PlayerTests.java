package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {

    public Player player;

    @BeforeEach
    public void instantiatePlayer() {
        player = new Player("X");
    }

    @Test
    public void playerHasSign() {
        assertEquals(player.sign, "X");
    }

}
