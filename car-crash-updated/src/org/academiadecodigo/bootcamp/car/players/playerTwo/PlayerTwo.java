package org.academiadecodigo.bootcamp.car.players.playerTwo;

import org.academiadecodigo.bootcamp.car.CarType;
import org.academiadecodigo.bootcamp.car.players.Player;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class PlayerTwo extends Player {


    public static final int LEFT = KeyboardEvent.KEY_A;
    public static final int RIGHT = KeyboardEvent.KEY_D;
    public static final int UP = KeyboardEvent.KEY_W;
    public static final int DOWN = KeyboardEvent.KEY_S;


    public PlayerTwo(GridPosition pos) {
        super(pos, CarType.PLAYER);
        getPos().setColor(GridColor.DARK_GRAY);
        setOriginalColor(GridColor.DARK_GRAY);
    }

    @Override
    public void move() {
        keyboardHandling();
        accelerate(this.currentDirection, 1);
    }

    @Override
    public void keyboardHandling() {

        KeyboardListenerTwo keyboardListenerTwo = new KeyboardListenerTwo(this);
        Keyboard keyboard = new Keyboard(keyboardListenerTwo);

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
