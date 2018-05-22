package com.example.tictactoe;

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
    public void playerHasInitialActiveStatusFalse() {
        assertEquals(player.active,false);
    }

    @Test
    public void playerHasSign() {
        assertEquals(player.sign, "X");
    }


}
