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
        player = new HumanPlayer("X");
        player2 = new HumanPlayer("O");
    }

    @Test
    void itHasStringsFrom1to9InPlacesWhenCreated() {
        for(int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i+1), board.valueAtIndex(i));
        }
    }

    @Test
    void itReturnsStringSingFromPosition() {
        board.putSignOnBoard(player.getSign(), 1);

        assertEquals("X", board.valueAtIndex(0));
    }

    @Test
    void itReturnsStringValueFromPosition() {
        assertEquals("6", board.valueAtIndex(5));
    }

    @Test
    void isNotATie() {
        board.putSignOnBoard(player.getSign(), 1);

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
        playMoves(player.getSign(), 1, 6, 3);

        assertFalse(board.isWon());
    }

    @Test
    void hasWinFor1_2_3() {
        playMoves(player.getSign(), 1, 2, 3);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor4_5_6() {
        playMoves(player.getSign(), 4, 5, 6);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor7_8_9() {
        playMoves(player.getSign(), 7, 8, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor1_4_7() {
        playMoves(player.getSign(), 1, 4, 7);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor2_5_8() {
        playMoves(player.getSign(), 2, 5, 8);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor3_6_9() {
        playMoves(player.getSign(), 3, 6, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor1_5_9() {
        playMoves(player.getSign(), 1, 5, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor3_5_7() {
        playMoves(player.getSign(), 3, 5, 7);

        assertTrue(board.isWon());
    }

    @Test
    void itChangesWinnerSignWhenGameIsWon() {
        playMoves(player.getSign(), 3, 5, 7);

        board.isWon();
        assertEquals("X", board.winnerSign());
    }

    @Test
    void returnsTrueWhenPositionIsNonTaken() {
        board.putSignOnBoard(player.getSign(), 6);

        assertTrue(board.isNonTaken("2"));
    }

    @Test
    void returnsFalseWhenPositionIsTaken() {
        board.putSignOnBoard(player.getSign(), 6);

        assertFalse(board.isNonTaken("6"));
    }

    @Test
    void returnsArrayListOfFreePlaces() {
        // Player player = new Player("X");
        board.putSignOnBoard(player.getSign(), 1);
        ArrayList<String> freePlaces = new ArrayList<String>();
        for(int i = 2; i < 10; i++) {
            freePlaces.add(Integer.toString(i));
        }

        assertArrayEquals(freePlaces.toArray(new String[freePlaces.size()]), board.getFreePlaces());
    }

    @Test
    void returnsSignOfActivePlayerWhenGameJustStarted() {
        assertEquals("X", board.getActivePlayerSign());
    }

    @Test
    void returnsSignOfActivePlayerAfterFirstMove() {
        board.putSignOnBoard(player.getSign(), 1);

        assertEquals("O", board.getActivePlayerSign());
    }

    @Test
    void returnsSignOfActivePlayerAfterTwoMoves() {
        board.putSignOnBoard(player.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 2);

        assertEquals("X", board.getActivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerWhenGameJustStarted() {
        assertEquals("O", board.getPassivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerAfterFirstMove() {
        board.putSignOnBoard(player.getSign(), 1);

        assertEquals("X", board.getPassivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerAfterTwoMoves() {
        board.putSignOnBoard(player.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 2);

        assertEquals("O", board.getPassivePlayerSign());
    }

    private void playMoves(String sign, int a, int b, int c) {
        board.putSignOnBoard(sign, a);
        board.putSignOnBoard(sign, b);
        board.putSignOnBoard(sign, c);
    }

    private void setupBoard(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for (int anArraySign1 : arraySign1) {
            board.putSignOnBoard(player.getSign(), anArraySign1);
        }
        for (int anArraySign2 : arraySign2) {
            board.putSignOnBoard(player2.getSign(), anArraySign2);
        }
    }
}



