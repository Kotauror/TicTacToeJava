package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandLineUITests {
    public CommandLineUI commandLineUI;
    public Board board;
    public Player player;
    public Player player2;

    @BeforeEach
    public void createInstance() {
        commandLineUI = new CommandLineUI();
        board = new Board();
        player = new Player("X");
        player2 = new Player("Y");

    }

    @Test
    public void greetsTheUsers() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        commandLineUI.greetUsers();

        assertEquals("Hello and welcome to Tic-Tac-Toe\n", outContent.toString());
    }

    @Test
    public void showsTheBoard() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        commandLineUI.showBoard(board);

        assertEquals("\n0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n\n", outContent.toString());
    }

    @Test
    public void asksForPosition() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        commandLineUI.askForPosition(player);

        assertEquals("X, pick a position\n", outContent.toString());
    }

    @Test
    public void announcesWinnerWHenThereIsOne() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int[] array1 = {0, 1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        playWholeGame(player, player2, array1, array2);

        commandLineUI.announceWinner(board);

        assertEquals("X won!\n", outContent.toString());
    }

    @Test
    public void announcesTieIfNoWInner() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        playWholeGame(player, player2, array1, array2);

        commandLineUI.announceWinner(board);

        assertEquals("It's a tie!\n", outContent.toString());
    }

    public void playWholeGame(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            board.putSignOnBoard(player, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            board.putSignOnBoard(player2, arraySign2[i]);
        }
    }

    @Test
    public void returnsPositionGivenByPlayer() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("0", commandLineUI.getUserInput());
    }

    @Test
    public void returnsTrueWhenMoveIsValid() {
        assertTrue(commandLineUI.isNumeric("2"));
    }

    @Test
    public void returnsFalseWhenMoveIsNotValid() {
        assertFalse(commandLineUI.isNumeric("J"));
    }

    @Test
    public void checkPlayAgainMenuTrue() {
        assertTrue(commandLineUI.playAgainValid("1"));
    }

    @Test
    public void checkPlayAgainMenuFalse() {
        assertFalse(commandLineUI.playAgainValid("3"));
    }

    @Test
    public void checkExitTrue() {
        assertTrue(commandLineUI.exitValid("2"));
    }

    @Test
    public void checkExitFalse() {
        assertFalse(commandLineUI.exitValid("3"));
    }
}
