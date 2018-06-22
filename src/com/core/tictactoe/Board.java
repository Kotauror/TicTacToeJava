package com.core.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class Board {

    private String[] places;
    private int size;
    private static String FIRST_PLAYER_SIGN = "X";
    private static String SECOND_PLAYER_SIGN = "O";

    public Board(String[] places) {
        this.places = places.clone();
        this.size = this.countSize();
    }

    public Board(int size) {
        this.size = size;
        this.places = createPlaces(size);
    }

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
        String[][] lines = this.getAllLines();
        for (String[] line : lines) {
            String currentSign = line[0];
            int signsInLine = countCurrentSignsInLine(line, currentSign);
            if (this.lineHasAWinner(signsInLine)) return currentSign;
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

    String[][] getRowsInBoard() {
        String[][] arrayOfRows = new String[this.size][];
        int currentRow = 0;
        for (int i = 0; i < this.places.length; i+= size) {
            arrayOfRows[currentRow] = Arrays.copyOfRange(this.places, i, i + this.size);
            currentRow++;
        }
        return arrayOfRows;
    }

    private String[][] getAllLines() {
        ArrayList<String[]> allLinesInBoard = new ArrayList<>();
        String[][] rowsInBoard = getRowsInBoard();

        allLinesInBoard.addAll(Arrays.asList(rowsInBoard));
        allLinesInBoard.addAll(Arrays.asList(getColumnsInBoard(rowsInBoard)));
        allLinesInBoard.add(this.getTopLeftDiagonal(rowsInBoard));
        allLinesInBoard.add(this.getTopRightDiagonal(rowsInBoard));

        return allLinesInBoard.toArray(new String[0][0]);
    }

    private String[][] getColumnsInBoard(String[][] rowsInBoard) {
        ArrayList<String[]> columnsArray = new ArrayList<>();
        IntStream.range(0, this.size).forEach(i -> addColumnToColumnsArray(i, columnsArray, rowsInBoard));
        return columnsArray.toArray(new String[0][0]);
    }

    private void addColumnToColumnsArray(int i, ArrayList<String[]> columnsArray, String[][] rowsInBoard) {
        String[] column = new String[this.size];
        int indexOfElementInColumn = 0;
        for (String[] row : rowsInBoard) {
            column[indexOfElementInColumn] = row[i];
            indexOfElementInColumn++;
        }
        columnsArray.add(column);
    }

    private String[] getTopLeftDiagonal(String[][] rowsInBoard) {
        String[] diagonalLine = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            diagonalLine[i] = (rowsInBoard[i][i]);
        }
        return diagonalLine;
    }

    private String[] getTopRightDiagonal(String[][] rowsInBoard) {
        String[] diagonalLine = new String[this.size];
        int indexOfPlaceInRow = this.size - 1;
        for (int i = 0; i < this.size; i++) {
            diagonalLine[i] = rowsInBoard[i][indexOfPlaceInRow];
            indexOfPlaceInRow--;
        }
        return diagonalLine;
    }

    private String[] createPlaces(int size) {
        int numberOfPlacesOnBoard = size * size;
        ArrayList<String> places = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfPlacesOnBoard).forEach(i -> places.add(String.valueOf(i)));
        return places.toArray(new String[0]);
    }

    private boolean hasNoFreePlaces() {
        int numberOfEmptyPlaces = 0;
        for (String place : this.places) {
            if (!place.equals(FIRST_PLAYER_SIGN) && !place.equals(SECOND_PLAYER_SIGN)) numberOfEmptyPlaces += 1;
        }
        return numberOfEmptyPlaces == 0;
    }

    private int countCurrentSignsInLine(String[] line, String currentSign) {
        int numberOfCurrentSignsInLine = 0;
        for (String aPlaceInLine : line) {
            if (aPlaceInLine.equals(currentSign)) numberOfCurrentSignsInLine++;
        }
        return numberOfCurrentSignsInLine;
    }

    private int countSize() {
        Double boardSize = sqrt(this.places.length);
        return boardSize.intValue();
    }

    private boolean lineHasAWinner(int signsInLine) {
        return signsInLine == this.size;
    }
}
