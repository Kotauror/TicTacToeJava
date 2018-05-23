package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;



public class BoardTests {

    public Board board;

    @BeforeEach
    public void instantiateBoard() {
        board = new Board();
    }

    @Test
    public void BoardHasInitialIsGameWonStatusFalse() {
        assertEquals(false, board.won);
    }

    @Test
    public void BoardHasInitialIsTieStatusFalse() { assertEquals(false, board.tie); }

    @Test
    public void BoardHasInitialWinnerSignN() { assertEquals("N", board.winnerSign); }

    @Test
    public void BoardHasInitialOverStatusTrue() { assertEquals(true,board.placesLeft); }

    @Test
    public void BoardIsCreatedWithPlacesArray() {
        assertThat(board.places,isA(ArrayList.class));
    }

    @Test
    public void BoardPlacesAreFillesWithNumbers() {
        board.fillPlaces();

        for(int i = 0; i < 9; i++) {
            assertEquals(board.places.get(i),i);
        }
    }

    @Test
    public void changesSignOnBoardToPlayerSign() {
        board.putSignOnBoard("X", 0);

        assertEquals("X", board.places.get(0));
    }

    @Test
    public void checksIfThereArePlacesLeftTrue() {
        board.putSignOnBoard("X", 0);

        board.checkForPlacesLeft();

        assertTrue(board.placesLeft);
    }

    @Test
    public void checksIfThereArePlacesLeftFalse() {
        for(int i = 0; i < 9; i++) {
            board.putSignOnBoard("X", i);
        }

        board.checkForPlacesLeft();

        assertFalse(board.placesLeft);
    }

    @Test
    public void checkIfGameIsWonFalse() {
        board.putSignOnBoard("X", 0);
        board.putSignOnBoard("X", 5);
        board.putSignOnBoard("X", 2);

        board.checkForWon();

        assertFalse(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV1() {
        board.putSignOnBoard("X", 0);
        board.putSignOnBoard("X", 1);
        board.putSignOnBoard("X", 2);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV2() {
        board.putSignOnBoard("X", 3);
        board.putSignOnBoard("X", 4);
        board.putSignOnBoard("X", 5);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV3() {
        board.putSignOnBoard("X", 6);
        board.putSignOnBoard("X", 7);
        board.putSignOnBoard("X", 8);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV4() {
        board.putSignOnBoard("X", 0);
        board.putSignOnBoard("X", 3);
        board.putSignOnBoard("X", 6);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV5() {
        board.putSignOnBoard("X", 1);
        board.putSignOnBoard("X", 4);
        board.putSignOnBoard("X", 7);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV6() {
        board.putSignOnBoard("X", 2);
        board.putSignOnBoard("X", 5);
        board.putSignOnBoard("X", 8);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV7() {
        board.putSignOnBoard("X", 0);
        board.putSignOnBoard("X", 4);
        board.putSignOnBoard("X", 8);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void checkIfGameIsWonTrueV8() {
        board.putSignOnBoard("X", 2);
        board.putSignOnBoard("X", 4);
        board.putSignOnBoard("X", 6);

        board.checkForWon();

        assertTrue(board.won);
    }

    @Test
    public void changeWinnerSignWhenWon() {
        board.putSignOnBoard("X", 2);
        board.putSignOnBoard("X", 4);
        board.putSignOnBoard("X", 6);

        board.checkForWon();

        assertEquals("X", board.winnerSign);
    }

    @Test
    public void returnsTrueWhenMoveIsValid() {
        board.putSignOnBoard("X", 6);

        assertTrue(board.isAValidInteger("2"));
    }

    @Test
    public void returnsFalseWhenMoveIsNotValid() {
        board.putSignOnBoard("X", 6);

        assertFalse(board.isAValidInteger("J"));
    }

    @Test
    public void returnTrueWHenPositionIsNonTaken() {
        board.putSignOnBoard("X", 6);

        assertTrue(board.isANontakenPosition("2"));
    }

    @Test
    public void returnFalseWHenPositionIsTaken() {
        board.putSignOnBoard("X", 6);

        assertFalse(board.isANontakenPosition("6"));
    }
}



