package com.example.tictactoe;

public class Validator {

    Validator() {
    }

    public static boolean isNumeric(String position) {
        String regex = "[0-8]";
        return position.matches(regex) ? true : false;
    }

    public static boolean playAgainValid(String number) {
        String regex = "[1]";
        return number.matches(regex) ? true : false;
     //   return number == "1" || number == "2";
    }

    public static boolean exitValid(String number) {
        String regex = "[2]";
        return number.matches(regex) ? true : false;
    }

}
