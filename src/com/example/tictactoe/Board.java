package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    public boolean won;
    public boolean tie;
    public boolean placesLeft;
    public ArrayList places;
    public String winnerSign;

    Board() {
        this.won = false;
        this.tie = false;
        this.placesLeft = true;
        this.places = new ArrayList<Integer>();
        this.winnerSign = "N";
        fillPlaces();
    }

    public void fillPlaces() {
        Collections.addAll(this.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    public void putSignOnBoard(String sign, int position) {
        this.places.set(position, sign);
        this.placesLeftCheck();
        this.wonStatusCheck();
        this.tieStatusCheck();
    }

    public void placesLeftCheck() {
        int numberOfEmptyPlaces = 0;
        for(int i = 0; i < this.places.size(); i++) {
            if (this.places.contains(i)) numberOfEmptyPlaces += 1;
        }
        if (numberOfEmptyPlaces == 0) this.placesLeft = false;
    }

    public void wonStatusCheck() {
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
        for(int i = 0; i < sets.length; i++) {
            if (sets[i][0] == sets[i][1] && sets[i][0] == sets[i][2]) {
                this.won = true;
                this.winnerSign = sets[i][0].toString();
            }
        }
    }

    public void tieStatusCheck() {
        if (!this.won && !this.placesLeft) { this.tie = true; }
    }

    public boolean isNonTaken(String position){
        return this.places.contains(Integer.parseInt(position));
    }
}
