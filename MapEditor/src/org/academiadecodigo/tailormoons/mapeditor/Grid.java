package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Grid /*implements KeyboardHandler */ {

    public static final int CELL_SIZE = 25;
    public final int COLS;
    public final int ROWS;
    public static final int PADDING = 10;
    private Node[][] gridCells;
    private Node cursor;
    private Keyboard myKeyboard;
    private Node[][] loadedCells;
    private Node[][] savedCells;
    String [][] parsedArrays;

    public Grid(int rows, int cols) {
        COLS = cols;
        ROWS = rows;

        gridCells = new Node[COLS][ROWS];
        Rectangle grid = new Rectangle(PADDING, PADDING, columnToX(COLS), rowToY(ROWS));
        grid.draw();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gridCells[j][i] = new Node(j, (i));

            }
        }
        cursor = gridCells[0][0];
        cursor.setSelected(true);
        cursor.cursorShow();

        //if (loadedCells != null) {
          //  loadedCells = gridLoadData();
       // }
        //savedCells = new Node[COLS][ROWS];

            parsedArrays = gridLoadData();

    }

    public void setCursor(int x, int y) {
        cursor = gridCells[x][y];
    }

    public int rowToY(int row) {
        return row * CELL_SIZE;
    }

    public void setMyKeyboard(KeyboardHandler handler) {
        myKeyboard = new Keyboard(handler);
    }

    public void setListeningEvents() {


        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        myKeyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        myKeyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        myKeyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        myKeyboard.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);

        myKeyboard.addEventListener(space);

        KeyboardEvent c = new KeyboardEvent();
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        c.setKey(KeyboardEvent.KEY_C);

        myKeyboard.addEventListener(c);

        KeyboardEvent l = new KeyboardEvent();
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        l.setKey(KeyboardEvent.KEY_L);

        myKeyboard.addEventListener(l);

        KeyboardEvent s = new KeyboardEvent();
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s.setKey(KeyboardEvent.KEY_S);

        myKeyboard.addEventListener(s);
    }

    public int columnToX(int column) {
        return column * CELL_SIZE;
    }

    public Node getCursor() {
        return cursor;
    }

    public void setCursor(Node node) {
        cursor = node;
    }

    public Node getGridCellPos(int x, int y) {
        return gridCells[x][y];
    }

    // save & load

    public String saveArray() {
        String savedArray = "";

        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (gridCells[i][j].isPainted()) {
                    savedArray += gridCells[i][j].toString() + "\n";

                }
            }
        }
        savedArray = savedArray.trim();
        return savedArray;
    }

    public String[][] gridLoadData() {
        NonSerializedReader zzz = new NonSerializedReader();
        List<String> parsedList = zzz.readAndWrite();
        String[][] parsedArrays = new String[parsedList.size()][3];
        for (int i = 0; i < parsedList.size(); i++)
        {
            parsedArrays[i] = parsedList.get(i).split(" ");
        }
        return parsedArrays;
    }
    public void saveData() {
        NonSerializedWriter writer = new NonSerializedWriter();
        writer.write(saveArray());
    }

    public Color stringToColor(String color) {

        if(color.equals("Color.BLACK")) return Color.BLACK;
        else if(color.equals("Color.BLUE")) return Color.BLUE;
        else if(color.equals("Color.GREEN")) return Color.GREEN;
        else if(color.equals("Color.PINK")) return Color.PINK;
        else throw new NoSuchElementException();

    }

    public void stringToNode() {
        if(parsedArrays !=null) {

        for(int i = 0; i < parsedArrays.length; i++) {

            int x = Integer.parseInt(parsedArrays[i][0]);
            int y = Integer.parseInt(parsedArrays[i][1]);

            gridCells[x][y].setPainted();

            gridCells[x][y].setColor(stringToColor(parsedArrays[i][2]));
        }
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    //  if (gridCells[j][i].isSelected()) cursor = gridCells[j][i];
                    gridCells[j][i].paintState();
                }
            }
        }
        else System.out.println("No valid loading profile");
    }

    //serialize


    public Node[][] gridLoadDataSerialized() {
        SeriazableArrayReader dataReader = new SeriazableArrayReader();
        loadedCells = dataReader.readArray();
       // updateReadData();

        return loadedCells;
    }

    public void saveDataSerialize() {
        System.out.println("start");
        Node[][] arrayCopy = gridCells;
        SeriazableArrayWriter.write(arrayCopy);
        System.out.println("finish");
    }

    public void updateReadDataSerialized() {
        gridCells = loadedCells;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                gridCells[j][i].createRectangle();
                if (gridCells[j][i].isSelected()) cursor = gridCells[j][i];
                gridCells[j][i].paintState();
            }
        }
    }

}
