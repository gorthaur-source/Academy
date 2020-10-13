package org.academiadecodigo.bootcamp.car.players.playerOne;


import org.academiadecodigo.bootcamp.car.CarType;
import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class PlayerOne extends Player {

    public static final int LEFT = KeyboardEvent.KEY_LEFT;
    public static final int RIGHT = KeyboardEvent.KEY_RIGHT;
    public static final int UP = KeyboardEvent.KEY_UP;
    public static final int DOWN = KeyboardEvent.KEY_DOWN;

    public PlayerOne(GridPosition pos) {
        super(pos, CarType.PLAYER);
    }

    @Override
    public void move() {
        keyboardHandling();
        accelerate(this.currentDirection, 1);
    }

    public void keyboardHandling() {

        KeyboardListener keyboardListener = new KeyboardListener(this);
        Keyboard keyboard = new Keyboard(keyboardListener);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(LEFT);

        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(RIGHT);

        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(UP);

        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(DOWN);

        keyboard.addEventListener(down);

    }


    @Override
    public void accelerate(GridDirection direction, int speed) {

        System.out.println(this);

        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(direction, 1);
        }
        collisionDetector.checkPlayer(this);
    }

}
