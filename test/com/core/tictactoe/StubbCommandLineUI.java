package com.core.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StubbCommandLineUI extends CommandLineUI {


    public ArrayList inputs;

    public StubbCommandLineUI(PrintStream output, InputStream input, String[] fakeUsersInputs) {
        this.output = output;
        this.input = new Scanner(input);
        this.inputs = new ArrayList<String>();
        fillInputs(fakeUsersInputs);
    }

    private void fillInputs(String[] fakeUsersInputs) {
        for (int i = 0; i < fakeUsersInputs.length; i++) {
            Collections.addAll(this.inputs, fakeUsersInputs[i]);
        }
    }

    protected String getUserInput() {
        String first = this.inputs.get(0).toString();
        this.inputs.remove(0);
        return first;
    }

    protected void showBoard(Board board) {}

    protected void greetUsers() {}

    protected void askForPosition(Player player) {}

    protected void announceWinner(Board board) {}



}
