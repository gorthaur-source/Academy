package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class Node implements Serializable {


    private int x;
    private int y;
    private boolean isPainted;
    private boolean isSelected;
    private transient Rectangle square;
    private transient Color color = Color.BLACK;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;

        createRectangle();

    }



    public void setPainted() {
        isPainted = true;
    }

    public void paint(Color color) {

        if (!isPainted) {
            square.setColor(Color.BLUE);
            square.fill();
            this.color = color;
            isPainted = true;

        } else {
            square.setColor(Color.GREEN);
            square.fill();
            this.color = color;
            isPainted = false;
        }
    }

    public void createRectangle() {
        square = new Rectangle(x * Grid.CELL_SIZE + Grid.PADDING, y * Grid.CELL_SIZE + Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        square.draw();
    }


    public void cursorShow() {
        if (isPainted) {
            square.setColor(Color.BLUE);
            square.fill();

        }
        else {
            square.setColor(Color.GREEN);
            square.fill();
        }
    }

    public void cursorHide() {
        if(square.getColor() == Color.GREEN) {
            isPainted = false;
            this.color = Color.BLACK;
        }

        if(isPainted) {
            square.setColor(color);
            square.fill();
        }
        if (!isPainted) {
            square.setColor(color);
            square.draw();
        }
    }

    public Color getColor() {
        return color;
    }
    public Rectangle getSquare() {
        return square;
    }


    public void paintContinuous() {
        square.setColor(color);
        square.fill();
        isPainted = true;

    }
    public void paintOverlap() {
        if (!isPainted) {
            color = Color.BLACK;
            square.setColor(Color.BLUE);
            square.fill();
            isPainted = true;
        } else {
            color = Color.BLACK;
            square.setColor(Color.GREEN); //
            square.fill();
            color = Color.BLACK;
            isPainted = false;
        }
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setSelected(boolean value) {
        isSelected = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSelected() {
        return isSelected;
    }
    public String getStringColor(Color color) {

        if(color == Color.BLACK) {
            return "Color.BLACK";
        }
        else if (color == Color.BLUE) {
            return "Color.BLUE";
        }
        else if (color == Color.GREEN) {
            return "Color.GREEN";
        }
        else if (color == Color.PINK) {
            return "Color.PINK";
        }
        else {
            throw new NoSuchElementException();
        }

    }


    public void paintState() {
        if (!isPainted && isSelected) {
            square.setColor(Color.GREEN);
            color = Color.BLACK;
            square.fill();
            return;
        }
        if (isPainted && isSelected) {
            square.setColor(Color.BLUE);
            color = Color.BLACK;
            square.fill();
            return;
        }

         if (isPainted) {
            square.setColor(color);
            square.fill();
            return;
        } else {
             square.setColor(Color.BLACK);
             square.draw();
         }
        }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {

        return x + " " + y +" " + getStringColor(color);
    }

    //serialize


    public void paintStateSerialized() {
        if (!isPainted && isSelected) {
            square.setColor(Color.GREEN);
            color = Color.BLACK;
            square.fill();
            isSelected = true;
            return;
        }

        else if(isPainted && isSelected) {
            square.setColor(Color.BLUE);
            color = Color.BLACK;
            square.fill();
            System.out.println(isSelected);
            isSelected = true;
            return;
        }
        else if (isPainted) {
            color = Color.BLACK;
            square.setColor(color);
            square.fill();
            return;
        }
        color = Color.BLACK;
        square.setColor(color);
        square.draw();

    }
}
