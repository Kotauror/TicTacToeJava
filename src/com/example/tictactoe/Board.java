package com.example.tictactoe;

import java.util.ArrayList;

public class Board {

    public boolean finished;
    public ArrayList places;

    Board() {
        this.finished = false;
        this.places = new ArrayList<Integer>();
    }
}
