package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Node {


    private int x;
    private int y;
    private boolean isSelected;
    private Rectangle square;


    public Node(int x, int y) {
        this.x = x;
        this.y = y;

        square = new Rectangle(x + Grid.PADDING, y + Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        square.draw();
    }

    public Node() {

    }


    public void setSelected(boolean value) {
        isSelected = value;
    }

    public Rectangle getSquare() {
        return square;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
