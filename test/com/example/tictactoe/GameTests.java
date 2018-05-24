package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTests {

    public static Game game;

    @BeforeEach
    public void createInstance() { game = new Game(new Displayer()); }

    @Test
    public void GameCreatesAnInstanceOfBoard() {
        assertThat(game.board,isA(Board.class));
    }

    @Test
    public void GameCreatesAnInstanceOfPlayer() {
        assertThat(game.active,isA(Player.class));
        assertThat(game.passive,isA(Player.class));
    }

    @Test
    public void GameHasAnInstanceOfDisplayer() {
        assertThat(game.displayer,isA(Displayer.class));
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
    public void returnsPositionGivenByPlayerWhenValid() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(0, game.getPositionFromUser());
    }

    @Test
    public void returnsOnlyTheCorrectValuesWhenGettingAWrongPosition1() throws IOException {
        String input = "J";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String inputTwo = "0";
        InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
        System.setIn(inTwo);

        assertEquals(0, game.getPositionFromUser());
    }

    @Test
    public void returnsOnlyTheCorrectValuesWhenGettingAPosition2() throws IOException {
        game.board.putSignOnBoard("X", 0);
         String input = "0";
         InputStream in = new ByteArrayInputStream(input.getBytes());
         System.setIn(in);
        String inputTwo = "1";
        InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
        System.setIn(inTwo);

        assertEquals(1, game.getPositionFromUser());
    }

    @Test
    public void afterOneRound() throws IOException {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        game.playOneRound();

        assertEquals("Y", game.active.sign);
        assertTrue(game.board.hasPlacesLeft);
        assertEquals("X", game.board.places.get(0));
    }

    @Test
    public void fullGamePlayer() throws IOException {
        game.board.putSignOnBoard("X", 0);
        game.board.putSignOnBoard("X", 1);
        String input1 = "2";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        game.playGame();

        assertEquals(true, game.board.won);
        assertEquals("X", game.board.winnerSign);
        assertEquals(true, game.board.hasPlacesLeft);
    }

    @Test
    public void postGameTest() throws IOException {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.postGame();

        assertEquals("\n0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n\nIt's a tie!\n", outContent.toString());
    }
}




