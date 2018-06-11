package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class ComputerPlayerTests {

    private ComputerPlayer computerPlayer;
    private CommandLineUI commandLineUI;

    @BeforeEach
    void instantiate() {
        computerPlayer = new ComputerPlayer("X");
        commandLineUI = new CommandLineUI(System.out, System.in);
    }

    @Test
    void playerHasSign() {
        assertEquals(computerPlayer.getSign(), "X");
    }

    @Test
    void returnsWinningPositionDiagonal() {
        String[] positionsOnBoard = {"X", "2", "3", "4", "X", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(9, computerPlayer.playMove(commandLineUI, board,  "X", "Y"));
    }

    @Test
    void returnsWinningPositionColumn() {
        String[] positionsOnBoard = {"X", "2", "3", "X", "5", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(7, computerPlayer.playMove(commandLineUI, board, "X", "Y"));
    }

    @Test
    void returnsBestMoveOnBoardWith5EmptyMoves() {
        String[] positionsOnBoard = {"X", "Y", "3", "4", "Y", "6", "X", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.playMove(commandLineUI, board,"X", "Y"));
    }

    @Test
    void returnsBestMoveOnBoardWith3EmptyMoves() {
        String[] positionsOnBoard = {"X", "Y", "X", "4", "Y", "6", "Y", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.playMove(commandLineUI, board, "X", "Y"));
    }

    @Test
    void preventsOpponentFromWinning() {
        String[] positionsOnBoard = {"1", "2", "Y", "4", "X", "6", "X", "8", "Y"};
        Board board = new Board(positionsOnBoard);

        assertEquals(6, computerPlayer.playMove(commandLineUI, board, "X", "Y"));
    }

    @Test
    void preventsOpponentFromWinning3() {
        String[] positionsOnBoard = {"X", "Y", "X", "4", "Y", "6", "Y", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.playMove(commandLineUI, board, "X", "Y"));
    }


    @Test
    void preventsOpponentFromWinning2() {
        String[] positionsOnBoard = {"X", "Y", "X", "4", "Y", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(8, computerPlayer.playMove(commandLineUI, board, "X", "Y"));
    }

    @Test
    void returnsTopLeftCornerAsTheFirstTakenPlace() {
        Board board = new Board();

        assertEquals(1, computerPlayer.playMove(commandLineUI, board, "X", "Y"));
    }

    @Test
    void returnsMiddlePositionAsTheSecondTakenPlace() {
        String[] positionsOnBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(5, computerPlayer.playMove(commandLineUI, board, "Y", "X"));
    }
}
