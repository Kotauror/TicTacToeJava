package com.example.tictactoe;

import java.io.IOException;

public class Game {

    public Player active;
    public Player passive;
    Board board;
    Displayer displayer;
    Player playerOne;
    Player playerTwo;
    public boolean over;


    Game(Displayer displayer) {
        this.board = new Board();
        this.displayer = displayer;
        this.playerOne = new Player("X");
        this.playerTwo = new Player("Y");
        this.active = playerOne;
        this.passive = playerTwo;
        this.over = false;
    }

    public void playGame() throws IOException {
        if (!this.over) {
            this.displayer.showBoard(this.board.places);
            int position = this.displayer.askForPosition();
        }
    }

}
