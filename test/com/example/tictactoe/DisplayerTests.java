package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayerTests {

    public Displayer displayer;

    @BeforeEach
    public void instantiate() {
        displayer = new Displayer();
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
        ArrayList board = new ArrayList();
        Collections.addAll(board, 0, 1, 2, 3, "X", 5, 6, 7, 8);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.showBoard(board);

        assertEquals("\n0 | 1 | 2\n3 | X | 5\n6 | 7 | 8\n\n", outContent.toString());
    }

    @Test
    public void asksForPosition() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.askForPosition("X");

        assertEquals("X, pick a position\n", outContent.toString());

    }

    @Test
    public void asksAgainForPosition() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.askAgainForPosition("X");

        assertEquals("X, pick a non-taken number on board\n", outContent.toString());

    }

    @Test
    public void announcesWinnerWHenThereIsOne() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.announceWinner("X");

        assertEquals("X won!\n", outContent.toString());

    }

    @Test
    public void announcesTieIfNoWInner() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.announceWinner(null);

        assertEquals("It's a tie!\n", outContent.toString());

    }

    @Test
    public void askForPlayingAgain() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.playAgainMenu();

        assertEquals("If you want to play again type 1, if you want to exit type 2\n", outContent.toString());

    }

}
