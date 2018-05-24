package com.example.tictactoe;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Displayer displayer = new Displayer();
        GamesController gamesController  = new GamesController(displayer);
        gamesController.gamesMenu();
    }
}