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

        assertEquals(9, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void returnsWinningPositionColumn() {
        String[] positionsOnBoard = {"X", "2", "3", "X", "5", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(7, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void returnsBestMoveOnBoardWith5EmptyMoves() {
        String[] positionsOnBoard = {"X", "O", "3", "4", "O", "6", "X", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void returnsBestMoveOnBoardWith3EmptyMoves() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "O", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void preventsOpponentFromWinning() {
        String[] positionsOnBoard = {"1", "2", "O", "4", "X", "6", "X", "8", "O"};
        Board board = new Board(positionsOnBoard);

        assertEquals(6, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void preventsOpponentFromWinning3() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "O", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUI, board));
    }


    @Test
    void preventsOpponentFromWinning2() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(8, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void returnsTopLeftCornerAsTheFirstTakenPlace() {
        Board board = new Board();

        assertEquals(1, computerPlayer.pickPosition(commandLineUI, board));
    }

    @Test
    void returnsMiddlePositionAsTheSecondTakenPlace() {
        String[] positionsOnBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(5, computerPlayer.pickPosition(commandLineUI, board));
    }
}
