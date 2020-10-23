package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid implements KeyboardHandler {

    public static final int CELL_SIZE = 25;
    public final int COLS;
    public final int ROWS;
    public static final int PADDING = 10;
    private Node[][] gridCells;
    private Node cursor;

    public Grid(int rows, int cols) {
        COLS = cols;
        ROWS = rows;

        gridCells = new Node[COLS][ROWS];
        Rectangle grid = new Rectangle(PADDING, PADDING, columnToX(COLS), rowToY(ROWS));
        grid.draw();

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gridCells[j][i] = new Node(columnToX(j), rowToY(i));

            }
        }
        cursor = new Cursor(gridCells[0][0]);
    }

    public void setCursor(int x, int y) {
        cursor = gridCells[x][y];
    }

    public int rowToY(int row) {
        return row * CELL_SIZE;
    }

    public void eventStartup() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(space);
    }

    public int columnToX(int column) {
        return column * CELL_SIZE;
    }



    @Override
    public void keyPressed(KeyboardEvent e) {
        switch(e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                setCursor(cursor.getX() - 1, cursor.getY());
                break;
            case KeyboardEvent.KEY_RIGHT:
                setCursor(cursor.getX() + 1, cursor.getY());
                break;
            case KeyboardEvent.KEY_DOWN:
                setCursor(cursor.getX(), cursor.getY() + 1);
                break;
            case KeyboardEvent.KEY_UP:
                setCursor(cursor.getX(), cursor.getY() - 1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
