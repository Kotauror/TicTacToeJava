package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    private Board board;
    private Player player;
    private Player player2;

    @BeforeEach
    void instantiateBoard() {
        board = new Board();
        player = new Player("X");
        player2 = new Player("Y");
    }

    @Test
    void itIsCreatedWithPlacesArray() {
        assertThat(board.getPlaces(),isA(ArrayList.class));
    }

    @Test
    void itHasIntegersFrom0to8InPlacesWhenCreated() {
        for(int i = 0; i < 9; i++) {
            assertEquals(i, board.valueAtPosition(i));
        }
    }

    @Test
    void itReturnsStringValueFromPosition() {
        board.putSignOnBoard(player, 0);

        assertEquals("X", board.valueAtPosition(0));
    }

    @Test
    void itReturnsIntegerValueFromPosition() {
        assertEquals(5, board.valueAtPosition(5));
    }

    @Test
    void isNotATie() {
        board.putSignOnBoard(player, 0);

        assertFalse(board.isTie());
    }

    @Test
    void isATie() {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        setupBoard(player, player2, array1, array2);

        assertTrue(board.isTie());
    }

    @Test
    void doesNotHaveAWin() {
        playMoves(player, 0, 5, 2);

        assertFalse(board.isWon());
    }

    @Test
    void hasWinFor0_1_2() {
        playMoves(player, 0, 1, 2);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor3_4_5() {
        playMoves(player, 3, 4, 5);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor6_7_8() {
        playMoves(player, 6, 7, 8);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor0_3_6() {
        playMoves(player, 0, 3, 6);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor1_4_7() {
        playMoves(player, 1, 4, 7);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor2_5_8() {
        playMoves(player, 2, 5, 8);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor0_4_8() {
        playMoves(player, 0, 4, 8);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor2_4_6() {
        playMoves(player, 2, 4, 6);

        assertTrue(board.isWon());
    }

    @Test
    void itChangesWinnerSignWhenGameIsWon() {
        playMoves(player, 2, 4, 6);

        board.isWon();
        assertEquals("X", board.winnerSign());
    }

    @Test
    void returnsTrueWhenPositionIsNonTaken() {
        board.putSignOnBoard(player, 6);

        assertTrue(board.isNonTaken("2"));
    }

    @Test
    void returnsFalseWhenPositionIsTaken() {
        board.putSignOnBoard(player, 6);

        assertFalse(board.isNonTaken("6"));
    }

    private void playMoves(Player player, int a, int b, int c) {
        board.putSignOnBoard(player, a);
        board.putSignOnBoard(player, b);
        board.putSignOnBoard(player, c);
    }

    private void setupBoard(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for (int anArraySign1 : arraySign1) {
            board.putSignOnBoard(player, anArraySign1);
        }
        for (int anArraySign2 : arraySign2) {
            board.putSignOnBoard(player2, anArraySign2);
        }
    }
}



