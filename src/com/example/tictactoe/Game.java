package com.example.tictactoe;

import java.io.IOException;

public class Game {

    Board board;
    Displayer displayer;
    Player playerOne;
    Player playerTwo;
    public Player active;
    public Player passive;
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
            // validation
            this.board.putSignOnBoard(this.active.sign, position);
            this.switchPlayers();
        }
    }

    public void switchPlayers() {
        if (this.active == this.playerOne) {
            this.active = this.playerTwo;
            this.passive = this.playerOne;
        } else {
            this.passive = this.playerTwo;
            this.active = this.playerOne;
        }
    }

}
