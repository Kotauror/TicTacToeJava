package com.example.tictactoe;
import java.util.ArrayList;


public class Displayer {

    Displayer(){}

    public void showBoard(ArrayList board) {
        System.out.println(board);
    }

    public void greetUsers(){
        System.out.println("Hello and welcome to Tic-Tac-Toe");
    }
}
