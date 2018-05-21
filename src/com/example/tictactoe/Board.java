package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    public boolean finished;
    public ArrayList places;

    Board() {
        this.finished = false;
        this.places = new ArrayList<Integer>();
    }

    public void fillPlaces() {
        Collections.addAll(this.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }
}
