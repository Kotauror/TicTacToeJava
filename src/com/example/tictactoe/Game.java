package com.example.tictactoe;

public class Game {

    Board board;
    Displayer displayer;
    Player playerOne;
    Player playerTwo;

    Game(Displayer displayer) {
        this.board = new Board();
        this.displayer = displayer;
        this.playerOne = new Player();
        this.playerTwo = new Player();
    }
}
