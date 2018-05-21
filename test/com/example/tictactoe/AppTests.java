package com.example.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AppTests {

    public App app;

    @Test
    public void App_creates_an_instance_of_game() {
        app = new App();
        assertThat(app.game,isA(Game.class));
        assertThat(app.game.board,isA(Board.class));
    }
}
