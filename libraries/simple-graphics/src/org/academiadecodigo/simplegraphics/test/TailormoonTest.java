package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TailormoonTest {

    public static void main(String[] args) throws InterruptedException {

        Rectangle rectangle = new Rectangle(10, 10, 500, 500);
        rectangle.draw();

        Rectangle pinkRectangle = new Rectangle(10, 10, 250, 250);
        pinkRectangle.setColor(Color.PINK);

        pinkRectangle.fill();

        Ellipse ellipse = new Ellipse(50, 50, 50, 100);
        ellipse.setColor(Color.ORANGE);
        ellipse.fill();

        Text text = new Text(10, 10, "We are <TAILormoons>");
        text.draw();

        KeyboardListener keyboardListener = new KeyboardListener();
        Keyboard keyboard = new Keyboard(keyboardListener);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(right);

        for (int i = 0; i < 100; i++) {
            Thread.sleep(100);
            pinkRectangle.translate(10, 0);
        }
    }
}
