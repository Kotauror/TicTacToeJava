package com.example.tictactoe;

public class Game {

    Board board;
    Displayer displayer;
    Player playerOne;
    Player playerTwo;
    public boolean over;


    Game(Displayer displayer) {
        this.board = new Board();
        this.displayer = displayer;
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.over = false;
    }

    public void playGame() {
        if (!this.over) {
            this.displayer.showBoard(this.board.places);
        }
    }
}
