package com.example.tictactoe;

public class App {

    public static void main(String[] args) {
        Displayer displayer = new Displayer();
        displayer.greetUsers();
        Game game = new Game(displayer);
        game.playGame();
    }
}