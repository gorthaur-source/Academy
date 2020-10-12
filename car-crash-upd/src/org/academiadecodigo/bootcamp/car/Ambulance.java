package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public class Ambulance extends Car {


    private final static int MOVES_BEFORE_BREAK = 30;
    private final static int BREAK_INTERVAL = 4;
    private int moves = 0;

    public Ambulance(GridPosition pos, int index) {
        super(pos, CarType.AMBULANCE, index);
    }

    @Override
    public void move() {

        moves++;
        if (moves < MOVES_BEFORE_BREAK || moves % BREAK_INTERVAL != 0) {
            accelerate(chooseDirection(), Fiat.SPEED);
        }
        collisionDetector.checkAmbulance(this);

    }
}