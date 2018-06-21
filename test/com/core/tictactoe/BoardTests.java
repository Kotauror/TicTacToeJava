package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    private Board board3x3;
    private Board board4x4;
    private Player humanPlayerX;
    private Player humanPlayerO;

    @BeforeEach
    void instantiate() {
        board3x3 = new Board(3);
        board4x4 = new Board(4);
        humanPlayerX = new HumanPlayer("X");
        humanPlayerO = new HumanPlayer("O");
    }

    @Test
    void itHasStringsFrom1to9InPlacesWhenCreatedWithSize3() {
        for(int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i+1), board3x3.valueAtIndex(i));
        }
    }

    @Test
    void itHasStringsFrom1to16InPlacesWhenCreatedWithSize4() {
        board3x3 = new Board(4);
        for(int i = 0; i < 16; i++) {
            assertEquals(String.valueOf(i+1), board3x3.valueAtIndex(i));
        }
    }

//    @Test
//    void returnsPlacesSortedInRowsFor3x3Board() {
//        String[] row1 = {"1", "2", "3"};
//        String[] row2 = {"4", "5", "6"};
//        String[] row3 = {"7", "8", "9"};
//        String[][] expectedArray = {row1, row2, row3};
//
//        assertArrayEquals(expectedArray, board3x3.getRowsInBoard());
//    }
//
//    @Test
//    void returnsPlacesSortedInRowsFor4x4Board() {
//        board3x3 = new Board(4);
//        String[] row1 = {"1", "2", "3", "4"};
//        String[] row2 = {"5", "6", "7", "8"};
//        String[] row3 = {"9", "10", "11", "12"};
//        String[] row4 = {"13", "14", "15", "16"};
//        String[][] expectedArray = {row1, row2, row3, row4};
//
//        assertArrayEquals(expectedArray, board3x3.getRowsInBoard());
//    }
//
//    @Test
//    void returnsPlacesSortedInColumnsFor3x3Board() {
//        Board board3x3 = new Board(3);
//        String[] col1 = {"1", "4", "7"};
//        String[] col2 = {"2", "5", "8"};
//        String[] col3 = {"3", "6", "9"};
//        String[][] expectedArray = {col1, col2, col3};
//
//        assertArrayEquals(expectedArray, board3x3.getColumnsInBoard());
//    }
//
//    @Test
//    void returnsPlacesSortedInColumnsFor4x4Board() {
//        Board board3x3 = new Board(4);
//        String[] col1 = {"1", "5", "9", "13"};
//        String[] col2 = {"2", "6", "10", "14"};
//        String[] col3 = {"3", "7", "11", "15"};
//        String[] col4 = {"4", "8", "12", "16"};
//        String[][] expectedArray = {col1, col2, col3, col4};
//
//        assertArrayEquals(expectedArray, board3x3.getColumnsInBoard());
//    }
//
//    @Test
//    void returnsPlacesSortedInColumnsFor5x5Board() {
//        Board board3x3 = new Board(5);
//        String[] col1 = {"1", "6", "11", "16", "21"};
//        String[] col2 = {"2", "7", "12", "17", "22"};
//        String[] col3 = {"3", "8", "13", "18", "23"};
//        String[] col4 = {"4", "9", "14", "19", "24"};
//        String[] col5 = {"5", "10", "15", "20", "25"};
//        String[][] expectedArray = {col1, col2, col3, col4, col5};
//
//        assertArrayEquals(expectedArray, board3x3.getColumnsInBoard());
//    }

