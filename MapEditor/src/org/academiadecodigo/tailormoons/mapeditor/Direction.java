package org.academiadecodigo.tailormoons.mapeditor;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private int deltaCol;
    private int deltaRow;

    Direction(int deltaCol, int deltaRow) {
        this.deltaCol = deltaCol;
        this.deltaRow = deltaRow;
    }

    public int getDeltaCol() {
        return deltaCol;
    }

    public int getDeltaRow() {
        return deltaRow;
    }


}
