package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class KeyboardListener implements KeyboardHandler {

    private Picture picture;

    public KeyboardListener() {
        picture = new Picture(10, 10, "assets/sailormoon.jpg");
        picture.draw();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                picture.translate(-10, 0);
                break;

            case KeyboardEvent.KEY_RIGHT:
                picture.translate(10, 0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
