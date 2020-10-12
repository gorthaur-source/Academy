package org.academiadecodigo.bootcamp.car.players.playerTwo;

import org.academiadecodigo.bootcamp.car.players.playerOne.PlayerOne;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class PlayerTwo extends PlayerOne {

    private final int left = KeyboardEvent.KEY_A;
    private final int right = KeyboardEvent.KEY_D;
    private final int up = KeyboardEvent.KEY_W;
    private final int down = KeyboardEvent.KEY_S;

    public PlayerTwo(GridPosition pos, int index) {
        super(pos, index);
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
