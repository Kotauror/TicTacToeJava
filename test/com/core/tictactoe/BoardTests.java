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
    void boardIsCreatedWithPlacesArray() {
        assertThat(board.places,isA(ArrayList.class));
    }

    @Test
    void boardHasFilledPlacesWhenCreated() {
        for(int i = 0; i < 9; i++) {
            assertEquals(board.places.get(i),i);
        }
    }

    @Test
    void changesSignOnBoardToPlayerSign() {
        board.putSignOnBoard(player, 0);

        assertEquals("X", board.places.get(0));
    }



    @Test
    void checksIfThereIsATieFalse() {
        board.putSignOnBoard(player, 0);

        board.isTie();

        assertFalse(board.isTie());
    }

    @Test
    void checksIfThereIsATieTrue() {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        setupBoard(player, player2, array1, array2);

        board.isTie();

        assertTrue(board.isTie());
    }


    @Test
    void checkIfGameIsWonFalse() {
        playMoves(player, 0, 5, 2);

        assertFalse(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV1() {
        playMoves(player, 0, 1, 2);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV2() {
        playMoves(player, 3, 4, 5);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV3() {
        playMoves(player, 6, 7, 8);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV4() {
        playMoves(player, 0, 3, 6);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV5() {
        playMoves(player, 1, 4, 7);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV6() {
        playMoves(player, 2, 5, 8);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV7() {
        playMoves(player, 0, 4, 8);

        assertTrue(board.isWon());
    }

    @Test
    void checkIfGameIsWonTrueV8() {
        playMoves(player, 2, 4, 6);

        assertTrue(board.isWon());
    }

    @Test
    void changeWinnerSignWhenWon() {
        playMoves(player, 2, 4, 6);

        board.isWon();
        assertEquals("X", board.winnerSign());
    }

    @Test
    void returnTrueWHenPositionIsNonTaken() {
        board.putSignOnBoard(player, 6);

        assertTrue(board.isNonTaken("2"));
    }

    @Test
    void returnFalseWHenPositionIsTaken() {
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



