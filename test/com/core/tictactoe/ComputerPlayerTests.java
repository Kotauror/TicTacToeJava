package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class ComputerPlayerTests {

    private ComputerPlayer computerPlayer;
    private CommandLineUi commandLineUi;

    @BeforeEach
    void instantiate() {
        computerPlayer = new ComputerPlayer("X");
        commandLineUi = new CommandLineUi(System.out, System.in);
    }

    @Test
    void playerHasSign() {
        assertEquals(computerPlayer.getSign(), "X");
    }

    @Test
    void returnsWinningPositionDiagonal() {
        String[] positionsOnBoard = {"X", "2", "3", "4", "X", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(9, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsWinningPositionColumn() {
        String[] positionsOnBoard = {"X", "2", "3", "X", "5", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(7, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsBestMoveOnBoardWith5EmptyMoves() {
        String[] positionsOnBoard = {"X", "O", "3", "4", "O", "6", "X", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsBestMoveOnBoardWith3EmptyMoves() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "O", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsBestMoveOnBoardWith4EmptyMoves() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "7", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void preventsOpponentFromWinning() {
        String[] positionsOnBoard = {"1", "2", "O", "4", "X", "6", "X", "8", "O"};
        Board board = new Board(positionsOnBoard);

        assertEquals(6, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void preventsOpponentFromWinning3() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "O", "X", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(4, computerPlayer.pickPosition(commandLineUi, board));
    }


    @Test
    void preventsOpponentFromWinning2() {
        String[] positionsOnBoard = {"X", "O", "X", "4", "O", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(8, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsTopLeftCornerAsTheFirstTakenPlace() {
        Board board = new Board(3);

        assertEquals(1, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsMiddlePositionAsTheSecondTakenPlace() {
        String[] positionsOnBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board(positionsOnBoard);

        assertEquals(5, computerPlayer.pickPosition(commandLineUi, board));
    }

    @Test
    void returnsATypeOfPlayerAsAString() {
        String playerType = computerPlayer.getTypeAsAString();

        assertEquals("Computer", playerType);
    }

    @Test
    void pickPositionSwitchesBetweenMiniMaxAndRandom() {
        Board board = new Board(4);
        board.putSignOnBoard("X", 7);
        board.putSignOnBoard("O", 15);
        StubComputerPlayer stubComputerPlayer = new StubComputerPlayer("X");

        assertEquals(2, stubComputerPlayer.pickPosition(commandLineUi, board));
        board.putSignOnBoard("X", 13);
        assertEquals(1, stubComputerPlayer.pickPosition(commandLineUi, board));
    }
}
