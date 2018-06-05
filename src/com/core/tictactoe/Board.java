package com.core.tictactoe;

import java.util.Arrays;

public class Board {

    private String[] places;

    public Board() {
        this.places = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
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

    public String[] getPlaces() {
        return this.places;
    }

    void putSignOnBoard(Player player, int userNumber) {
        this.places[userNumber-1] = player.getSign();
    }

    String valueAtIndex(int index) {
        return this.places[index];
    }

    boolean isWon() {
        for (int[] set : winningPositions) {
            String matcher = this.valueAtIndex(set[0]);
            int numberOfMatchesInSet = countMatchesInSet(set, matcher);
            if (numberOfMatchesInSet == set.length) return true;
        }
        return false;
    }

    boolean isTie() {
        return !this.isWon() && this.hasNoFreePlaces();
    }

    boolean isNonTaken(String position){
        return Arrays.asList(this.places).contains(position);
    }

    String winnerSign() {
        for (int[] set : winningPositions) {
            String matcher = this.valueAtIndex(set[0]);
            int numberOfMatchesInSet = countMatchesInSet(set, matcher);
            if (numberOfMatchesInSet == set.length) return matcher;
        }
        return "none";
    }

    private boolean hasNoFreePlaces() {
        String[] initialPlaces = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int numberOfEmptyPlaces = 0;
        for (String place : this.places) {
            if (Arrays.asList(initialPlaces).contains(place)) numberOfEmptyPlaces += 1;
        }
        return numberOfEmptyPlaces == 0;
    }

    private int countMatchesInSet(int[] set, String matcher) {
        int numberOfMatchedPairs = 0;
        for (int i = 0; i < set.length; i++) {
            if (this.valueAtIndex(set[i]).equals(matcher)) numberOfMatchedPairs ++;
        }
        return numberOfMatchedPairs;
    }
}
