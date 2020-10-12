package org.academiadecodigo.bootcamp.car.players.playerOne;


import org.academiadecodigo.bootcamp.car.CarType;
import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class PlayerOne extends Player {

    private final int left = KeyboardEvent.KEY_LEFT;
    private final int right = KeyboardEvent.KEY_RIGHT;
    private final int up = KeyboardEvent.KEY_UP;
    private final int down = KeyboardEvent.KEY_DOWN;

    public PlayerOne(GridPosition pos, int index) {
        super(pos, CarType.PLAYER, index);
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
        left.setKey(this.left);

        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(this.right);

        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(this.up);

        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(this.down);

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
