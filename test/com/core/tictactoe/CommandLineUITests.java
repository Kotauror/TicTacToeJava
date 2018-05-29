package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CommandLineUITests {

    public CommandLineUI commandLineUI;
    private ByteArrayOutputStream output;
    public Board board;
    public Player player;
    public Player player2;


    @BeforeEach
    public void setup() {
        this.output = new ByteArrayOutputStream();
        commandLineUI = new CommandLineUI(new PrintStream(output));
        player = new Player("X");
        player2 = new Player("Y");
        board = new Board();
    }

    @Test
    public void greetsTheUsers() {
        commandLineUI.greetUsers();

        assertTrue(output.toString().contains("Hello and welcome to Tic-Tac-Toe"));
    }

    @Test
    public void showsTheGamingMenu() {
        commandLineUI.gamingMenu();

        assertTrue(output.toString().contains("If you want to play type 1, if you want to exit type 2"));
    }

    @Test
    public void showsTheBoard() {
        commandLineUI.showBoard(board);

        assertTrue(output.toString().contains("0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8"));
    }

    @Test
    public void asksForPosition() {
        commandLineUI.askForPosition(player);

        assertTrue(output.toString().contains("X, pick a position\n"));
    }

    @Test
    public void announcesWinnerWHenThereIsOne() {
        int[] array1 = {0, 1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        playWholeGame(player, player2, array1, array2);

        commandLineUI.announceWinner(board);

        assertTrue(output.toString().contains("X won!\n"));
    }

    @Test
    public void announcesTieIfNoWInner() {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        playWholeGame(player, player2, array1, array2);

        commandLineUI.announceWinner(board);

        assertTrue(output.toString().contains("It's a tie!\n"));
    }

    @Test
    public void returnsTrueWhenMoveIsNumeric() {
        assertTrue(commandLineUI.isNumeric("2"));
    }

    @Test
    public void returnsFalseWhenMoveIsNotNumeric() {
        assertFalse(commandLineUI.isNumeric("J"));
    }

    @Test
    public void returnsPositionGivenByPlayer() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("0", commandLineUI.getUserInput());
    }

    @Test
    public void returnsPlayerPositionAsIntegerOnValidInput() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(0, commandLineUI.getPosition(board, player));
    }

    @Test
    public void callsAgainForMoveOnInvalidInput() throws IOException {
        CommandLineUI spy = Mockito.spy(commandLineUI);
        Mockito.doReturn("10").doReturn("5").when(spy).getUserInput();
        spy.getPosition(board, player);

        verify(spy, times(2)).askForPosition(player);
    }

    public void playWholeGame(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            board.putSignOnBoard(player, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            board.putSignOnBoard(player2, arraySign2[i]);
        }
    }

}
