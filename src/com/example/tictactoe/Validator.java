package com.example.tictactoe;

public class Validator {

    public static boolean isNumeric(String position) {
        String regex = "[0-8]";
        return position.matches(regex) ? true : false;
    }
}
