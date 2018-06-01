package com.core.tictactoe;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    ArrayList places;

    Board() {
        this.places = new ArrayList<Integer>();
        fillPlaces();
    }

    private final int [][] winningPositions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private void fillPlaces() {
        Collections.addAll(this.places, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    private boolean hasFreePlaces() {
        int numberOfEmptyPlaces = 0;
        for(int i = 0; i < this.places.size(); i++) {
            if (this.places.contains(i)) numberOfEmptyPlaces += 1;
        }
        return numberOfEmptyPlaces != 0;
    }

    void putSignOnBoard(Player player, int position) {
        this.places.set(position, player.sign);
    }

    Object valueAtPosition(int position) {
        return this.places.get(position);
    }

    boolean isWon() {
        for (int[] set : winningPositions) {
            Object matcher = this.valueAtPosition(set[0]);
            int numberOfMatchedPairs = 0;
            for (int i = 1; i < set.length; i++) {
                if (this.valueAtPosition(set[i]).equals(matcher)) numberOfMatchedPairs ++;
            }
            if (numberOfMatchedPairs == set.length-1) return true;
        }
        return false;
    }

    boolean isTie() {
        return !this.isWon() && !this.hasFreePlaces();
    }

    boolean isNonTaken(String position){
        return this.places.contains(Integer.parseInt(position));
    }

    String winnerSign() {
        for (int[] set : winningPositions) {
            Object matcher = this.valueAtPosition(set[0]);
            int numberOfMatchedPairs = 0;
            for (int i = 1; i < set.length; i++) {
                if (this.valueAtPosition(set[i]).equals(matcher)) numberOfMatchedPairs ++;
            }
            if (numberOfMatchedPairs == set.length-1) return matcher.toString();
        }
        return "none";
    }
}
