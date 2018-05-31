package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class GameTests {

    public static Game game;

    @BeforeEach
    public void createInstance() {
        game = new Game(new CommandLineUI(System.out, System.in));
    }

    @Test
    public void GameCreatesAnInstanceOfBoard() {
        assertThat(game.board, isA(Board.class));
    }

    @Test
    public void GameHasInstanceOfCommandLineUI() {
        assertThat(game.commandLineUI, isA(CommandLineUI.class));
    }

    @Test
    public void GameCreatesAnInstanceOfPlayer() {
        assertThat(game.active, isA(Player.class));
        assertThat(game.passive, isA(Player.class));
    }

    @Test
    public void playsAFullWonGame() throws IOException {
        String[] fakeUsersInputs = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        game = new Game(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));

        game.run();

        assertTrue(game.board.isWon());
        assertFalse(game.board.isTie());
        assertEquals("X", game.board.winnerSign());
        assertEquals("Y", game.active.sign);
        assertEquals(asList("X", "Y", "X", "Y", "X", "Y", "X", 7, 8), game.board.places);
    }

    @Test
    public void playsAFullTieGame() throws IOException {
        String[] fakeUsersInputs = {"1", "0", "3", "2", "4", "5", "6", "7", "8"};
        game = new Game(new StubbCommandLineUI(System.out, System.in, fakeUsersInputs));

        game.run();

        assertFalse(game.board.isWon());
        assertTrue(game.board.isTie());
        assertEquals(asList("Y", "X", "Y", "X", "X", "Y", "X", "Y", "X"), game.board.places);
        assertEquals("none", game.board.winnerSign());
    }

}


