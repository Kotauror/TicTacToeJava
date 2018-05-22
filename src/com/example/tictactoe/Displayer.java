package com.example.tictactoe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Displayer {

    Displayer(){}

    public void showBoard(ArrayList board) {
        System.out.println(board.get(0) + " | " + board.get(1) + " | " + board.get(2));
        System.out.println(board.get(3) + " | " + board.get(4) + " | " + board.get(5));
        System.out.println(board.get(6) + " | " + board.get(7) + " | " + board.get(8));
    }

    public void greetUsers(){
        System.out.println("Hello and welcome to Tic-Tac-Toe");
    }

    public int askForPosition() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a position");
        String position = scanner.nextLine();
        return Integer.parseInt(position);
    }
}

