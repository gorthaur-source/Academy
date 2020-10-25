package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Canvas {

    private Grid grid;
    private Input input;

    public Canvas(int COLS, int ROWS) {
        grid = new Grid(COLS, ROWS);
        this.input = new Input(grid);
    }


    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(70);
            input.update();
        }


   /*public void update() {

        if(input.left.down) {
            //   if (input.left.equals(input.keys)) {
            if (!(grid.getCursor().getX() == 0)) return;
            grid.getCursor().cursorHide();
            grid.getCursor().setSelected(false);
            System.out.println("here");
            grid.setCursor(grid.getGridCellPos(grid.getCursor().getX() - 1, grid.getCursor().getY()));
            grid.getCursor().setSelected(true);
            grid.getCursor().cursorShow();

        } else if (input.right.down) {
            if (!(grid.getCursor().getX() == grid.COLS - 1)) {
                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX() + 1, grid.getCursor().getY()));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();
            }
        } else if (input.up.down) {
            if (grid.getCursor().getY() == 0) {
                System.out.println("why");
            }
            System.out.println("wut");
            grid.getCursor().cursorHide();
            grid.getCursor().setSelected(false);
            grid.setCursor(grid.getGridCellPos(grid.getCursor().getX(), grid.getCursor().getY() - 1));
            grid.getCursor().cursorShow();
        } else if (input.down.down) {
            if (grid.getCursor().getY() == grid.ROWS - 1)
                grid.getCursor().cursorHide();
            grid.getCursor().setSelected(false);
            grid.setCursor(grid.getGridCellPos(grid.getCursor().getX(), grid.getCursor().getY() + 1));
            grid.getCursor().setSelected(true);
            grid.getCursor().cursorShow();
        } else if (input.space.down) {
            grid.getCursor().paintOverlap();
        } else if (input.c.down) {
            grid.getCursor().paint(Color.PINK);
        }
    }

         /*   while(input.down && input.space) {
                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX(),grid.getCursor().getY() + 1));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();        } */


    }
}

