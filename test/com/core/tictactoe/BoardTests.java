package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    private Board board;
    private Player humanPlayerX;
    private Player humanPlayerO;

    @BeforeEach
    void instantiate() {
        board = new Board(3);
        humanPlayerX = new HumanPlayer("X");
        humanPlayerO = new HumanPlayer("O");
    }

    @Test
    void itHasStringsFrom1to9InPlacesWhenCreatedWithSize3() {
        for(int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i+1), board.valueAtIndex(i));
        }
    }

    @Test
    void itHasStringsFrom1to16InPlacesWhenCreatedWithSize4() {
        board = new Board(4);
        for(int i = 0; i < 16; i++) {
            assertEquals(String.valueOf(i+1), board.valueAtIndex(i));
        }
    }

    @Test
    void returnsPlacesSortedInRowsFor3x3Board() {
        String[] row1 = {"1", "2", "3"};
        String[] row2 = {"4", "5", "6"};
        String[] row3 = {"7", "8", "9"};
        String[][] expectedArray = {row1, row2, row3};

        assertArrayEquals(expectedArray, board.getRowsInBoard());
    }

    @Test
    void returnsPlacesSortedInRowsFor4x4Board() {
        board = new Board(4);
        String[] row1 = {"1", "2", "3", "4"};
        String[] row2 = {"5", "6", "7", "8"};
        String[] row3 = {"9", "10", "11", "12"};
        String[] row4 = {"13", "14", "15", "16"};
        String[][] expectedArray = {row1, row2, row3, row4};

        assertArrayEquals(expectedArray, board.getRowsInBoard());
    }

    @Test
    void returnsPlacesSortedInColumnsFor3x3Board() {
        Board board = new Board(3);
        String[] col1 = {"1", "4", "7"};
        String[] col2 = {"2", "5", "8"};
        String[] col3 = {"3", "6", "9"};
        String[][] expectedArray = {col1, col2, col3};

        assertArrayEquals(expectedArray, board.getColumnsInBoard());
    }

    @Test
    void returnsPlacesSortedInColumnsFor4x4Board() {
        Board board = new Board(4);
        String[] col1 = {"1", "5", "9", "13"};
        String[] col2 = {"2", "6", "10", "14"};
        String[] col3 = {"3", "7", "11", "15"};
        String[] col4 = {"4", "8", "12", "16"};
        String[][] expectedArray = {col1, col2, col3, col4};

        assertArrayEquals(expectedArray, board.getColumnsInBoard());
    }

    @Test
    void returnsPlacesSortedInColumnsFor5x5Board() {
        Board board = new Board(5);
        String[] col1 = {"1", "6", "11", "16", "21"};
        String[] col2 = {"2", "7", "12", "17", "22"};
        String[] col3 = {"3", "8", "13", "18", "23"};
        String[] col4 = {"4", "9", "14", "19", "24"};
        String[] col5 = {"5", "10", "15", "20", "25"};
        String[][] expectedArray = {col1, col2, col3, col4, col5};

        assertArrayEquals(expectedArray, board.getColumnsInBoard());
    }

    @Test
    void returnsPlacesSortedInLeftDiagonalFor3x3Board() {
        Board board = new Board(3);
        String[] diagonalOne = {"1", "5", "9"};

        assertArrayEquals(diagonalOne, board.getTopLeftDiagonal());
    }

    @Test
    void returnsPlacesSortedInLeftDiagonalFor4x4Board() {
        Board board = new Board(4);
        String[] diagonalOne = {"1", "6", "11", "16"};

        assertArrayEquals(diagonalOne, board.getTopLeftDiagonal());
    }

    @Test
    void itReturnsStringSingFromPosition() {
        board.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertEquals("X", board.valueAtIndex(0));
    }

    @Test
    void itReturnsStringValueFromPosition() {
        assertEquals("6", board.valueAtIndex(5));
    }

    @Test
    void isNotATie() {
        board.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertFalse(board.isTie());
    }

    @Test
    void isATie() {
        int[] array1 = {2, 4, 5, 7, 9};
        int[] array2 = {1, 3, 6, 8};
        setupBoard(humanPlayerX, humanPlayerO, array1, array2);

        assertTrue(board.isTie());
    }

    @Test
    void doesNotHaveAWin() {
        playMoves(humanPlayerX.getSign(), 1, 6, 3);

        assertFalse(board.isWon());
    }

    @Test
    void hasWinFor1_2_3() {
        playMoves(humanPlayerX.getSign(), 1, 2, 3);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor4_5_6() {
        playMoves(humanPlayerX.getSign(), 4, 5, 6);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor7_8_9() {
        playMoves(humanPlayerX.getSign(), 7, 8, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor1_4_7() {
        playMoves(humanPlayerX.getSign(), 1, 4, 7);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor2_5_8() {
        playMoves(humanPlayerX.getSign(), 2, 5, 8);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor3_6_9() {
        playMoves(humanPlayerX.getSign(), 3, 6, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor1_5_9() {
        playMoves(humanPlayerX.getSign(), 1, 5, 9);

        assertTrue(board.isWon());
    }

    @Test
    void hasWinFor3_5_7() {
        playMoves(humanPlayerX.getSign(), 3, 5, 7);

        assertTrue(board.isWon());
    }

    @Test
    void itChangesWinnerSignWhenGameIsWon() {
        playMoves(humanPlayerX.getSign(), 3, 5, 7);

        board.isWon();
        assertEquals("X", board.winnerSign());
    }

    @Test
    void returnsTrueWhenPositionIsNonTaken() {
        board.putSignOnBoard(humanPlayerX.getSign(), 6);

        assertTrue(board.isNonTaken("2"));
    }

    @Test
    void returnsFalseWhenPositionIsTaken() {
        board.putSignOnBoard(humanPlayerX.getSign(), 6);

        assertFalse(board.isNonTaken("6"));
    }

    @Test
    void returnsArrayListOfFreePlaces() {
        // Player humanPlayerX = new Player("X");
        board.putSignOnBoard(humanPlayerX.getSign(), 1);
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
        board.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertEquals("O", board.getActivePlayerSign());
    }

    @Test
    void returnsSignOfActivePlayerAfterTwoMoves() {
        board.putSignOnBoard(humanPlayerX.getSign(), 1);
        board.putSignOnBoard(humanPlayerO.getSign(), 2);

        assertEquals("X", board.getActivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerWhenGameJustStarted() {
        assertEquals("O", board.getPassivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerAfterFirstMove() {
        board.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertEquals("X", board.getPassivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerAfterTwoMoves() {
        board.putSignOnBoard(humanPlayerX.getSign(), 1);
        board.putSignOnBoard(humanPlayerO.getSign(), 2);

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



