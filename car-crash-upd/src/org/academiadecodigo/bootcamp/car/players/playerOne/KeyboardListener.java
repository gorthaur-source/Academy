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
            case KeyboardEvent.KEY_LEFT:
                player.setCurrentDirection(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.setCurrentDirection(GridDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_UP:
                player.setCurrentDirection(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                player.setCurrentDirection(GridDirection.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
