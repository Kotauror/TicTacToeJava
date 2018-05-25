package com.example.tictactoe;
import java.util.ArrayList;


public class Displayer {

    Displayer(){}

    public static void showBoard(ArrayList board) {
        System.out.println();
        System.out.println(board.get(0) + " | " + board.get(1) + " | " + board.get(2));
        System.out.println(board.get(3) + " | " + board.get(4) + " | " + board.get(5));
        System.out.println(board.get(6) + " | " + board.get(7) + " | " + board.get(8));
        System.out.println();
    }

    public static void greetUsers(){
        System.out.println("Hello and welcome to Tic-Tac-Toe");
    }

    public static void askForPosition(String sign) {
        System.out.println(sign + ", pick a position");
    }

    public static void askAgainForPosition(String sign) {
        System.out.println(sign + ", pick a non-taken number on board");
    }

    public static void announceWinner(String sign) {
        System.out.println(sign != null ? sign + " won!" : "It's a tie!");
    }

    public static void gamingMenu() {
        System.out.println("If you want to play type 1, if you want to exit type 2");
    }

}

