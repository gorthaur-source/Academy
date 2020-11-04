package org.academiadecodigo.tailormoons.mapeditor.Keyboard;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tailormoons.mapeditor.Direction;
import org.academiadecodigo.tailormoons.mapeditor.Grid;

import java.util.HashMap;
import java.util.Map;

public class Input implements KeyboardHandler {

    private static final int[] KEY_CODES = {
            KeyboardEvent.KEY_UP,
            KeyboardEvent.KEY_DOWN,
            KeyboardEvent.KEY_RIGHT,
            KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_SPACE,
            KeyboardEvent.KEY_C,
            KeyboardEvent.KEY_L,
            KeyboardEvent.KEY_S,
            KeyboardEvent.KEY_M,
    };

    private Map<Integer, Boolean> keyStates;
    private Keyboard myKeyboard;

    public Grid grid;

    public Input(Grid grid) {
        this.grid = grid;
        myKeyboard = new Keyboard(this);
        keyStates = new HashMap<>();
        setListeningEvents();

    }

    public void setListeningEvents() {

        for (int code : KEY_CODES) {
            for (KeyboardEventType type : KeyboardEventType.values()) {
                subscribe(code, type);
            }
        }

    }

    private void subscribe(int code, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(code);
        event.setKeyboardEventType(type);
        myKeyboard.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        keyStates.put(e.getKey(), true);
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        keyStates.put(e.getKey(), false);
    }

    public boolean isPressed(int code) {
        return keyStates.getOrDefault(code, false);
    }

}

