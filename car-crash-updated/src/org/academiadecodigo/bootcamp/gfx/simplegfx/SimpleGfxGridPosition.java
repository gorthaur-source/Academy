package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private final SimpleGfxGrid simpleGfxGrid;
    private final Rectangle rectangle;

    /**     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid, int sizeMultiplier){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid, sizeMultiplier);
        this.simpleGfxGrid = grid;
        rectangle = new Rectangle(getCol()* SimpleGfxGrid.getCellSize() + simpleGfxGrid.getY(), getRow()* SimpleGfxGrid.getCellSize() + SimpleGfxGrid.getX(), SimpleGfxGrid.getCellSize(), SimpleGfxGrid.getCellSize());
    }

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
        rectangle.fill();

    }


    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
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
            rectangle.translate((finalCol - initialCol) * SimpleGfxGrid.getCellSize(), (finalRow - initialRow) * SimpleGfxGrid.getCellSize());


    }


    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));

}
}
