package com.core.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private String[] places;
    private static String FIRST_PLAYER_SIGN = "X";
    private static String SECOND_PLAYER_SIGN = "O";

    public Board(String[] places) {
        this.places = places.clone();
    }

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

    void putSignOnBoard(String sign, int userNumber) {
        this.places[userNumber-1] = sign;
    }

    String valueAtIndex(int index) {
        return this.places[index];
    }

    boolean isWon() {
        for (int[] winPath : winningPositions) {
            String currentSign = this.valueAtIndex(winPath[0]);
            int currentSignsInWinPath = countCurrentSignsInWinPath(winPath, currentSign);
            if (currentSignsInWinPath == winPath.length) return true;
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
        for (int[] winPath : winningPositions) {
            String currentSign = this.valueAtIndex(winPath[0]);
            int currentSignsInWinPath = countCurrentSignsInWinPath(winPath, currentSign);
            if (currentSignsInWinPath == winPath.length) return currentSign;
        }
        return "none";
    }

    ArrayList<String> getFreePlaces() {
        String[] initialPlaces = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayList<String> freePlaces = new ArrayList<String>();
        for (String place : this.places) {
            if (Arrays.asList(initialPlaces).contains(place)) {
                freePlaces.add(place);
            }
        }
        return freePlaces;
    }

    String getActivePlayerSign() {
        ArrayList<String> freePlaces = getFreePlaces();
        return freePlaces.size() % 2 != 0 ? FIRST_PLAYER_SIGN : SECOND_PLAYER_SIGN;
    }

    String getPassivePlayerSign() {
        String activePlayerSign = getActivePlayerSign();
        return activePlayerSign.equals(FIRST_PLAYER_SIGN) ? SECOND_PLAYER_SIGN : FIRST_PLAYER_SIGN;
    }

    private boolean hasNoFreePlaces() {
        int numberOfEmptyPlaces = 0;
        for (String place : this.places) {
            if (!place.equals(FIRST_PLAYER_SIGN) && !place.equals(SECOND_PLAYER_SIGN)) numberOfEmptyPlaces += 1;
        }
        return numberOfEmptyPlaces == 0;
    }

    private int countCurrentSignsInWinPath(int[] winPath, String currentSign) {
        int numberOfCurrentSignsInWinPath = 0;
        for (int aPlaceInWinPath : winPath) {
            if (this.valueAtIndex(aPlaceInWinPath).equals(currentSign)) numberOfCurrentSignsInWinPath++;
        }
        return numberOfCurrentSignsInWinPath;
    }
}
