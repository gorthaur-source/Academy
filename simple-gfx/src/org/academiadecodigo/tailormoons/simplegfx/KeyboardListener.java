package org.academiadecodigo.tailormoons.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Movable movable;

    public KeyboardListener(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        switch (event.getKey()) {
            case KeyboardEvent.KEY_UP:
                movable.translate(0, -10);
                break;
            case KeyboardEvent.KEY_DOWN:
                movable.translate(0, 10);
                break;
            case KeyboardEvent.KEY_LEFT:
                movable.translate(-10, 0);
                break;
            case KeyboardEvent.KEY_RIGHT:
                movable.translate(10, 0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent event)

    {

    }
}
