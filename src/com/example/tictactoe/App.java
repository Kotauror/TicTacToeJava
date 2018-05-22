package com.example.tictactoe;

public class App {

    public static void main(String[] args) {
        Displayer displayer = new Displayer();
        Game game = new Game(displayer);
        game.board.fillPlaces();
        game.displayer.showBoard(game.board.places);
    }
}