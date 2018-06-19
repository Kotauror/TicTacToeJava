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
    private static Board board;
    private static HumanPlayer humanPlayerX;
    private static HumanPlayer humanPlayerO;
    private static ComputerPlayer computerPlayerX;
    private static ComputerPlayer computerPlayerO;


    @BeforeEach
    void instantiate() {
        board = new Board();
        humanPlayerX = new HumanPlayer("X");
        humanPlayerO = new HumanPlayer("O");
        computerPlayerX = new ComputerPlayer("X");
        computerPlayerO = new ComputerPlayer("O");
        game = new Game(new CommandLineUi(System.out, System.in), board, humanPlayerX, humanPlayerO);
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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board, humanPlayerX, humanPlayerO);

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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board, humanPlayerX, computerPlayerO);

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
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board, humanPlayerX, humanPlayerO);

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        String[] expectedArray = {"O", "X", "O", "X", "X", "O", "X", "O", "X"};
        assertArrayEquals(expectedArray, board.getPlaces());
        assertEquals("none", board.winnerSign());
    }

    @Test
    void playsATieGameOfTwoComputers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(outputStream), System.in);
        game = new Game(commandLineUi, board, computerPlayerX, computerPlayerO);

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        String[] expectedArray = {"X", "X", "O", "O", "O", "X", "X", "O", "X"};
        assertArrayEquals(expectedArray, board.getPlaces());
        assertEquals("none", board.winnerSign());
    }
}


