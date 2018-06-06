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
    void returnsWinningPositionDiagonal() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("X");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 5);
        assertEquals(9, computerPlayer.playMove(board, 0, "X", "Y"));
    }

    @Test
    void returnsWinningPositionColumn() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("X");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 4);
        assertEquals(7, computerPlayer.playMove(board, 0, "X", "Y"));
    }

    @Test
    void returnsBestMoveOnBoardWith5EmptyMoves() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 2);
        board.putSignOnBoard(player1.getSign(), 7);
        board.putSignOnBoard(player2.getSign(), 5);
        assertEquals(4, computerPlayer.playMove(board, 0, "X", "Y"));
    }

    @Test
    void returnsBestMoveOnBoardWith3EmptyMoves() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 2);
        board.putSignOnBoard(player1.getSign(), 3);
        board.putSignOnBoard(player2.getSign(), 5);
        board.putSignOnBoard(player1.getSign(), 8);
        board.putSignOnBoard(player2.getSign(), 7);
        assertEquals(4, computerPlayer.playMove(board, 0, "X", "Y"));
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
        assertEquals(6, computerPlayer.playMove(board, 0, "X", "Y"));
    }

    @Test
    void preventsOpponentFromWinning2() {
        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("Y");

        board.putSignOnBoard(player1.getSign(), 1);
        board.putSignOnBoard(player2.getSign(), 5);
        board.putSignOnBoard(player1.getSign(), 3);
        board.putSignOnBoard(player2.getSign(), 2);
        assertEquals(8, computerPlayer.playMove(board, 0, "X", "Y"));
    }

    @Test
    void returnsTopLeftCornerAsTheFirstTakenPlace() {
        Board board = new Board();

        assertEquals(1, computerPlayer.playMove(board, 0, "X", "Y"));
    }

    @Test
    void returnsMiddlePositionAsTheSecondTakenPlace() {
        Board board = new Board();
        Player player1 = new Player("X");
        board.putSignOnBoard(player1.getSign(), 1);

        assertEquals(5, computerPlayer.playMove(board, 0, "Y", "X"));
    }
}
