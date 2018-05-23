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
    public void returnsPositionGivenByPlayerWhenValid() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(0, displayer.getPosition(board, validator));
    }

    @Test
    public void returnsOnlyTheCorrectValuesWhenGettingAPosition1() throws IOException {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "J";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String inputTwo = "0";
        InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
        System.setIn(inTwo);

        assertEquals(0, displayer.getPosition(board, validator));
    }

    @Test
    public void returnsOnlyTheCorrectValuesWhenGettingAPosition2() throws IOException {
        board.putSignOnBoard("X", 0);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String inputTwo = "1";
        InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
        System.setIn(inTwo);

        assertEquals(1, displayer.getPosition(board, validator));
    }

    @Test
    public void returnsOnlyTheCorrectValuesWhenGettingAPosition3() throws IOException {
        try {
            board.putSignOnBoard("X", 0);
            String input = "0";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            displayer.getPosition(board, validator);

            final ByteArrayOutputStream outContentTwo = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContentTwo));

            assertEquals("Pick a non-taken number on board", outContentTwo.toString());
        } finally {
            String inputTwo = "1";
            InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
            System.setIn(inTwo);
        }

    }

}
