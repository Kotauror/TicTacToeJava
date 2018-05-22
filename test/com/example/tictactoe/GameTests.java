package com.example.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;


public class GameTests {

    public static Game game;

    @BeforeAll
    public static void createInstance() {
        game = new Game(new Displayer());
    }

    @Test
    public void Game_creates_an_instance_of_board() {
        assertThat(game.board,isA(Board.class));
    }

    @Test
    public void Game_creates_an_instance_of_player() {
        assertThat(game.playerOne,isA(Player.class));
        assertThat(game.playerTwo,isA(Player.class));
    }

    @Test
    public void Game_has_an_instance_of_displayer() {
        assertThat(game.displayer,isA(Displayer.class));
    }


}




