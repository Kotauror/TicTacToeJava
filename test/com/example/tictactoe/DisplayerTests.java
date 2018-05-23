package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayerTests {

    public Displayer displayer;

    @BeforeEach
    public void instantiateBoard() { displayer = new Displayer(); }

    @Test
    public void greetsTheUsers() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.greetUsers();

        assertEquals("Hello and welcome to Tic-Tac-Toe\n", outContent.toString());
    }

    @Test
    public void showsTheBoard() {
        ArrayList board = new ArrayList<Integer>();
        Collections.addAll(board, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        displayer.showBoard(board);

        assertEquals("0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n", outContent.toString());
    }

    @Test
    public void returnsPositionGivenByPlayerWhenValid() throws IOException {
        Board board = new Board();
        Collections.addAll(board.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        Validator validator = new Validator();
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(0, displayer.getPosition(board, validator));
    }

    @Test
    public void returnsOnlyTheCorrectValuesWhenGettingAPosition1() throws IOException {
        Board board = new Board();
        Collections.addAll(board.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        Validator validator = new Validator();
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
        Board board = new Board();
        Collections.addAll(board.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        board.putSignOnBoard("X", 0);
        Validator validator = new Validator();
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



}
