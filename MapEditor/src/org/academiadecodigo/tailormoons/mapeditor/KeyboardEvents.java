package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tailormoons.mapeditor.Cursor;
import org.academiadecodigo.tailormoons.mapeditor.Grid;

public class KeyboardEvents implements KeyboardHandler {


    private Grid grid;

    public KeyboardEvents(Grid grid) {
        this.grid = grid;
    }




    @Override
    public void keyPressed(KeyboardEvent e) {
        switch(e.getKey()) {



        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }


}
