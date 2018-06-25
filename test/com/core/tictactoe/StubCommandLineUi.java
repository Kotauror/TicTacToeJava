package com.core.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StubCommandLineUi extends CommandLineUi {

    private ArrayList inputs;

    public StubCommandLineUi(PrintStream output, InputStream input, String[] fakeUsersInputs) {
        this.output = output;
        this.input = new Scanner(input);
        this.inputs = new ArrayList<String>();
        fillInputs(fakeUsersInputs);
    }

    private void fillInputs(String[] fakeUsersInputs) {
        for (String fakeUsersInput : fakeUsersInputs) {
            Collections.addAll(this.inputs, fakeUsersInput);
        }
    }

    protected String getUserInput() {
        String first = this.inputs.get(0).toString();
        this.inputs.remove(0);
        return first;
    }

    protected void showBoard(Board board) {}

    protected void greetUsers() {}

    protected void announceWinner(Board board) {}

    void printImRandomizing() {
        output.println("Im randomizing");
    }

    void printImminimaxing() {
        output.println("Im minimaxing");
    }
}

