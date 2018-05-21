package com.example.tictactoe;

public class App {

    Game game;

    App() {
        this.game = new Game();
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.game.board);
    }
}