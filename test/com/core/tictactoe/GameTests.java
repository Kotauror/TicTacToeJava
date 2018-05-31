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
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        setBoard(game.active, game.passive, array1, array2);

        game.run();

        assertFalse(game.board.isWon());
        assertTrue(game.board.isTie());
        assertEquals("none", game.board.winnerSign());
    }

    public void setBoard(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            game.board.putSignOnBoard(player, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            game.board.putSignOnBoard(player2, arraySign2[i]);
        }
    }

}


