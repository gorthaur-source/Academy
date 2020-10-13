package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public interface Grid {

    /**
     * Initializes the grid
     */
    void init();

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    int getRows();

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */
    GridPosition makeGridPosition(int sizeMultiplier);

    /**
     * Creates a a grid position in a specific column and row
     *  @param col   the position column
     * @param row   the position row
     * @return
     */
    SimpleGfxGridPosition makeGridPosition(int col, int row);

    GridPosition makeGridPositionEllipse(int sizeMultiplier);

    void setPlayerOneScoreText(int takeDowns);

    void setPlayerTwoScoreText(int takeDowns);


}