//    @Test
//    void returnsPlacesSortedInTopLeftDiagonalFor3x3Board() {
//        Board board3x3 = new Board(3);
//        String[] diagonal = {"1", "5", "9"};
//
//        assertArrayEquals(diagonal, board3x3.getTopLeftDiagonal());
//    }
//
//    @Test
//    void returnsPlacesSortedInTopLeftDiagonalFor4x4Board() {
//        Board board3x3 = new Board(4);
//        String[] diagonal = {"1", "6", "11", "16"};
//
//        assertArrayEquals(diagonal, board3x3.getTopLeftDiagonal());
//    }
//
//    @Test
//    void returnsPlacesSortedInTopRightDiagonalFor3x3Board() {
//        Board board3x3 = new Board(3);
//        String[] diagonal = {"3", "5", "7"};
//
//        assertArrayEquals(diagonal, board3x3.getTopRightDiagonal());
//    }

//    @Test
//    void returnsPlacesSortedInTopRightDiagonalFor4x4Board() {
//        Board board3x3 = new Board(4);
//        String[] diagonal = {"4", "7", "10", "13"};
//
//        assertArrayEquals(diagonal, board3x3.getTopRightDiagonal());
//    }

//    @Test
//    void itReturnsAllVectorsOn3x3Board() {
//        String[] row1 = {"1", "2", "3"};
//        String[] row2 = {"4", "5", "6"};
//        String[] row3 = {"7", "8", "9"};
//        String[] col1 = {"1", "4", "7"};
//        String[] col2 = {"2", "5", "8"};
//        String[] col3 = {"3", "6", "9"};
//        String[] diagonalOne = {"1", "5", "9"};
//        String[] diagonalTwo = {"3", "5", "7"};
//        String[][] allVectors = {row1, row2, row3, col1, col2, col3, diagonalOne, diagonalTwo};
//
//        assertArrayEquals(allVectors, board3x3.getAllVectors());
//}
//
//    @Test
//    void itReturnsAllVectorsOn4x4Board() {
//        Board board3x3 = new Board(4);
//        String[] row1 = {"1", "2", "3", "4"};
//        String[] row2 = {"5", "6", "7", "8"};
//        String[] row3 = {"9", "10", "11", "12"};
//        String[] row4 = {"13", "14", "15", "16"};
//        String[] col1 = {"1", "5", "9", "13"};
//        String[] col2 = {"2", "6", "10", "14"};
//        String[] col3 = {"3", "7", "11", "15"};
//        String[] col4 = {"4", "8", "12", "16"};
//        String[] diagonalOne = {"1", "6", "11", "16"};
//        String[] diagonalTwo = {"4", "7", "10", "13"};
//        String[][] allVectors = {row1, row2, row3, row4, col1, col2, col3, col4, diagonalOne, diagonalTwo};
//
//        assertArrayEquals(allVectors, board3x3.getAllVectors());
//    }

    @Test
    void itReturnsStringSingFromPosition() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertEquals("X", board3x3.valueAtIndex(0));
    }

    @Test
    void itReturnsStringValueFromPosition() {
        assertEquals("6", board3x3.valueAtIndex(5));
    }

    @Test
    void isNotATie() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertFalse(board3x3.isTie());
    }

    @Test
    void isATie() {
        int[] array1 = {2, 4, 5, 7, 9};
        int[] array2 = {1, 3, 6, 8};
        setupBoard(humanPlayerX, humanPlayerO, array1, array2);

        assertTrue(board3x3.isTie());
    }

    @Test
    void doesNotHaveAWin() {
        playMoves3x3(humanPlayerX.getSign(), 1, 6, 3);

        assertFalse(board3x3.isWon());
    }

    @Test
    void hasWinFor1_2_3() {
        playMoves3x3(humanPlayerX.getSign(), 1, 2, 3);

        assertTrue(board3x3.isWon());
    }


    @Test
    void hasWinFor4_5_6() {
        playMoves3x3(humanPlayerX.getSign(), 4, 5, 6);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor7_8_9() {
        playMoves3x3(humanPlayerX.getSign(), 7, 8, 9);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor1_4_7() {
        playMoves3x3(humanPlayerX.getSign(), 1, 4, 7);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor2_5_8() {
        playMoves3x3(humanPlayerX.getSign(), 2, 5, 8);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor3_6_9() {
        playMoves3x3(humanPlayerX.getSign(), 3, 6, 9);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor1_5_9() {
        playMoves3x3(humanPlayerX.getSign(), 1, 5, 9);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor3_5_7() {
        playMoves3x3(humanPlayerX.getSign(), 3, 5, 7);

        assertTrue(board3x3.isWon());
    }

    @Test
    void hasWinFor1_2_3_4() {
        playMoves4x4(humanPlayerX.getSign(), 1, 2, 3, 4);

        assertTrue(board4x4.isWon());
    }

    @Test
    void hasWinFor1_6_11_16() {
        playMoves4x4(humanPlayerX.getSign(), 1, 6, 11,16);

        assertTrue(board4x4.isWon());
    }

    @Test
    void hasWinFor4_7_10_13() {
        playMoves4x4(humanPlayerX.getSign(), 4, 7, 10,13);

        assertTrue(board4x4.isWon());
    }

    @Test
    void hasWinFor3_7_11_15() {
        playMoves4x4(humanPlayerX.getSign(), 3, 7, 11,15);

        assertTrue(board4x4.isWon());
    }

    @Test
    void itChangesWinnerSignWhenGameIsWon() {
        playMoves3x3(humanPlayerX.getSign(), 3, 5, 7);

        board3x3.isWon();
        assertEquals("X", board3x3.winnerSign());
    }

    @Test
    void returnsTrueWhenPositionIsNonTaken() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 6);

        assertTrue(board3x3.isNonTaken("2"));
    }

    @Test
    void returnsFalseWhenPositionIsTaken() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 6);

        assertFalse(board3x3.isNonTaken("6"));
    }

    @Test
    void returnsArrayListOfFreePlaces() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);
        ArrayList<String> freePlaces = new ArrayList<String>();
        for(int i = 2; i < 10; i++) {
            freePlaces.add(Integer.toString(i));
        }

        assertArrayEquals(freePlaces.toArray(new String[freePlaces.size()]), board3x3.getFreePlaces());
    }

    @Test
    void returnsSignOfActivePlayerWhenGameJustStarted() {
        assertEquals("X", board3x3.getActivePlayerSign());
    }

    @Test
    void returnsSignOfActivePlayerAfterFirstMove() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertEquals("O", board3x3.getActivePlayerSign());
    }

    @Test
    void returnsSignOfActivePlayerAfterTwoMoves() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);
        board3x3.putSignOnBoard(humanPlayerO.getSign(), 2);

        assertEquals("X", board3x3.getActivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerWhenGameJustStarted() {
        assertEquals("O", board3x3.getPassivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerAfterFirstMove() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);

        assertEquals("X", board3x3.getPassivePlayerSign());
    }

    @Test
    void returnsSignOfPassivePlayerAfterTwoMoves() {
        board3x3.putSignOnBoard(humanPlayerX.getSign(), 1);
        board3x3.putSignOnBoard(humanPlayerO.getSign(), 2);

        assertEquals("O", board3x3.getPassivePlayerSign());
    }

    private void playMoves3x3(String sign, int a, int b, int c) {
        board3x3.putSignOnBoard(sign, a);
        board3x3.putSignOnBoard(sign, b);
        board3x3.putSignOnBoard(sign, c);
    }


    private void playMoves4x4(String sign, int a, int b, int c, int d) {
        board4x4.putSignOnBoard(sign, a);
        board4x4.putSignOnBoard(sign, b);
        board4x4.putSignOnBoard(sign, c);
        board4x4.putSignOnBoard(sign, d);
    }

    private void setupBoard(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for (int anArraySign1 : arraySign1) {
            board3x3.putSignOnBoard(player.getSign(), anArraySign1);
        }
        for (int anArraySign2 : arraySign2) {
            board3x3.putSignOnBoard(player2.getSign(), anArraySign2);
        }
    }
}



