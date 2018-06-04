package com.core.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    private static Game game;

    @Test
    void playsAWinningGame() {
        String[] fakeUsersInputs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs), board);

        game.run();

        assertTrue(board.isWon());
        assertFalse(board.isTie());
        assertEquals("X", board.winnerSign());
        assertEquals("Y", game.active.getSign());
        String[] expectedArray = {"X", "Y", "X", "Y", "X", "Y", "X", "8", "9"};
        assertArrayEquals(expectedArray, board.getPlaces());
    }

    @Test
    void playsATieGame() {
        String[] fakeUsersInputs = {"2", "1", "4", "3", "5", "6", "7", "8", "9"};
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs), board);

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        String[] expectedArray = {"Y", "X", "Y", "X", "X", "Y", "X", "Y", "X"};
        assertArrayEquals(expectedArray, board.getPlaces());
        assertEquals("none", board.winnerSign());
    }
}


