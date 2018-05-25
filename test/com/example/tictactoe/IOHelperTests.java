package com.example.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class IOHelperTests {

    @Test
    public void returnsPositionGivenByPlayer() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("0", IOHelper.getUserInput());
    }

}
