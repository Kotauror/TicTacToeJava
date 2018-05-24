package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
    public void postGameTest() throws IOException {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.postGame();

        assertEquals("\n0 | 1 | 2\n3 | 4 | 5\n6 | 7 | 8\n\nIt's a tie!\n", outContent.toString());
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


//    @Rule
//    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
//
//    @Test
//    public void expectSystemExit() {
//        exit.expectSystemExit();
//        game.playAgainMenu();
//    }

//    @Test
//    public void startsANewGameWhenPlayAgainInputCorrect () throws IOException {
//             String input = "1";
//             InputStream in = new ByteArrayInputStream(input.getBytes());
//             System.setIn(in);

//             Validator validatorSpy = Mockito.spy(game.validator);
//             Mockito.when(validatorSpy.playAgainValid("1")).thenReturn(true);
//            final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(outContent));
//            String input2 = "0";
//            InputStream in2 = new ByteArrayInputStream(input2.getBytes());
//            System.setIn(in2);
//            String input3 = "1";
//            InputStream in3 = new ByteArrayInputStream(input3.getBytes());
//            System.setIn(in3);
//            String input4= "2";
//            InputStream in4 = new ByteArrayInputStream(input4.getBytes());
//            System.setIn(in4);
//            String input5 = "2";
//            InputStream in5 = new ByteArrayInputStream(input5.getBytes());
//            System.setIn(in5);
//            int gameCode = System.identityHashCode(game);
//
//            game.playAgainMenu();
//            verify(game, times(1)).playANewGame();


            // int gameCode = System.identityHashCode(game);
           // assertEquals(true, game.board.hasPlacesLeft);



//    }

}




