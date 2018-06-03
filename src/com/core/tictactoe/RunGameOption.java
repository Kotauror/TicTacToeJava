package com.core.tictactoe;

public class RunGameOption extends GameOption {

    @Override
    public void run() {
        Game game = new Game(new CommandLineUI(System.out, System.in), new Board());
        game.run();
    }
}
