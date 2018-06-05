package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTests {

    private HumanPlayer humanPlayer;

    @BeforeEach
    void instantiate() {
        humanPlayer = new HumanPlayer("X");
    }

    @Test
    void hasSign() {
        assertEquals(humanPlayer.getSign(), "X");
    }
}





