package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.gfx.lanterna.LanternaGrid;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;

/**
 * A factory of different types of grids
 */
public class GridFactory {

    /**
     * Creates a new grid
     *
     * @param gridType the type of grid to create
     * @param cols     the number of columns of the grid
     * @param rows     the number of rows of the grid
     * @return the new grid
     */
    public static Grid makeGrid(GridType gridType, int cols, int rows) {

        Grid newGrid;
        newGrid = (gridType == GridType.SIMPLE_GFX ? new SimpleGfxGrid(cols, rows) : new LanternaGrid(cols, rows));

        return newGrid;

    }

}
