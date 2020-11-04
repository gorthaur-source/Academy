package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.tailormoons.mapeditor.Keyboard.Input;

public class Canvas {

    private Grid grid;
    private Input input;

    public Canvas(int COLS, int ROWS) {
        grid = new Grid(COLS, ROWS);
        this.input = new Input(grid);
    }


    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            update();
        }
    }

        public void update() throws InterruptedException {

            if (input.isPressed(KeyboardEvent.KEY_SPACE) && input.isPressed(KeyboardEvent.KEY_LEFT)) {
                if ((grid.getCursor().getX() > 0)) {
                    grid.move(Direction.LEFT.getDeltaCol(), Direction.LEFT.getDeltaRow());
                    grid.getCursor().paintContinuous(Color.BLACK);
                }
            }
            else if (input.isPressed(KeyboardEvent.KEY_SPACE) && input.isPressed(KeyboardEvent.KEY_DOWN)) {
                if ((grid.getCursor().getY() < grid.getROWS() + Direction.UP.getDeltaRow())) {
                    grid.move(Direction.DOWN.getDeltaCol(), Direction.DOWN.getDeltaRow());
                    grid.getCursor().paintContinuous(Color.BLACK);
                }
            }

            else if (input.isPressed(KeyboardEvent.KEY_SPACE) && input.isPressed(KeyboardEvent.KEY_UP)) {
                if ((grid.getCursor().getY() > 0)) {
                    grid.move(Direction.UP.getDeltaCol(), Direction.UP.getDeltaRow());
                    grid.getCursor().paintContinuous(Color.BLACK);
                }
            }
            else if (input.isPressed(KeyboardEvent.KEY_SPACE) && input.isPressed(KeyboardEvent.KEY_RIGHT)) {
                if ((grid.getCursor().getX() < grid.getCOLS() + Direction.LEFT.getDeltaCol())) {
                    grid.move(Direction.RIGHT.getDeltaCol(), Direction.RIGHT.getDeltaRow());
                    grid.getCursor().paintContinuous(Color.BLACK);
                }
            }
            else if (input.isPressed(KeyboardEvent.KEY_LEFT)) {
                //   if (input.left.equals(input.keys)) {
                if (!(grid.getCursor().getX() == 0)) {
                    grid.move(Direction.LEFT.getDeltaCol(), Direction.LEFT.getDeltaRow());
                }
            } else if (input.isPressed(KeyboardEvent.KEY_RIGHT)) {
                if (!(grid.getCursor().getX() == grid.getCOLS() - 1)) {
                    grid.move(Direction.RIGHT.getDeltaCol(), Direction.RIGHT.getDeltaRow());

                }
            } else if (input.isPressed(KeyboardEvent.KEY_UP)) {
                if (!(grid.getCursor().getY() == 0)) {
                    grid.move(Direction.UP.getDeltaCol(), Direction.UP.getDeltaRow());

                }
            } else if (input.isPressed(KeyboardEvent.KEY_DOWN)) {
                if (!(grid.getCursor().getY() == grid.getROWS() - 1)) {
                    grid.move(Direction.DOWN.getDeltaCol(), Direction.DOWN.getDeltaRow());
                }
            } else if (input.isPressed(KeyboardEvent.KEY_SPACE)) {
                grid.getCursor().paintOverlap();
            } else if (input.isPressed(KeyboardEvent.KEY_C)) {
                grid.getCursor().paint(Color.PINK);
            } else if (input.isPressed(KeyboardEvent.KEY_L)) {
                grid.stringToNode();
            } else if (input.isPressed(KeyboardEvent.KEY_S)) {
                grid.saveData();
            } else if (input.isPressed(KeyboardEvent.KEY_M)) {
                grid.clear();
            }
            Thread.sleep(30);
        }
}

