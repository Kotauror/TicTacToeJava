package com.example.tictactoe;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        GamesController gamesController  = new GamesController();
        gamesController.gamesMenu();
    }
}