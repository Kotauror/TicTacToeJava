package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    private Board board;
    private Player player;
    private Player player2;

    @BeforeEach
    void instantiate() {
        board = new Board();
        player = new Player("X");
        player2 = new Player("Y");
    }

    @Test
    void itHasStringsFrom1to9InPlacesWhenCreated() {
        for(int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i+1), board.valueAtIndex(i));
        }
    }

    @Test
    void itReturnsStringSingFromPosition() {
        board.putSignOnBoard(player, 1);

        assertEquals("X", board.valueAtIndex(0));
    }

    @Test
    void itReturnsStringValueFromPosition() {
        assertEquals("6", board.valueAtIndex(5));
    }

    @Test
    void isNotATie() {
        board.putSignOnBoard(player, 1);

        assertFalse(board.isTie());
    }

    @Test
    void isATie() {
        int[] array1 = {2, 4, 5, 7, 9};
        int[] array2 = {1, 3, 6, 8};
        setupBoard(player, player2, array1, array2);

        assertTrue(board.isTie());
    }

    @Test
    void doesNotHaveAWin() {
        playMoves(player, 1, 6, 3);

        assertFalse(board.isWon());
    }

    @Test
    void hasWinFor1_2_3() {
        playMoves(player, 1, 2, 3);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor4_5_6() {
        playMoves(player, 4, 5, 6);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor7_8_9() {
        playMoves(player, 7, 8, 9);

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
    void hasWinFor3_6_9() {
        playMoves(player, 3, 6, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor1_5_9() {
        playMoves(player, 1, 5, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor3_5_7() {
        playMoves(player, 3, 5, 7);

        assertTrue(board.isWon());
    }

    @Test
    void itChangesWinnerSignWhenGameIsWon() {
        playMoves(player, 3, 5, 7);

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

    @Test
    void returnsArrayListOfFreePlaces() {
        Player player = new Player("X");
        board.putSignOnBoard(player, 1);
        ArrayList<String> freePlaces = new ArrayList<String>();
        for(int i = 2; i < 10; i++) {
            freePlaces.add(Integer.toString(i));
        }

        assertEquals(freePlaces, board.getFreePlaces());
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



