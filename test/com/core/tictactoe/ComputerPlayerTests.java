package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class ComputerPlayerTests {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    void instantiatePlayer() {
        computerPlayer = new ComputerPlayer("X", "Y");
    }

    @Test
    void playerHasSign() {
        assertEquals(computerPlayer.getSign(), "X");
    }

    @Test
    void returnsBestMoveInOneMove1_5_9() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("X");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 5);
        assertEquals(9, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

    @Test
    void returnsBestMoveInOneMove1_4_7() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("X");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 4);
        assertEquals(7, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

    @Test
    void returnsBestMoveInOneMove1_4_7_hardcoded() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 2);
        board.putSignOnBoard(player1.getSign(), 7);
        board.putSignOnBoard(player2.getSign(), 5);
        assertEquals(4, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

    @Test
    void returnsBestMoveInOneMove1_4_7_hardcoded2() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 2);
        board.putSignOnBoard(player1.getSign(), 3);
        board.putSignOnBoard(player2.getSign(), 5);
        board.putSignOnBoard(player1.getSign(), 8);
        board.putSignOnBoard(player2.getSign(), 7);
        assertEquals(6, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

    @Test
    void preventsOpponentFromWinning() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 5);
        board.putSignOnBoard(player2.getSign(), 3);
        board.putSignOnBoard(player1.getSign(), 7);
        board.putSignOnBoard(player2.getSign(), 9);
        assertEquals(6, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

    @Test
    void returnsBestMoveInTheFirstTurn5() {
        Board board = new Board();

        assertEquals(1, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

    @Test
    void goesToTheMiddleInSecondMove() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");
        board.putSignOnBoard(player1.getSign(), 1);

        assertEquals(5, computerPlayer.playMove(board, 0,  "Y", "X"));
    }

    @Test
    void preventsOpponentFromWinningv2() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 5);
        board.putSignOnBoard(player1.getSign(), 3);
        board.putSignOnBoard(player2.getSign(), 2);
        assertEquals(8, computerPlayer.playMove(board, 0,  "X", "Y"));
    }

}
