package com.example.tictactoe;

public class Game {

    Board board;
    Displayer displayer;

    Game(Displayer displayer) {
        this.board = new Board();
        this.displayer = displayer;
    }
}
