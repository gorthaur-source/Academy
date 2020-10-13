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
            case PlayerTwo.LEFT -> player.setCurrentDirection(GridDirection.LEFT);
            case PlayerTwo.RIGHT -> player.setCurrentDirection(GridDirection.RIGHT);
            case PlayerTwo.UP -> player.setCurrentDirection(GridDirection.UP);
            case PlayerTwo.DOWN -> player.setCurrentDirection(GridDirection.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
