package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    public boolean won;
    public boolean tie;
    public boolean placesLeft;
    public ArrayList places;

    Board() {
        this.won = false;
        this.tie = false;
        this.placesLeft = true;
        this.places = new ArrayList<Integer>();
        fillPlaces();
    }

    public void fillPlaces() {
        Collections.addAll(this.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    public void putSignOnBoard(String sign, int position) {
        this.places.set(position, sign);
        this.checkForPlacesLeft();
        this.checkForWon();
        this.checkForTie();
    }

    public void checkForPlacesLeft() {

    }

    public void checkForWon() {

    }

    public void checkForTie() {
        if (!this.won && !this.placesLeft) {
            this.tie = true;
        }
    }
}
