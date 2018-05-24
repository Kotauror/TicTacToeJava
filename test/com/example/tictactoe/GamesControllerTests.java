package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GamesControllerTests {

    public GamesController gamesController;

    @BeforeEach
    public void instantiate() {
        gamesController = new GamesController(new Displayer());
    }

    @Test
    public void gamesControllerHasDisplayer() {
        assertThat(gamesController.displayer,isA(Displayer.class));
    }

    @Test
    public void gamesMenuReturnsUserString() {
        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("6", gamesController.getUserOption());
    }

    @Test
    public void option1playsANewGame() {
        GamesController spy = Mockito.spy(gamesController);
        Mockito.doNothing().when(spy).playANewGame();
        spy.actOnOption("1");

        verify(spy, times(1)).playANewGame();
    }

    @Test
    public void option2DoesntPlayGame() {
        GamesController spy = Mockito.spy(gamesController);
        spy.actOnOption("2");

        verify(spy, times(0)).playANewGame();
    }

}
