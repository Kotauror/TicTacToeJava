package com.example.tictactoe;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Displayer displayer = new Displayer();
        Validator validator = new Validator();
        Game game = new Game(displayer, validator);
        game.playGame();
    }
}