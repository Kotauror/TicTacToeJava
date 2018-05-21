package com.example.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import org.junit.jupiter.api.*;



public class BoardTests {

    public Board board;

    @BeforeEach
    public void instantiateBoard() {
    }

    @Test
    public void Board_has_an_initial_status_false() {
        board = new Board();
        assertEquals(board.finished,false);
    }

    @Test
    public void Board_is_created_with_places_ArrayList() {
        board = new Board();
        assertThat(board.places,isA(ArrayList.class));
    }

    @Test
    public void Boards_places_are_filled_with_numbers() {
        board = new Board();
        board.fillPlaces();
        assertEquals(board.places.get(0),0);
        assertEquals(board.places.get(1),1);
        assertEquals(board.places.get(8),8);
    }
}



