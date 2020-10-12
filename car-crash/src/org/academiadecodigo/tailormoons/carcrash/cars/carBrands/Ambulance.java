package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;

import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;


public class Ambulance extends Car {
    private final CollisionDetector collisionDetector;


    public Ambulance(CollisionDetector collisionDetector, int speed, int probChangeDirection) {
        super(collisionDetector, speed, probChangeDirection);
        this.collisionDetector = collisionDetector;
    }


    @Override
    public void move(Car[] carsArray) {

        if (getPos().onEdge(getCurrentDirection())) {
            bounceFromEdge();
        }

        for (int i = 0; i < getSpeed(); i++) {
            moveInDirection();
            collisionDetector.checkCollisions(this);
        }
        randomDirectionChange();
    }

    @Override
    public void moveInDirection() {

        getPos().move(getCurrentDirection());
    }


    @Override
    public String toString() {
        if (!Game.getGameHasWinner()) {
            return "Am";
        } else return "Lo";
    }
}