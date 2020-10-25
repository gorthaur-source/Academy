package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;
import java.util.List;

public class Input implements KeyboardHandler {

        public List<Key> keys = new ArrayList<Key>();

        public Key up = new Key();
        public Key down = new Key();
        public Key left = new Key();
        public Key right = new Key();
        public Key space = new Key();
        public Key c = new Key();
        public Key l = new Key();
        public Key s = new Key();

        public Grid grid;
        public Input(Grid grid) {
            this.grid = grid;
            grid.setMyKeyboard(this);
            grid.setListeningEvents();

        }

        @Override
        public void keyPressed(KeyboardEvent e) {
            toggle(e, true);
        }

        @Override
        public void keyReleased(KeyboardEvent e) {
            toggle(e, false);
        }

        private void toggle(KeyboardEvent e, boolean pressed) {
            if (e.getKey() == KeyboardEvent.KEY_UP) up.toggle(pressed);
            if (e.getKey() == KeyboardEvent.KEY_DOWN) down.toggle(pressed);
            if (e.getKey() == KeyboardEvent.KEY_LEFT) left.toggle(pressed);
            if (e.getKey() == KeyboardEvent.KEY_RIGHT) right.toggle(pressed);
            if (e.getKey() == KeyboardEvent.KEY_SPACE) space.toggle(pressed);
            if (e.getKey() == KeyboardEvent.KEY_C) c.toggle(pressed);
            if (e.getKey() == KeyboardEvent.KEY_L) l.toggle(pressed);
            if(e.getKey() == KeyboardEvent.KEY_S) s.toggle(pressed);
        }

    public void update() throws InterruptedException {

        while(space.down && left.down) {
            if(grid.getCursor().getY() <= grid.ROWS -1) return;
            grid.getCursor().setSelected(false);
            grid.setCursor(grid.getGridCellPos(grid.getCursor().getX() - 1, grid.getCursor().getY()));
            grid.getCursor().setSelected(true);
            grid.getCursor().paintContinuous();

        }
        if (space.down && down.down) {
            System.out.println("stuff");
            if (!(grid.getCursor().getY() >= grid.ROWS - 1)) {
                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX(), grid.getCursor().getY() + 1));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();
                grid.getCursor().paintContinuous();
            }
        }
        if(left.down) {
            //   if (input.left.equals(input.keys)) {
            if (!(grid.getCursor().getX() == 0)) {
                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX() - 1, grid.getCursor().getY()));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();
            }
        } else if (right.down) {
            if (!(grid.getCursor().getX() == grid.COLS - 1)) {
                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX() + 1, grid.getCursor().getY()));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();
            }
        } else if (up.down) {
            if (!(grid.getCursor().getY() == 0)) {

                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX(), grid.getCursor().getY() - 1));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();
            }
        } else if (down.down && !space.down) {
            if (!(grid.getCursor().getY() == grid.ROWS - 1)) {
                grid.getCursor().cursorHide();
                grid.getCursor().setSelected(false);
                grid.setCursor(grid.getGridCellPos(grid.getCursor().getX(), grid.getCursor().getY() + 1));
                grid.getCursor().setSelected(true);
                grid.getCursor().cursorShow();
            }
        } else if (space.down && !down.down) {
            grid.getCursor().paintOverlap();
            space.toggle(false);
        } else if (c.down) {
            grid.getCursor().paint(Color.PINK);
        } else if (l.down) {
            grid.stringToNode();
        } else if (s.down) grid.saveData();

        releaseAll();
    }

        public void releaseAll() {
            for (Key key : keys) key.down = false;
        }


        public class Key {
            public boolean down;

            public Key() {
                keys.add(this);
            }

            public void toggle(boolean pressed) {
                if (pressed != down) down = pressed;
            }
        }
    }

