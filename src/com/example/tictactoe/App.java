package com.example.tictactoe;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Displayer displayer = new Displayer();
        displayer.greetUsers();
        Game game = new Game(displayer);
        game.playGame();
    }
}