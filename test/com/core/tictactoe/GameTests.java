package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    private static Game game;

    @BeforeEach
    void instantiate() {
        game = new Game(new CommandLineUI(System.out, System.in), new Board(), new Player("X"), new Player("Y"));
    }

    @Test
    public void returnsBoard() {
        assertThat(game.getBoard(), instanceOf(Board.class));
    }
    @Test
    public void returnsActivePlayer() {
        assertEquals("X", game.getActivePlayer().getSign());
    }

    @Test
    public void returnsPassivePlayer() {
        assertEquals("Y", game.getPassivePlayer().getSign());
    }

    @Test
    void playsAWinningGame() {
        String[] fakeUsersInputs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs), board, new HumanPlayer("X"), new HumanPlayer("Y"));

        game.run();

        assertTrue(board.isWon());
        assertFalse(board.isTie());
        assertEquals("X", board.winnerSign());
        assertEquals("Y", game.getActivePlayer().getSign());
        String[] expectedArray = {"X", "Y", "X", "Y", "X", "Y", "X", "8", "9"};
        assertArrayEquals(expectedArray, board.getPlaces());
    }

    @Test
    void playsATieGame() {
        String[] fakeUsersInputs = {"2", "1", "4", "3", "5", "6", "7", "8", "9"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs), board, new HumanPlayer("X"), new HumanPlayer("Y"));

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        String[] expectedArray = {"Y", "X", "Y", "X", "X", "Y", "X", "Y", "X"};
        assertArrayEquals(expectedArray, board.getPlaces());
        assertEquals("none", board.winnerSign());
    }
}


