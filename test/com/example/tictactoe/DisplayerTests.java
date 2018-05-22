package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayerTests {

    public Displayer displayer;

    @BeforeEach
    public void instantiateBoard() {
        displayer = new Displayer();
    }

    @Test
    public void greetsTheUsers() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        displayer.greetUsers();
        assertEquals("Hello and welcome to Tic-Tac-Toe\n", outContent.toString());
}
}
