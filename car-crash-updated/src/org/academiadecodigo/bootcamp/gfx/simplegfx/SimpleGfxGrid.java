package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 30;
    public static final int CELL_SIZE = 20;
    private final int rows;
    private final int columns;
    private static final int x = PADDING;
    private static final int y = PADDING;
    Text playerOneScoreText;
    Text playerTwoScoreText;

    public SimpleGfxGrid(int cols, int rows) {
        this.rows = rows;
        this.columns = cols;

        playerOneScoreText = new Text(getX() + 10, 0, "Player one takedowns: " + 0);
        playerTwoScoreText = new Text(71 * getCellSize(), 0, "Player two takedowns: " + 0);
    }


    /**
     * @see Grid#init()
     */

    @Override
    public void init() {

        Rectangle gridRect = new Rectangle(x,y, columnToX(columns), rowToY(rows));
        gridRect.draw();
        playerOneScoreText.draw();
        playerTwoScoreText.draw();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {

        return columns;

    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {

        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return columns * getCellSize();
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return rows * getCellSize();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public static int getX() {
        return x;
    }


    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return y;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */

    public static int getCellSize() {
        return CELL_SIZE;
    }

    @Override
    public GridPosition makeGridPosition(int sizeMultiplier) {

         return new SimpleGfxGridPosition(this, sizeMultiplier);

    }

    @Override
    public SimpleGfxGridPosition makeGridPosition(int col, int row) {
        return null;
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     * @return
     */

    public void setPlayerOneScoreText(int playerOneScore) { // update playerOne score
        playerOneScoreText.delete();
        playerOneScoreText = new Text(getX() + 10, 0, "Player one takedowns: " + playerOneScore);
        playerOneScoreText.draw();

}

    public void setPlayerTwoScoreText(int playerTwoScore) { // update playerTwo score
        playerTwoScoreText.delete();
        playerTwoScoreText = new Text(75 * getCellSize(), 0, "Player two takedowns: " + playerTwoScore);
        playerTwoScoreText.draw();

    }

    public GridPosition makeGridPositionEllipse(int sizeMultiplier) {
        return new SimpleGfxGridEllipsePosition(this, sizeMultiplier);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return row * getCellSize();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return column * getCellSize();
        }

}
