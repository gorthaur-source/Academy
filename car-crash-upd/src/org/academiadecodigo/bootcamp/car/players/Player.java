package org.academiadecodigo.bootcamp.car.players;


import org.academiadecodigo.bootcamp.car.Car;
import org.academiadecodigo.bootcamp.car.CarType;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;


public abstract class Player extends Car {

    private int takeDowns;

    public Player(GridPosition pos, int index) {
        super(pos, CarType.PLAYER, index);
    }

    /**
     * Constructs a new car
     *
     * @param pos     the initial car position
     * @param carType the car type
     * @param ID
     */
    public Player(GridPosition pos, CarType carType, int ID) {
        super(pos, carType, ID);
    }

    @Override
    public void move() {
        keyboardHandling();
        accelerate(this.currentDirection, 1);
    }

    public abstract void keyboardHandling();


    @Override
    public abstract void accelerate(GridDirection direction, int speed);

    public int getTakeDowns() {
        return takeDowns;
    }

    public void incrementTakeDowns() {
        takeDowns++;
    }
}