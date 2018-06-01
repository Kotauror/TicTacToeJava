package com.core.tictactoe;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    private static Game game;

    @Test
    void gameHasInstancesOfCLUIBoardAndPlayers() {
        game = new Game(new CommandLineUI(System.out, System.in), new Board());
        assertThat(game.active, isA(Player.class));
        assertThat(game.passive, isA(Player.class));
        assertThat(game.board, isA(Board.class));
        assertThat(game.commandLineUI, isA(CommandLineUI.class));
    }

    @Test
    void playsAWinningGame() {
        String[] fakeUsersInputs = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs), board);

        game.run();

        assertTrue(board.isWon());
        assertFalse(board.isTie());
        assertEquals("X", board.winnerSign());
        assertEquals("Y", game.active.sign);
        assertEquals(asList("X", "Y", "X", "Y", "X", "Y", "X", 7, 8), board.places);
    }

    @Test
    void playsATieGame() {
        String[] fakeUsersInputs = {"1", "0", "3", "2", "4", "5", "6", "7", "8"};
        Board board = new Board();
        game = new Game(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs), board);

        game.run();

        assertFalse(board.isWon());
        assertTrue(board.isTie());
        assertEquals(asList("Y", "X", "Y", "X", "X", "Y", "X", "Y", "X"), board.places);
        assertEquals("none", board.winnerSign());
    }
}


