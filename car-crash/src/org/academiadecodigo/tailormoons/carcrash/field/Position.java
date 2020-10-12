package org.academiadecodigo.tailormoons.carcrash.field;

import org.academiadecodigo.tailormoons.carcrash.Directions;

public class Position {

    private int row = (int) (Math.random() * Field.getHeight());
    private int column = (int) (Math.random() * Field.getWidth());

    public void move(Directions direction) {
        switch (direction) {
            case UP:
                if (row > 0) {
                    row--;
                }
                break;
            case DOWN:
                if (row < Field.getHeight() - 1) {
                    row++;
                }
                break;
            case LEFT:
                if (column > 0) {

                    column--;
                }
                break;
            case RIGHT:
                if (column < Field.getWidth() - 1) {
                    column++;
                }
                break;
            case UP_AND_RIGHT:
                if (row > 0 && column < Field.getWidth()) {
                    row--;
                    column++;
                }
                break;
            case UP_AND_LEFT:
                if (row > 0 && column > 0) {
                    row--;
                    column--;
                }
                break;
            case DOWN_AND_LEFT:
                if (row < Field.getHeight() - 1 && column > 0) {
                    row++;
                    column--;
                }
                break;
            case DOWN_AND_RIGHT:
                if (row < Field.getHeight() - 1 && column < Field.getWidth() - 1) {
                    row++;
                    column++;
                }

                break;
        }
    }

    public boolean overlaps(Position compare) {
        return column == compare.column && row == compare.row;
    }

    public boolean onEdge(Directions direction) {

        return ((row == 0 || column == 0) && direction == Directions.UP_AND_LEFT) || ((row == 0 || column == Field.getWidth()-1) && direction == Directions.UP_AND_RIGHT)
                || ((row == Field.getHeight()-1 || column == Field.getWidth()-1) && direction == Directions.DOWN_AND_RIGHT)
                || ((row == Field.getHeight()-1 || column == 0) && direction == Directions.DOWN_AND_LEFT)
                || (row == 0 && direction == Directions.UP) || (row == Field.getHeight()-1 && direction == Directions.DOWN)
                || (column == Field.getWidth()-1 && direction == Directions.RIGHT) || (column == 0 && direction == Directions.LEFT);

    }

    public int getCol() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
