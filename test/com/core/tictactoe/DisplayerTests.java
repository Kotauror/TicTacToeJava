package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayerTests {

    public Displayer displayer;
    public Board board;
    public Player player;
    public Player player2;

    @BeforeEach
    public void createInstance() {
        displayer = new Displayer();
        board = new Board();
        player = new Player("X");
        player2 = new Player("Y");

    }


    @Test
    public void greetsTheUsers() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.greetUsers();

        assertEquals("Hello and welcome to Tic-Tac-Toe\n", outContent.toString());
    }

    @Test
    public void showsTheBoard() {
        // ArrayList board = new ArrayList();
        // Collections.addAll(board, 0, 1, 2, 3, "X", 5, 6, 7, 8);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.showBoard(board);

        assertEquals("\n0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n\n", outContent.toString());
    }

    @Test
    public void asksForPosition() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.askForPosition(player);

        assertEquals("X, pick a position\n", outContent.toString());
    }

//    @Test
//    public void asksAgainForPosition() {
//        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        displayer.askAgainForPosition(player);
//
//        assertEquals("X, pick a non-taken number on board\n", outContent.toString());
//    }

    @Test
    public void announcesWinnerWHenThereIsOne() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int[] array1 = {0, 1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        playWholeGame(player, player2, array1, array2);

        displayer.announceWinner(board);

        assertEquals("X won!\n", outContent.toString());
    }

    @Test
    public void announcesTieIfNoWInner() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        playWholeGame(player, player2, array1, array2);

        displayer.announceWinner(board);

        assertEquals("It's a tie!\n", outContent.toString());
    }

//    @Test
//    public void askForPlayingAgain() {
//        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        displayer.gamingMenu();
//
//        assertEquals("If you want to play type 1, if you want to exit type 2\n", outContent.toString());
//    }

    public void playWholeGame(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            board.putSignOnBoard(player, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            board.putSignOnBoard(player2, arraySign2[i]);
        }
    }

}
