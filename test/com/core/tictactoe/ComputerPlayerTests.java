package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class ComputerPlayerTests {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    void instantiatePlayer() {
        computerPlayer = new ComputerPlayer("X");
    }

    @Test
    void playerHasSign() {
        assertEquals(computerPlayer.getSign(), "X");
    }
}
