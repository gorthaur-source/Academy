package org.academiadecodigo.bootcamp.car.players.playerTwo;

import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListenerTwo implements KeyboardHandler {

    private final Player player;

    public KeyboardListenerTwo(Player player) {
       this.player = player;
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_A:
                player.setCurrentDirection(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_D:
                player.setCurrentDirection(GridDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_W:
                player.setCurrentDirection(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_S:
                player.setCurrentDirection(GridDirection.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
