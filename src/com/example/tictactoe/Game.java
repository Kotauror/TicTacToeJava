package com.example.tictactoe;

public class Game {

    Board board;
    Displayer displayer;

    Game() {
        this.board = new Board();
        this.displayer = new Displayer();
    }
}
