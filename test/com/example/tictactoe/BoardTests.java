package com.example.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BoardTests {

    public Board board;

    @Test
    public void Board_has_an_initial_status_false() {
        board = new Board();
        assertEquals(board.finished,false);
    }
}




