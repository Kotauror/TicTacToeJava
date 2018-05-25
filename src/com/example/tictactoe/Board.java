package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    protected ArrayList places;

    Board() {
        this.places = new ArrayList<Integer>();
        fillPlaces();
    }

    int [][] winningPositions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

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
        for (int[] set : winningPositions) {
            if (this.places.get(set[0]) == this.places.get(set[1]) && this.places.get(set[0]) == this.places.get(set[2])) {
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
        for (int[] set : winningPositions) {
            if (this.places.get(set[0]) == this.places.get(set[1]) && this.places.get(set[0]) == this.places.get(set[2])) {
                return this.places.get(set[0]).toString();
            }
        }
        return "none";
    }
}
