package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CommandLineGameTests {

    private static CommandLineGame commandLineGame;
    private static CommandLineUi commandLineUi;
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
        humanPlayerX = new HumanPlayer("X", commandLineUi);
        humanPlayerO = new HumanPlayer("O", commandLineUi);
        computerPlayerX = new ComputerPlayer("X");
        computerPlayerO = new ComputerPlayer("O");
        commandLineUi = new CommandLineUi(System.out, System.in);
        commandLineGame = new CommandLineGame(new CommandLineUi(System.out, System.in), board3x3, humanPlayerX, humanPlayerO);
    }

    @Test
    public void returnsBoard() {
        assertThat(commandLineGame.getBoard(), instanceOf(Board.class));
    }

    @Test
    public void returnsActivePlayer() {
        assertEquals("X", commandLineGame.getActivePlayer().getSign());
    }

    @Test
    public void returnsPassivePlayer() {
        assertEquals("O", commandLineGame.getPassivePlayer().getSign());
    }

    @Test
    void playsAWinningGameOfTwoHumanPlayersOnBoard3x3() {
        String[] fakeUsersInputsPlayerOne = {"1", "3", "5", "7", "9"};
        String[] fakeUsersInputsPlayerTwo = {"2", "4", "6", "8"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUiPlayerOne = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputsPlayerOne);
        StubCommandLineUi stubCommandLineUiPlayerTwo = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputsPlayerTwo);
        humanPlayerX = new HumanPlayer("X", stubCommandLineUiPlayerOne);
        humanPlayerO = new HumanPlayer("O", stubCommandLineUiPlayerTwo);
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(outputStream), System.in);
        commandLineGame = new CommandLineGame(commandLineUi, board3x3, humanPlayerX, humanPlayerO);

        commandLineGame.run();

        assertTrue(board3x3.isWon());
        assertFalse(board3x3.isTie());
        assertEquals("X", board3x3.winnerSign());
        assertEquals("O", commandLineGame.getActivePlayer().getSign());
        String[] expectedArray = {"X", "O", "X", "O", "X", "O", "X", "8", "9"};
        assertArrayEquals(expectedArray, board3x3.getPlaces());
    }

    @Test
    void playsATieGameOfHumanAndComputerOnBoard3x3() {
        String[] fakeUsersInputs = {"1", "2", "7", "6", "9"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);
        humanPlayerX = new HumanPlayer("X", stubCommandLineUi);
        commandLineGame = new CommandLineGame(stubCommandLineUi, board3x3, humanPlayerX, computerPlayerO);

        commandLineGame.run();

        assertFalse(board3x3.isWon());
        assertTrue(board3x3.isTie());
        assertEquals("none", board3x3.winnerSign());
        assertEquals("O", commandLineGame.getActivePlayer().getSign());
        String[] expectedArray = {"X", "X", "O", "O", "O", "X", "X", "O", "X"};
        assertArrayEquals(expectedArray, board3x3.getPlaces());
    }

    @Test
    void playsATieGameOfTwoHumanPlayersOnBoard3x3() {
        String[] fakeUsersInputsPlayerOne = {"2", "4", "5", "7", "9"};
        String[] fakeUsersInputsPlayerTwo = {"1", "3", "6", "8"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUiPlayerOne = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputsPlayerOne);
        StubCommandLineUi stubCommandLineUiPlayerTwo = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputsPlayerTwo);
        humanPlayerX = new HumanPlayer("X", stubCommandLineUiPlayerOne);
        humanPlayerO = new HumanPlayer("O", stubCommandLineUiPlayerTwo);
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(outputStream), System.in);
        commandLineGame = new CommandLineGame(commandLineUi, board3x3, humanPlayerX, humanPlayerO);

        commandLineGame.run();

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
        commandLineGame = new CommandLineGame(commandLineUi, board3x3, computerPlayerX, computerPlayerO);

        commandLineGame.run();

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
        commandLineGame = new CommandLineGame(commandLineUi, board2x2, computerPlayerX, computerPlayerO);

        commandLineGame.run();

        assertTrue(board2x2.isWon());
        assertFalse(board2x2.isTie());
        String[] expectedArray = {"X", "O", "X", "4"};
        assertArrayEquals(expectedArray, board2x2.getPlaces());
        assertEquals("X", board2x2.winnerSign());
    }

    @Test
    void playsAWinningGameOfTwoHumanPlayersOnBoard4x4() {
        String[] fakeUsersInputsPlayerOne = {"1", "2", "3", "4"};
        String[] fakeUsersInputsPlayerTwo = {"5", "6", "7", "8"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StubCommandLineUi stubCommandLineUiPlayerOne = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputsPlayerOne);
        StubCommandLineUi stubCommandLineUiPlayerTwo = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputsPlayerTwo);
        humanPlayerX = new HumanPlayer("X", stubCommandLineUiPlayerOne);
        humanPlayerO = new HumanPlayer("O", stubCommandLineUiPlayerTwo);
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(outputStream), System.in);
        commandLineGame = new CommandLineGame(commandLineUi, board4x4, humanPlayerX, humanPlayerO);

        commandLineGame.run();

        assertTrue(board4x4.isWon());
        assertFalse(board4x4.isTie());
        assertEquals("X", board4x4.winnerSign());
        assertEquals("O", commandLineGame.getActivePlayer().getSign());
        String[] expectedArray = {"X", "X", "X", "X", "O", "O", "O", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        assertArrayEquals(expectedArray, board4x4.getPlaces());
    }
}
