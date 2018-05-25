package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    protected ArrayList places;

    Board() {
        this.places = new ArrayList<Integer>();
        fillPlaces();
    }

    protected void fillPlaces() {
        Collections.addAll(this.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    protected void putSignOnBoard(String sign, int position) {
        this.places.set(position, sign);
    }

    protected boolean hasPlacesLeft() {
        int numberOfEmptyPlaces = 0;
        for(int i = 0; i < this.places.size(); i++) {
            if (this.places.contains(i)) numberOfEmptyPlaces += 1;
        }
        return numberOfEmptyPlaces != 0;
    }

    protected boolean isWon() {
        Object [][] sets = {
                {this.places.get(0), this.places.get(1), this.places.get(2)},
                {this.places.get(3), this.places.get(4), this.places.get(5)},
                {this.places.get(6), this.places.get(7), this.places.get(8)},
                {this.places.get(0), this.places.get(3), this.places.get(6)},
                {this.places.get(1), this.places.get(4), this.places.get(7)},
                {this.places.get(2), this.places.get(5), this.places.get(8)},
                {this.places.get(0), this.places.get(4), this.places.get(8)},
                {this.places.get(2), this.places.get(4), this.places.get(6)}
        };
        for (Object[] set : sets) {
            if (set[0] == set[1] && set[0] == set[2]) {
                return true;
            }
        }
        return false;
    }

    protected boolean isTie() {
        return !this.isWon() && !this.hasPlacesLeft();
    }

    protected boolean isNonTaken(String position){
        return this.places.contains(Integer.parseInt(position));
    }

    protected String winnerSign() {
        Object[][] sets = {
                {this.places.get(0), this.places.get(1), this.places.get(2)},
                {this.places.get(3), this.places.get(4), this.places.get(5)},
                {this.places.get(6), this.places.get(7), this.places.get(8)},
                {this.places.get(0), this.places.get(3), this.places.get(6)},
                {this.places.get(1), this.places.get(4), this.places.get(7)},
                {this.places.get(2), this.places.get(5), this.places.get(8)},
                {this.places.get(0), this.places.get(4), this.places.get(8)},
                {this.places.get(2), this.places.get(4), this.places.get(6)}
        };
        for (Object[] set : sets) {
            if (set[0] == set[1] && set[0] == set[2]) {
                return set[0].toString();
            }
        }
        return "none";
    }
}
