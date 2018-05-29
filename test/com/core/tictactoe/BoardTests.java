package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;



public class BoardTests {

    public Board board;
    public Player player;
    public Player player2;

    @BeforeEach
    public void instantiateBoard() {
        board = new Board();
        player = new Player("X");
        player2 = new Player("Y");
    }

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
        board.putSignOnBoard(player, 0);

        assertEquals("X", board.places.get(0));
    }

    @Test
    public void checksIfThereArePlacesLeftTrue() {
        board.putSignOnBoard(player, 0);

        assertEquals(true, board.hasFreePlaces());
    }

    @Test
    public void checksIfThereArePlacesLeftFalse() {
        for(int i = 0; i < 9; i++) {
            board.putSignOnBoard(player, i);
        }

        assertFalse(board.hasFreePlaces());
    }

    @Test
    public void checksIfThereIsATieFalse() {
        board.putSignOnBoard(player, 0);

        board.isTie();

        assertEquals(false, board.isTie());
    }

    @Test
    public void checksIfThereIsATieTrue() {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        playWholeGame(player, player2, array1, array2);

        board.isTie();

        assertEquals(true, board.isTie());
    }


    @Test
    public void checkIfGameIsWonFalse() {
        playMoves(player, 0, 5, 2);

        assertEquals(false, board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV1() {
        playMoves(player, 0, 1, 2);

        assertEquals(true, board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV2() {
        playMoves(player, 3, 4, 5);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV3() {
        playMoves(player, 6, 7, 8);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV4() {
        playMoves(player, 0, 3, 6);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV5() {
        playMoves(player, 1, 4, 7);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV6() {
        playMoves(player, 2, 5, 8);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV7() {
        playMoves(player, 0, 4, 8);

        assertTrue(board.isWon());
    }

    @Test
    public void checkIfGameIsWonTrueV8() {
        playMoves(player, 2, 4, 6);

        assertTrue(board.isWon());
    }

    @Test
    public void changeWinnerSignWhenWon() {
        playMoves(player, 2, 4, 6);

        board.isWon();
        assertEquals("X", board.winnerSign());
    }

    @Test
    public void returnTrueWHenPositionIsNonTaken() {
        board.putSignOnBoard(player, 6);

        assertTrue(board.isNonTaken("2"));
    }

    @Test
    public void returnFalseWHenPositionIsTaken() {
        board.putSignOnBoard(player, 6);

        assertFalse(board.isNonTaken("6"));
    }

    public void playMoves(Player player, int a, int b, int c) {
        board.putSignOnBoard(player, a);
        board.putSignOnBoard(player, b);
        board.putSignOnBoard(player, c);
    }

    public void playWholeGame(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            board.putSignOnBoard(player, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            board.putSignOnBoard(player2, arraySign2[i]);
        }
    }
}



