package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.car.players.playerOne.PlayerOne;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;


/**
 * Simple graphics position
 */
public class SimpleGfxGridEllipsePosition extends AbstractGridPosition {

    private SimpleGfxGrid simpleGfxGrid;
    private Ellipse ambulance;

    /**     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */


    public SimpleGfxGridEllipsePosition(SimpleGfxGrid grid, int sizeMultiplier) {
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid, sizeMultiplier);
        this.simpleGfxGrid = grid;
        ambulance = new Ellipse(getCol()* SimpleGfxGrid.getCellSize() + simpleGfxGrid.getY(), getRow()* SimpleGfxGrid.getCellSize() + SimpleGfxGrid.getX(), SimpleGfxGrid.getCellSize()*sizeMultiplier, SimpleGfxGrid.getCellSize() * sizeMultiplier);
    }

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col  the column of the grid position
     * @param row  the row of the grid position
     * @param grid the grid in which the position will be displayed
     */

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col  the column of the grid position
     * @param row  the row of the grid position
     * @param grid the grid in which the position will be displayed
     */


    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */


    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        ambulance.fill();

    }


    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        ambulance.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int initialCol = super.getCol();
        int initialRow = super.getRow();

        super.moveInDirection(direction, distance);

        int finalCol = super.getCol();
        int finalRow = super.getRow();

        ambulance.translate((finalCol - initialCol) * SimpleGfxGrid.getCellSize(), (finalRow - initialRow) * SimpleGfxGrid.getCellSize());

    }

    public void setColor(GridColor color) {
        super.setColor(color);
        ambulance.setColor(SimpleGfxColorMapper.getColor(color));

    }
}
