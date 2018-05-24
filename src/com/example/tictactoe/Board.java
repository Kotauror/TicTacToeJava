package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    public boolean won;
    public boolean tie;
    public boolean hasPlacesLeft;
    public ArrayList places;
    public String winnerSign;

    Board() {
        this.won = false;
        this.tie = false;
        this.hasPlacesLeft = true;
        this.places = new ArrayList<Integer>();
        this.winnerSign = "N";
        fillPlaces();
    }

    protected void fillPlaces() {
        Collections.addAll(this.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    protected void putSignOnBoard(String sign, int position) {
        this.places.set(position, sign);
        this.placesLeftCheck();
        this.wonStatusCheck();
        this.tieStatusCheck();
    }

    protected void placesLeftCheck() {
        int numberOfEmptyPlaces = 0;
        for(int i = 0; i < this.places.size(); i++) {
            if (this.places.contains(i)) numberOfEmptyPlaces += 1;
        }
        if (numberOfEmptyPlaces == 0) this.hasPlacesLeft = false;
    }

    protected void wonStatusCheck() {
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
                this.won = true;
                this.winnerSign = set[0].toString();
            }
        }
    }

    protected void tieStatusCheck() {
        if (!this.won && !this.hasPlacesLeft) { this.tie = true; }
    }

    protected boolean isNonTaken(String position){
        return this.places.contains(Integer.parseInt(position));
    }
}
