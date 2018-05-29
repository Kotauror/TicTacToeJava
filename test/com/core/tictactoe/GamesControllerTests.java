package com.core.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GamesControllerTests {

    public GamesController gamesController;

    @BeforeEach
    public void instantiate() {
        gamesController = new GamesController(new CommandLineUI(System.out));
    }

    @Test
    public void GameCreatesAnInstanceOfDisplayer() {
        assertThat(gamesController.commandLineUI, isA(CommandLineUI.class));
    }

    @Test
    public void actOnOptionReturnsTrueOn1() {
        GamesController spy = Mockito.spy(gamesController);
        Mockito.doNothing().when(spy).playANewGame();

        assertEquals(true, spy.actOnOption("1"));
    }

    @Test
    public void actOnOnptionReturnsFalseOn2() {
        assertEquals(false, gamesController.actOnOption("2"));
    }

    @Test
    public void actOnOptionReturnsTrueOnNot1or2() {
        assertEquals(true, gamesController.actOnOption("test"));
    }

    @Test
    public void getUserOptionReturnsUsersOption() {
        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("6", gamesController.getUserOption());
    }

    @Test
    public void option1CallsPlayANewGame() {
        GamesController spy = Mockito.spy(gamesController);
        Mockito.doNothing().when(spy).playANewGame();
        spy.actOnOption("1");

        verify(spy, times(1)).playANewGame();
    }

    @Test
    public void optionsOtherThen1DontCallPlayANewGame() {
        GamesController spy = Mockito.spy(gamesController);
        spy.actOnOption("5");

        verify(spy, times(0)).playANewGame();
    }

    @Test
    public void gamesMenuStopsOnFalse() {
        GamesController spy = Mockito.spy(gamesController);
        Mockito.doReturn("2").when(spy).getUserOption();
        Mockito.doReturn(false).when(spy).actOnOption("2");

        spy.gamesMenu();

        verify(spy, times(1)).getUserOption();
        verify(spy, times(1)).actOnOption("2");
    }
}
