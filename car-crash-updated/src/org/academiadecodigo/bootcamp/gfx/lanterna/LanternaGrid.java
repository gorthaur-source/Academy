package org.academiadecodigo.bootcamp.gfx.lanterna;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

/**
 * A Grid based on the Lanterna library
 * This implementation DOES NOT contain keyboard support
 */
public class LanternaGrid implements Grid {

    /**
     * Used to write to screen
     */
    private static Screen screen;

    /**
     * Screen wrapper that preserves default options
     */
    private static ScreenWriter screenWriter;

    private final int cols;
    private final int rows;

    /**
     * Constructs a grid with a specific number of columns and rows
     *
     * @param cols number of grid columns
     * @param rows number of grid rows
     */
    public LanternaGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }


    @Override
    public SimpleGfxGridPosition makeGridPosition(int col, int row) {
        return null;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {

        // create the GUI
        screen = TerminalFacade.createScreen();

        // set the grid size
        screen.getTerminal().setCursorVisible(false); // Not Working
        screen.getTerminal().getTerminalSize().setColumns(cols);
        screen.getTerminal().getTerminalSize().setRows(rows);

        // display the grid
        screen.startScreen();

    }

    @Override
    public GridPosition makeGridPosition(int sizeMultiplier){
        return new LanternaGridPosition(this, sizeMultiplier);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     * @return
     */

    @Override
    public GridPosition makeGridPositionEllipse(int sizeMultiplier) {
        return null;
    }


    @Override
    public void setPlayerOneScoreText(int takeDowns) {

    }

    @Override
    public void setPlayerTwoScoreText(int takeDowns) {

    }


    /**
     * Show a specific grid position on screen
     *
     * @param pos the grid position to show
     */
    public void show(GridPosition pos) {
        screen.putString(pos.getCol(), pos.getRow(), " ", LanternaColorMapper.getColor(pos.getColor()), LanternaColorMapper.getColor(pos.getColor()));
        screen.refresh();
    }

    /**
     * Hide a specific grid position
     *
     * @param pos the grid position to hide
     */
    public void hide(GridPosition pos) {
        screen.putString(pos.getCol(), pos.getRow(), " ", Terminal.Color.DEFAULT, Terminal.Color.DEFAULT);
        screen.refresh();
    }

}
