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
        game = new Game(new CommandLineUI(System.out, System.in), new Board(), new HumanPlayer("X"), new HumanPlayer("O"));
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
        assertEquals("O", game.getPassivePlayer().getSign());
    }

    @Test
    void playsAWinningGameOfTwoHumanPlayers() {
        String[] fakeUsersInputs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs), board, new HumanPlayer("X"), new HumanPlayer("O"));

        game.run();

        assertTrue(board.isWon());
        assertFalse(board.isTie());
        assertEquals("X", board.winnerSign());
        assertEquals("O", game.getActivePlayer().getSign());
        String[] expectedArray = {"X", "O", "X", "O", "X", "O", "X", "8", "9"};
        assertArrayEquals(expectedArray, board.getPlaces());
    }

    @Test
    void playsATieGameOfHumanAndComputer() {
        String[] fakeUsersInputs = {"1", "2", "7", "6", "9"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs), board, new HumanPlayer("X"), new ComputerPlayer("O"));

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        assertEquals("none", board.winnerSign());
        assertEquals("O", game.getActivePlayer().getSign());
        String[] expectedArray = {"X", "X", "O", "O", "O", "X", "X", "O", "X"};
        assertArrayEquals(expectedArray, board.getPlaces());
    }

    @Test
    void playsATieGameOfTwoHumanPlayers() {
        String[] fakeUsersInputs = {"2", "1", "4", "3", "5", "6", "7", "8", "9"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(new PrintStream(output), System.in, fakeUsersInputs), board, new HumanPlayer("X"), new HumanPlayer("O"));

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        String[] expectedArray = {"O", "X", "O", "X", "X", "O", "X", "O", "X"};
        assertArrayEquals(expectedArray, board.getPlaces());
        assertEquals("none", board.winnerSign());
    }
}


