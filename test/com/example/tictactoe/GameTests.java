package com.example.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTests {

    public static Game game;

    @BeforeAll
    public static void createInstance() { game = new Game(new Displayer(), new Validator()); }

    @Test
    public void GameCreatesAnInstanceOfBoard() {
        assertThat(game.board,isA(Board.class));
    }

    @Test
    public void GameCreatesAnInstanceOfPlayer() {
        assertThat(game.playerOne,isA(Player.class));
        assertThat(game.playerTwo,isA(Player.class));
    }

    @Test
    public void GameHasActivePlayerOne() {
        assertEquals(game.playerOne, game.active);
    }

    @Test
    public void GameHasPassivePlayerTwo() {
        assertEquals(game.playerTwo, game.passive);
    }

    @Test
    public void GameHasAnInstanceOfDisplayer() {
        assertThat(game.displayer,isA(Displayer.class));
    }

    @Test
    public void GameHasAnInstanceOfValidator() { assertThat(game.validator,isA(Validator.class));}

    @Test
    public void switchesActivePlayer() {
        game.switchPlayers();

        assertEquals(game.playerTwo, game.active);
        assertEquals(game.playerOne, game.passive);
    }

}




