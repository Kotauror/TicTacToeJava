package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayerTests {

    public Displayer displayer;
    public Board board;
    public Validator validator;

    @BeforeEach
    public void instantiate() {
        displayer = new Displayer();
        board = new Board();
        validator = new Validator();
        Collections.addAll(board.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
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
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.showBoard(board.places);

        assertEquals("0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n", outContent.toString());
    }

    @Test
    public void asksForPosition() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.askForPosition();

        assertEquals("Pick a position\n", outContent.toString());

    }

    @Test
    public void asksAgainForPosition() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.askAgainForPosition();

        assertEquals("Pick a non-taken number on board\n", outContent.toString());

    }

}
