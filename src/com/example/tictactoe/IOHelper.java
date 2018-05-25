package com.example.tictactoe;


import java.util.Scanner;

public class IOHelper {

    protected String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();
        return position;
    }

}
