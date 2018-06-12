package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommandLineUiTests {

    private CommandLineUi commandLineUi;
    private ByteArrayOutputStream output;
    private Board board;
    private Player player;
    private Player player2;
    private ComputerPlayer player3;

    @BeforeEach
    void setup() {
        this.output = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream("".getBytes());
        commandLineUi = new CommandLineUi(new PrintStream(this.output), input);
        player = new HumanPlayer("X");
        player2 = new HumanPlayer("O");
        player3 = new ComputerPlayer("O");
        board = new Board();
    }

    @Test
    void greetsTheUsers() {
        commandLineUi.greetUsers();

        assertTrue(output.toString().contains("Hello and welcome to Tic-Tac-Toe"));
    }

    @Test
    void twoLevelMenuReturns1InFirstMenu() {
        InputStream input = new ByteArrayInputStream("1".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), input);

        assertEquals("1", commandLineUi.twoLevelMenu());
    }

    @Test
    void twoLevelMenuReturnsEInFirstMenu() {
        InputStream input = new ByteArrayInputStream("E".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), input);

        assertEquals("E", commandLineUi.twoLevelMenu());
    }

    @Test
    void secondLevelMenuReturnsValidInput() {
        InputStream input = new ByteArrayInputStream("C".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), input);

        assertEquals("C", commandLineUi.secondLevelMenu());
    }

    @Test
    void informsOfMoveOfHumanPlayer() {
        commandLineUi.informOfMove(player, 2);

        assertTrue(output.toString().contains("Player X picked position: 2"));
    }

    @Test
    void informsOfMoveOfComputerPlayer() {
        commandLineUi.informOfMove(player3, 2);

        assertTrue(output.toString().contains("Computer O picked position: 2"));
    }

    @Test
    void showsTheBoard() {
        commandLineUi.showBoard(board);

        assertTrue(output.toString().contains("1 | 2 | 3\n4 | 5 | 6\n7 | 8 | 9"));
    }

    @Test
    void asksForPosition() {
        commandLineUi.askForPosition(player.getSign());

        assertTrue(output.toString().contains("X, pick a position\n"));
    }

    @Test
    void announcesWinnerWHenThereIsOne() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9};
        setUpBoard(player, player2, array1, array2);

        commandLineUi.announceWinner(board);

        assertTrue(output.toString().contains("X won!\n"));
    }

    @Test
    void announcesTieIfNoWInner() {
        int[] array1 = {2, 4, 5, 7, 9};
        int[] array2 = {1, 3, 6, 8};
        setUpBoard(player, player2, array1, array2);

        commandLineUi.announceWinner(board);

        assertTrue(output.toString().contains("It's a tie!\n"));
    }

    @Test
    void returnsPositionGivenByPlayer() {
        InputStream input = new ByteArrayInputStream("0".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), input);

        assertEquals("0", commandLineUi.getUserInput());
    }

    @Test
    void returnsPlayerPositionAsIntegerOnValidInput() {
        InputStream input = new ByteArrayInputStream("1".getBytes());
        CommandLineUi commandLineUi = new CommandLineUi(new PrintStream(output), input);

        assertEquals(1, commandLineUi.getPositionFromUser(board, player.getSign()));
    }

    @Test
    void callsAgainForMoveOnInvalidInput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String[] fakeUsersInputs = {"10", "5"};
        StubCommandLineUi fakeCommandLineUI = new StubCommandLineUi(new PrintStream(output), System.in, fakeUsersInputs);

        Object userPosition = fakeCommandLineUI.getPositionFromUser(new Board(),"X");

        assertTrue(userPosition.toString().contains("5"));
    }

    private void setUpBoard(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for (int anArraySign1 : arraySign1) {
            board.putSignOnBoard(player.getSign(), anArraySign1);
        }
        for (int anArraySign2 : arraySign2) {
            board.putSignOnBoard(player2.getSign(), anArraySign2);
        }
    }
}
