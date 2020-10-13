package org.academiadecodigo.bootcamp.car.players.playerOne;

import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private final Player player;

    public KeyboardListener(Player player) {
       this.player = player;
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case PlayerOne.LEFT -> player.setCurrentDirection(GridDirection.LEFT);
            case PlayerOne.RIGHT -> player.setCurrentDirection(GridDirection.RIGHT);
            case PlayerOne.UP -> player.setCurrentDirection(GridDirection.UP);
            case PlayerOne.DOWN -> player.setCurrentDirection(GridDirection.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
