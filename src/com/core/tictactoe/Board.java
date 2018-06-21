package com.core.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private String[] places;
    private int size;
    private static String FIRST_PLAYER_SIGN = "X";
    private static String SECOND_PLAYER_SIGN = "O";

    public Board(String[] places) {
        this.places = places.clone();
    }

    public Board(int size) {
        this.size = size;
        this.places = createPlaces(size);
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

    String[] getPlaces() {
        return this.places;
    }

    void putSignOnBoard(String sign, int userNumber) {
        this.places[userNumber-1] = sign;
    }

    String valueAtIndex(int index) {
        return this.places[index];
    }

    boolean isWon() {
        String winnerSign = winnerSign();
        return !winnerSign.equals("none");
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

    String[] getFreePlaces() {
        ArrayList<String> freePlaces = new ArrayList<>();
        for (String place : this.places) {
            if (!place.equals(FIRST_PLAYER_SIGN) && !place.equals(SECOND_PLAYER_SIGN)) freePlaces.add(place);
        }
        return freePlaces.toArray(new String[0]);
    }

    String getActivePlayerSign() {
        String[] freePlaces = getFreePlaces();
        return freePlaces.length % 2 != 0 ? FIRST_PLAYER_SIGN : SECOND_PLAYER_SIGN;
    }

    String getPassivePlayerSign() {
        String activePlayerSign = getActivePlayerSign();
        return activePlayerSign.equals(FIRST_PLAYER_SIGN) ? SECOND_PLAYER_SIGN : FIRST_PLAYER_SIGN;
    }

    String[][] getAllVectors() {
        ArrayList<String[]> vectors = new ArrayList<>();

        String[][] rowsInBoard = getRowsInBoard();
        vectors.addAll(Arrays.asList(rowsInBoard));

        String[][] columnsInBoard = getColumnsInBoard(rowsInBoard);
        vectors.addAll(Arrays.asList(columnsInBoard));

        vectors.add(this.getTopLeftDiagonal(rowsInBoard));
        vectors.add(this.getTopRightDiagonal(rowsInBoard));

        return vectors.toArray(new String[0][0]);
    }

    private String[][] getRowsInBoard() {
        return this.createArrayOfVectors(this.places);
    }

    private String[][] getColumnsInBoard(String[][] rowsInBoard) {
        int currentColumn = 0;
        ArrayList<String> columnsArray = new ArrayList<>();
        while (currentColumn < this.size) {
            for (String[] row : rowsInBoard) {
                columnsArray.add(row[currentColumn]);
            }
            currentColumn++;
        }
        return createArrayOfVectors(columnsArray.toArray(new String[0]));
    }

    private String[] getTopLeftDiagonal(String[][] rowsInBoard) {
        ArrayList<String> diagonalVector = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            diagonalVector.add(rowsInBoard[i][i]);
        }
        return diagonalVector.toArray(new String[0]);
    }

    private String[] getTopRightDiagonal(String[][] rowsInBoard) {
        ArrayList<String> diagonalVector = new ArrayList<>();
        int indexOfPlaceInRow = this.size-1;
        for (int i = 0; i < this.size; i++) {
            diagonalVector.add(rowsInBoard[i][indexOfPlaceInRow]);
            indexOfPlaceInRow--;
        }
        return diagonalVector.toArray(new String[0]);
    }

    private String[][] createArrayOfVectors(String[] array) {
        String[][] arrayOfVectors = new String[this.size][];
        int currentVector = 0;
        int vectorStartIndex = 0;
        int vectorEndIndex = this.size;
        while (currentVector < this.size) {
            arrayOfVectors[currentVector] = Arrays.copyOfRange(array, vectorStartIndex, vectorEndIndex);
            vectorStartIndex = vectorEndIndex;
            vectorEndIndex = vectorStartIndex + this.size;
            currentVector++;
        }
        return arrayOfVectors;
    }

    private String[] createPlaces(int size) {
        int numberOfPlacesOnBoard = size * size;
        ArrayList<String> places = new ArrayList<>();
        for (int i = 1; i <= numberOfPlacesOnBoard; i++) {
            places.add(String.valueOf(i));
        }
        return places.toArray(new String[0]);
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
