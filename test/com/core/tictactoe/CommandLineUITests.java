package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLineUITests {

    private CommandLineUI commandLineUI;
    private ByteArrayOutputStream output;
    private Board board;
    private Player player;
    private Player player2;


    @BeforeEach
    void setup() {
        this.output = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream("".getBytes());
        commandLineUI = new CommandLineUI(new PrintStream(this.output), input);
        player = new Player("X");
        player2 = new Player("Y");
        board = new Board();
    }

    @Test
    void greetsTheUsers() {
        commandLineUI.greetUsers();

        assertTrue(output.toString().contains("Hello and welcome to Tic-Tac-Toe"));
    }

    @Test
    void showsTheGamingMenu() {
        commandLineUI.gamingMenu();

        assertTrue(output.toString().contains("If you want to play type 1, if you want to exit type 2"));
    }

    @Test
    void showsTheBoard() {
        commandLineUI.showBoard(board);

        assertTrue(output.toString().contains("0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8"));
    }

    @Test
    void asksForPosition() {
        commandLineUI.askForPosition(player);

        assertTrue(output.toString().contains("X, pick a position\n"));
    }

    @Test
    void announcesWinnerWHenThereIsOne() {
        int[] array1 = {0, 1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        setUpBoard(player, player2, array1, array2);

        commandLineUI.announceWinner(board);

        assertTrue(output.toString().contains("X won!\n"));
    }

    @Test
    void announcesTieIfNoWInner() {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        setUpBoard(player, player2, array1, array2);

        commandLineUI.announceWinner(board);

        assertTrue(output.toString().contains("It's a tie!\n"));
    }

    @Test
    void returnsPositionGivenByPlayer() {
        InputStream input = new ByteArrayInputStream("0".getBytes());
        CommandLineUI commandLineUI = new CommandLineUI(new PrintStream(output), input);

        assertEquals("0", commandLineUI.getUserInput());
    }

    @Test
    void returnsPlayerPositionAsIntegerOnValidInput() {
        InputStream input = new ByteArrayInputStream("0".getBytes());
        CommandLineUI commandLineUI = new CommandLineUI(new PrintStream(output), input);

        assertEquals(0, commandLineUI.getPosition(board, player));
    }

    @Test
    void callsAgainForMoveOnInvalidInput() {
        String[] fakeUsersInputs = {"10", "5"};
        StubbCommandLineUI fakeCommandLineUI = new StubbCommandLineUI(System.out, System.in, fakeUsersInputs);

        Object userPosition = fakeCommandLineUI.getPosition(new Board(), new Player("X"));

        assertTrue(userPosition.toString().contains("5"));
    }

    private void setUpBoard(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for (int anArraySign1 : arraySign1) {
            board.putSignOnBoard(player, anArraySign1);
        }
        for (int anArraySign2 : arraySign2) {
            board.putSignOnBoard(player2, anArraySign2);
        }
    }

}
