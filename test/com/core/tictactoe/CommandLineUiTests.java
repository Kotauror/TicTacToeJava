package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommandLineUiTests {

    private CommandLineUi commandLineUi;
    private ByteArrayOutputStream output;
    private Board board;
    private Player humanPlayerX;
    private Player humanPlayerO;
    private ComputerPlayer computerPlayerO;

    @BeforeEach
    void setup() {
        this.output = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
        commandLineUi = new CommandLineUi(new PrintStream(this.output), inputStream);
        humanPlayerX = new HumanPlayer("X");
        humanPlayerO = new HumanPlayer("O");
        computerPlayerO = new ComputerPlayer("O");
        board = new Board();
    }

    @Test
    void greetsTheUsers() {
        commandLineUi.greetUsers();

        assertTrue(output.toString().contains("Hello and welcome to Tic-Tac-Toe"));
    }

    @Test
    void mainMenuReturns1InFirstMenu() {
        InputStream inputStream = new ByteArrayInputStream("1".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), inputStream);

        assertEquals("1", commandLineUi.mainMenu());
    }

    @Test
    void mainMenuReturnsEInFirstMenu() {
        InputStream inputStream = new ByteArrayInputStream("E".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), inputStream);

        assertEquals("E", commandLineUi.mainMenu());
    }

    @Test
    void mainMenuRegexIsCaseInsensitive() {
        InputStream inputStream = new ByteArrayInputStream("e".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), inputStream);

        assertEquals("E", commandLineUi.mainMenu());
    }

    @Test
    void twoLevelMenuReturnsWhoGoesFirstAtSecondLevel() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String[] fakeUsersInputs = {"2", "H"};
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);

        Object userOption = stubCommandLineUi.mainMenu();

        assertTrue(userOption.toString().contains("2H"));
    }

    @Test
    void twoLevelMenuAsksAgainOnInvalidInputOnFirstLevel() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String[] fakeUsersInputs = {"10", "2", "B", "C"};
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);

        Object userOption = stubCommandLineUi.mainMenu();

        assertTrue(userOption.toString().contains("2C"));
    }

    @Test
    void twoLevelMenuAsksAgainOnInvalidInputOnSecondLevel() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String[] fakeUsersInputs = {"10", "1"};
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);

        Object userOption = stubCommandLineUi.mainMenu();

        assertTrue(userOption.toString().contains("1"));
    }

    @Test
    void informsOfMoveOfHumanPlayer() {
        commandLineUi.informOfMove(humanPlayerX, 2);

        assertTrue(output.toString().contains("Player X picked position: 2"));
    }

    @Test
    void informsOfMoveOfComputerPlayer() {
        commandLineUi.informOfMove(computerPlayerO, 2);

        assertTrue(output.toString().contains("Computer O picked position: 2"));
    }

    @Test
    void showsTheBoard() {
        commandLineUi.showBoard(board);

        assertTrue(output.toString().contains("1 | 2 | 3\n4 | 5 | 6\n7 | 8 | 9"));
    }

    @Test
    void asksForPosition() {
        commandLineUi.askForPosition(humanPlayerX.getSign());

        assertTrue(output.toString().contains("X, pick a position\n"));
    }

    @Test
    void announcesWinnerWHenThereIsOne() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9};
        setUpBoard(humanPlayerX, humanPlayerO, array1, array2);

        commandLineUi.announceWinner(board);

        assertTrue(output.toString().contains("X won!\n"));
    }

    @Test
    void announcesTieIfNoWInner() {
        int[] array1 = {2, 4, 5, 7, 9};
        int[] array2 = {1, 3, 6, 8};
        setUpBoard(humanPlayerX, humanPlayerO, array1, array2);

        commandLineUi.announceWinner(board);

        assertTrue(output.toString().contains("It's a tie!\n"));
    }

    @Test
    void returnsPositionGivenByPlayer() {
        InputStream inputStream = new ByteArrayInputStream("0".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), inputStream);

        assertEquals("0", commandLineUi.getUserInput());
    }

    @Test
    void returnsPlayerPositionAsIntegerOnValidInput() {
        InputStream inputStream = new ByteArrayInputStream("1".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), inputStream);

        assertEquals(1, commandLineUi.getPositionFromUser(board, humanPlayerX.getSign()));
    }

    @Test
    void callsAgainForMoveOnInvalidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String[] fakeUsersInputs = {"10", "5"};
        StubCommandLineUi stubCommandLineUi = new StubCommandLineUi(new PrintStream(outputStream), System.in, fakeUsersInputs);

        Object userPosition = stubCommandLineUi.getPositionFromUser(new Board(),"X");

        assertTrue(userPosition.toString().contains("5"));
    }

    private void setUpBoard(Player player, Player player2, int[] placesOfPlayer1, int[] placesOfPlayer2) {
        for (int place : placesOfPlayer1) {
            board.putSignOnBoard(player.getSign(), place);

        }
        for (int place : placesOfPlayer2) {
            board.putSignOnBoard(player2.getSign(), place);
        }
    }
}
