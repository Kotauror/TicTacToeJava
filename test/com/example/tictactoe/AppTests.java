package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.tictactoe.GameTests.game;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTests {

    public App app;

    @BeforeEach
    public void instantiateApp() {
        app = new App();
    }

}
