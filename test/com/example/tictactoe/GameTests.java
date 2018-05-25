package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class GameTests {

    public static Game game;

    @BeforeEach
    public void createInstance() {
        game = new Game(new Displayer(), new IOHelper(), new Validator());
    }

    @Test
    public void GameCreatesAnInstanceOfBoard() {
        assertThat(game.board, isA(Board.class));
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
        game.board.putSignOnBoard("X", 0);

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
        game.board.putSignOnBoard("X", 0);
        game.board.putSignOnBoard("X", 1);
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
        game.board.putSignOnBoard("Y", 0);
        game.board.putSignOnBoard("X", 1);
        game.board.putSignOnBoard("Y", 2);
        game.board.putSignOnBoard("X", 3);
        game.board.putSignOnBoard("X", 4);
        game.board.putSignOnBoard("Y", 5);
        game.board.putSignOnBoard("X", 6);
        game.board.putSignOnBoard("Y", 7);
        String input1 = "8";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

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

}


