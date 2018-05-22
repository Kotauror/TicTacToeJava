package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;



public class BoardTests {

    public Board board;

    @BeforeEach
    public void instantiateBoard() {
        board = new Board();
    }

    @Test
    public void BoardHasInitialIsGameWonStatusFalse() {
        assertEquals(board.won,false);
    }

    @Test
    public void BoardHasInitialIsTieStatusFalse() {
        assertEquals(board.tie,false);
    }

    @Test
    public void BoardHasInitialOverStatusFalse() { assertEquals(board.over,false); }

    @Test
    public void BoardIsCreatedWithPlacesArray() {
        assertThat(board.places,isA(ArrayList.class));
    }

    @Test
    public void BoardPlacesAreFillesWithNumbers() {
        board.fillPlaces();

        assertEquals(board.places.get(0),0);
        assertEquals(board.places.get(1),1);
        assertEquals(board.places.get(8),8);
    }

    @Test
    public void changesSignOnBoardToPlayerSign() {
        board.putSignOnBoard("X", 0);

        assertEquals("X", board.places.get(0));
    }

    @Test
    public void changesStatusOfBoardToWon() {

    }
}



