package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.List;
import java.util.NoSuchElementException;

public class Grid /*implements KeyboardHandler */ {

    public static final int CELL_SIZE = 25;
    private final int COLS;
    private final int ROWS;
    public static final int PADDING = 10;
    private Node[][] gridCells;
    private Node cursor;
    private Node[][] loadedCells;
    String[][] parsedArrays;
   //private Node[][] savedCells;

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


    public void move(int deltaCOL, int deltaROW) {
        getCursor().cursorHide();
        getCursor().setSelected(false);
        setCursor(getGridCellPos(getCursor().getX() + deltaCOL, getCursor().getY() + deltaROW));
        getCursor().setSelected(true);
        getCursor().cursorShow();
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

    @Override
    public String toString() {
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


    public void clear() {

        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (gridCells[i][j].isSelected() && !gridCells[i][j].isPainted()) continue;

                gridCells[i][j].setPainted(false);
                if (gridCells[i][j].isSelected()) {
                    gridCells[i][j].getSquare().setColor(Color.GREEN);
                    continue;
                }

                gridCells[i][j].getSquare().setColor(Color.BLACK);
                gridCells[i][j].getSquare().draw();



            }
        }
    }

    public String[][] gridLoadData() {
        NonSerializedReader zzz = new NonSerializedReader();
        List<String> parsedList = zzz.readAndWrite();
        String[][] parsedArrays = new String[parsedList.size()][3];
        for (int i = 0; i < parsedList.size(); i++) {
            parsedArrays[i] = parsedList.get(i).split(" ");
        }
        return parsedArrays;
    }

    public void saveData() {
        NonSerializedWriter writer = new NonSerializedWriter();
        writer.write(toString());
    }

    public Color stringToColor(String color) {

        if (color.equals("Color.BLACK")) return Color.BLACK;
        else if (color.equals("Color.BLUE")) return Color.BLUE;
        else if (color.equals("Color.GREEN")) return Color.GREEN;
        else if (color.equals("Color.PINK")) return Color.PINK;
        else throw new NoSuchElementException();

    }

    public void stringToNode() {
        if (parsedArrays != null) {

            for (int i = 0; i < COLS; i++) {
                for (int j = 0; j < ROWS; j++) {
                    if (gridCells[i][j].isSelected() && !gridCells[i][j].isPainted()) continue;
                    gridCells[i][j].setPainted(false);
                }
            }

            for (String[] parsedArray : parsedArrays) {

                int x = Integer.parseInt(parsedArray[0]);
                int y = Integer.parseInt(parsedArray[1]);
                gridCells[x][y].setPainted(true);
                gridCells[x][y].setColor(stringToColor(parsedArray[2]));
            }
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    gridCells[j][i].paintState();
                }
            }
        } else System.out.println("No valid loading profile");
    }

    public int getCOLS() {
        return COLS;
    }

    public int getROWS() {
        return ROWS;
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
