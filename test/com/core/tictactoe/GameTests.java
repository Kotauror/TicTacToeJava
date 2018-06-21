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
    private static Board board4x4;
    private static Board board3x3;
    private static Board board2x2;
    private static HumanPlayer humanPlayerX;
    private static HumanPlayer humanPlayerO;
    private static ComputerPlayer computerPlayerX;
    private static ComputerPlayer computerPlayerO;


    @BeforeEach
    void instantiate() {
        board4x4 = new Board(4);
        board3x3 = new Board(3);
        board2x2 = new Board(2);
        humanPlayerX = new HumanPlayer("X");
        humanPlayerO = new HumanPlayer("O");
        computerPlayerX = new ComputerPlayer("X");
        computerPlayerO = new ComputerPlayer("O");
        game = new Game(new CommandLineUi(System.out, System.in), board3x3, humanPlayerX, humanPlayerO);
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
    void playsAWinningGameOfTwoHumanPlayersOnBoard3x3() {
        String[] fakeUsersInputs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board3x3, humanPlayerX, humanPlayerO);

        game.run();

        assertTrue(board3x3.isWon());
        assertFalse(board3x3.isTie());
        assertEquals("X", board3x3.winnerSign());
        assertEquals("O", game.getActivePlayer().getSign());
        String[] expectedArray = {"X", "O", "X", "O", "X", "O", "X", "8", "9"};
        assertArrayEquals(expectedArray, board3x3.getPlaces());
    }

    @Test
    void playsATieGameOfHumanAndComputerOnBoard3x3() {
        String[] fakeUsersInputs = {"1", "2", "7", "6", "9"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board3x3, humanPlayerX, computerPlayerO);

        game.run();

        assertFalse(board3x3.isWon());
        assertTrue(board3x3.isTie());
        assertEquals("none", board3x3.winnerSign());
        assertEquals("O", game.getActivePlayer().getSign());
        String[] expectedArray = {"X", "X", "O", "O", "O", "X", "X", "O", "X"};
        assertArrayEquals(expectedArray, board3x3.getPlaces());
    }

    @Test
    void playsATieGameOfTwoHumanPlayersOnBoard3x3() {
        String[] fakeUsersInputs = {"2", "1", "4", "3", "5", "6", "7", "8", "9"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board3x3, humanPlayerX, humanPlayerO);

        game.run();

        assertFalse(board3x3.isWon());
        assertTrue(board3x3.isTie());
        String[] expectedArray = {"O", "X", "O", "X", "X", "O", "X", "O", "X"};
        assertArrayEquals(expectedArray, board3x3.getPlaces());
        assertEquals("none", board3x3.winnerSign());
    }

    @Test
    void playsATieGameOfTwoComputersOnBoard3x3() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(outputStream), System.in);
        game = new Game(commandLineUi, board3x3, computerPlayerX, computerPlayerO);

        game.run();

        assertFalse(board3x3.isWon());
        assertTrue(board3x3.isTie());
        String[] expectedArray = {"X", "X", "O", "O", "O", "X", "X", "O", "X"};
        assertArrayEquals(expectedArray, board3x3.getPlaces());
        assertEquals("none", board3x3.winnerSign());
    }

    @Test
    void playsAWinGameOfTwoComputersOn2x2Board() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(outputStream), System.in);
        game = new Game(commandLineUi, board2x2, computerPlayerX, computerPlayerO);

        game.run();

        assertTrue(board2x2.isWon());
        assertFalse(board2x2.isTie());
        String[] expectedArray = {"X", "O", "X", "4"};
        assertArrayEquals(expectedArray, board2x2.getPlaces());
        assertEquals("X", board2x2.winnerSign());
    }

    @Test
    void playsAWinningGameOfTwoHumanPlayersOnBoard4x4() {
        String[] fakeUsersInputs = {"1", "5", "2", "6", "3", "7", "4", "8"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        game = new Game(stubCommandLineUi, board4x4, humanPlayerX, humanPlayerO);

        game.run();

        assertTrue(board4x4.isWon());
        assertFalse(board4x4.isTie());
        assertEquals("X", board4x4.winnerSign());
        assertEquals("O", game.getActivePlayer().getSign());
        String[] expectedArray = {"X", "X", "X", "X", "O", "O", "O", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        assertArrayEquals(expectedArray, board4x4.getPlaces());
    }
}


