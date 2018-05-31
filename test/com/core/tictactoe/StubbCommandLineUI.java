package com.core.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StubbCommandLineUI extends CommandLineUI {


    public ArrayList numbers;

    public StubbCommandLineUI(PrintStream output, InputStream input) {
        this.output = output;
        this.input = new Scanner(input);
        this.numbers = new ArrayList<String>();
        fillNumbers();
    }

    private void fillNumbers() {
        Collections.addAll(this.numbers, "0", "1", "2", "3", "4", "5", "6", "7", "8");
    }

    protected String getUserInput() {
        String first = this.numbers.get(0).toString();
        this.numbers.remove(0);
        return first;
    }





}
