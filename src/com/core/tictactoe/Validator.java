package com.core.tictactoe;

public class Validator {

    Validator() {
    }

    protected boolean isNumeric(String position) {
        String regex = "[0-8]";
        return position.matches(regex) ? true : false;
    }

    protected boolean playAgainValid(String number) {
        String regex = "[1]";
        return number.matches(regex) ? true : false;
    }

    protected boolean exitValid(String number) {
        String regex = "[2]";
        return number.matches(regex) ? true : false;
    }

}
