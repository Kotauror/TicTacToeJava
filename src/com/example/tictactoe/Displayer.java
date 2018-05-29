package com.example.tictactoe;
public class Displayer {

    Displayer(){}

    protected void showBoard(Board board) {
        System.out.println();
        System.out.println(board.places.get(0) + " | " + board.places.get(1) + " | " + board.places.get(2));
        System.out.println(board.places.get(3) + " | " + board.places.get(4) + " | " + board.places.get(5));
        System.out.println(board.places.get(6) + " | " + board.places.get(7) + " | " + board.places.get(8));
        System.out.println();
    }

    protected void greetUsers(){
        System.out.println("Hello and welcome to Tic-Tac-Toe");
    }

    protected void askForPosition(Player player) {
        System.out.println(player.sign + ", pick a position");
    }

   // protected void askAgainForPosition(String sign) {
     //   System.out.println(sign + ", pick a non-taken number on board");
   // }

    protected void announceWinner(Board board) {
        System.out.println(board.winnerSign() != "none" ? board.winnerSign() + " won!" : "It's a tie!");
    }

    protected void gamingMenu() {
        System.out.println("If you want to play type 1, if you want to exit type 2");
    }

}

