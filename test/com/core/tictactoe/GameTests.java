package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class GameTests {

    public static Game game;
    public Player player;
    public Player player2;

    @BeforeEach
    public void createInstance() {
        game = new Game(new CommandLineUI());
        player = new Player("X");
        player2 = new Player("Y");
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
    public void switchesActivePlayer() {
        Player player1 = game.active;
        Player player2 = game.passive;

        game.switchPlayers();

        assertEquals(player2, game.active);
        assertEquals(player1, game.passive);
    }

    @Test
    public void returnsPositionGivenByPlayer() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("0", game.getUserPosition());
    }

    @Test
    public void returnsFalseIfPositionWasAccepted() {
        assertFalse(game.actUponOption("0"));
    }

    @Test
    public void returnsTrueWhenPositionWasTaken() {
        game.board.putSignOnBoard(player, 0);

        assertTrue(game.actUponOption("0"));
    }

    @Test
    public void returnsTrueWhenPositionInvalid() {
        assertTrue(game.actUponOption("test"));
    }

    @Test
    public void gameStateafterOneRound() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        game.playTurn();

        assertEquals("Y", game.active.sign);
        assertTrue(game.board.hasFreePlaces());
        assertEquals("X", game.board.places.get(0));
    }

    @Test
    public void playsAFullWonGame() throws IOException {
        game.board.putSignOnBoard(player, 0);
        game.board.putSignOnBoard(player, 1);
        String input1 = "2";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        game.run();

        assertTrue(game.board.isWon());
        assertFalse(game.board.isTie());
        assertEquals("X", game.board.winnerSign());
        assertTrue(game.board.hasFreePlaces());
    }

    @Test
    public void playsAFullTieGame() throws IOException {
        int[] array1 = {1, 3, 4, 6, 8};
        int[] array2 = {0, 2, 5, 7};
        playWholeGame(player, player2, array1, array2);

        game.run();

        assertFalse(game.board.isWon());
        assertTrue(game.board.isTie());
        assertEquals("none", game.board.winnerSign());
        assertFalse(game.board.hasFreePlaces());
    }

    @Test
    public void postGameTest() throws IOException {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.postGame();

        assertEquals("\n0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n\nIt's a tie!\n", outContent.toString());
    }

    public void playWholeGame(Player player, Player player2, int[] arraySign1, int[] arraySign2) {
        for(int i = 0; i < arraySign1.length; i++) {
            game.board.putSignOnBoard(player, arraySign1[i]);
        }
        for(int i = 0; i < arraySign2.length; i++) {
            game.board.putSignOnBoard(player2, arraySign2[i]);
        }
    }

}


