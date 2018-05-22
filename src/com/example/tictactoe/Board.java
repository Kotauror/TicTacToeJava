package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;


public class Board {

    public boolean won;
    public boolean tie;
    public boolean placesLeft;
    public ArrayList places;
//    public String winnerSign;

    Board() {
        this.won = false;
        this.tie = false;
        this.placesLeft = true;
        this.places = new ArrayList<Integer>();
//        this.winnerSign = "N";
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
        int numberOfEmptyPlaces = 0;
        for(int i = 0; i < 9; i++) {
            if (this.places.contains(i)) numberOfEmptyPlaces += 1;
        }
        if (numberOfEmptyPlaces == 0) this.placesLeft = false;
    }

    public void checkForWon() {
        // Stream.of(0, 1, 2).map(i -> this.places.get(i)).all
        if (this.places.get(0) == this.places.get(1) && this.places.get(0) == this.places.get(2) && this.places.get(1) == this.places.get(2)) {
            this.won = true;
//            this.winnerSign = this.places.get(0).toString().charAt(0);
        }
        if (this.places.get(3) == this.places.get(4) && this.places.get(3) == this.places.get(5) && this.places.get(4) == this.places.get(5)) {
            this.won = true;
//            this.winnerSign = this.places.get(3).toString().charAt(0);
        }
        if (this.places.get(6) == this.places.get(7) && this.places.get(6) == this.places.get(8) && this.places.get(7) == this.places.get(8)) {
            this.won = true;
//            this.winnerSign = this.places.get(6).toString().charAt(0);
        }
        if (this.places.get(0) == this.places.get(3) && this.places.get(0) == this.places.get(6) && this.places.get(3) == this.places.get(6)) {
            this.won = true;
//            this.winnerSign = this.places.get(0).toString().charAt(0);
        }
        if (this.places.get(1) == this.places.get(4) && this.places.get(1) == this.places.get(7) && this.places.get(4) == this.places.get(7)) {
            this.won = true;
//            this.winnerSign = this.places.get(1).toString().charAt(0);
        }
        if (this.places.get(2) == this.places.get(5) && this.places.get(2) == this.places.get(8) && this.places.get(5) == this.places.get(8)) {
            this.won = true;
//            this.winnerSign = this.places.get(2).toString().charAt(0);
        }
        if (this.places.get(0) == this.places.get(4) && this.places.get(0) == this.places.get(8) && this.places.get(4) == this.places.get(8)) {
            this.won = true;
//            this.winnerSign = this.places.get(0).toString().charAt(0);
        }
        if (this.places.get(2) == this.places.get(4) && this.places.get(2) == this.places.get(6) && this.places.get(4) == this.places.get(6)) {
            this.won = true;
//            this.winnerSign = this.places.get(2).toString().charAt(0);
        }


    }

    public void checkForTie() {
        if (!this.won && !this.placesLeft) {
            this.tie = true;
        }
    }
}
