package com.example.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameTests {

    public Game game;

    @Test
    public void Game_creates_an_instance_of_board() {
        game = new Game();
        assertThat(game.board,isA(Board.class));

    }


}




