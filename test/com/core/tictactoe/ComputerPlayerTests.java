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

    @Test
    void returnsBestMoveInTheFirstTurn() {
        Board board = new Board();
        Player player1 = new Player("X");
        board.putSignOnBoard(player1.getSign(), 7);
        board.putSignOnBoard(player1.getSign(), 8);
        assertEquals(9, computerPlayer.playMove(board, "X", "Y"));
    }
}
