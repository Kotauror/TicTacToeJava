package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;



public class BoardTests {

    public Board board;

    @BeforeEach
    public void instantiateBoard() {
        board = new Board();
    }

    //@Test
    //public void BoardHasInitialWinnerSignN() {
     //   assertNull(board.winnerSign);
   // }

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

        assertEquals(true, board.hasFreePlaces());
    }

    @Test
    public void checksIfThereArePlacesLeftFalse() {
        for(int i = 0; i < 9; i++) {
            board.putSignOnBoard("X", i);
        }

        assertFalse(board.hasFreePlaces());
    }

    @Test
    public void checksIfThereIsATieFalse() {
        board.putSignOnBoard("X", 0);

        board.isTie();

        assertEquals(false, board.isTie());
    }

    @Test
    public void checksIfThereIsATieTrue() {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        playWholeGame("X", "Y", array1, array2);

        board.isTie();

        assertEquals(true, board.isTie());
    }


    @Test
    public void checkIfGameIsWonFalse() {
        playMoves("x", 0, 5, 2);

        assertEquals(false, board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV1() {
        playMoves("x", 0, 1, 2);

        assertEquals(true, board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV2() {
        playMoves("x", 3, 4, 5);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV3() {
        playMoves("x", 6, 7, 8);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV4() {
        playMoves("x", 0, 3, 6);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV5() {
        playMoves("x", 1, 4, 7);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV6() {
        playMoves("x", 2, 5, 8);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV7() {
        playMoves("x", 0, 4, 8);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV8() {
        playMoves("x", 2, 4, 6);

        assertTrue(board.isWon());
    }

    @Test
    public void changeWinnerSignWhenWon() {
        playMoves("x", 2, 4, 6);

        board.isWon();
        assertEquals("x", board.winnerSign());
    }

    @Test
    public void returnTrueWHenPositionIsNonTaken() {
        board.putSignOnBoard("X", 6);

        assertTrue(board.isNonTaken("2"));
    }

    @Test
    public void returnFalseWHenPositionIsTaken() {
        board.putSignOnBoard("X", 6);

        assertFalse(board.isNonTaken("6"));
    }

    public void playMoves(String string, int a, int b, int c) {
        board.putSignOnBoard(string, a);
        board.putSignOnBoard(string, b);
        board.putSignOnBoard(string, c);
    }

    public void playWholeGame(String sign1, String sign2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            board.putSignOnBoard(sign1, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            board.putSignOnBoard(sign2, arraySign2[i]);
        }
    }
}



