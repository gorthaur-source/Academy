package org.academiadecodigo.tailormoons.carcrash.cars;

import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.field.Position;


public abstract class Car {

    private Position pos;
    private Directions currentDirection;
    private boolean crashed = false;
    private final int speed;
    private int probChangeDirection;
    private int ID;
    private boolean isWinner;
    private CollisionDetector collisionDetector;

    public Car(CollisionDetector collisionDetector, int speed, int probChangeDirection, int ID, Directions startingDirection) {
        this.collisionDetector = collisionDetector;
        this.pos = new Position();
        this.speed = speed;
        currentDirection = startingDirection;
        this.probChangeDirection = probChangeDirection;
        this.ID = ID;
    }
    public Car(int speed) {
        this.speed = speed;
        this.pos = new Position();
        this.currentDirection = Directions.getRandomSaneDirection();
    }


    public void move() {

        if (getCrashed()) {
            return;
        }

        if (pos.onEdge(currentDirection)) {
            bounceFromEdge();
        }
            moveInDirection();
            randomDirectionChange();


    }

    public void bounceFromEdge() {

        currentDirection = currentDirection.goOppositeDirection(); // immediately bounce from edge  in opposite direction

    }

    public void randomDirectionChange() {

        if (hundredPercent() < probChangeDirection) {

            int zeroToThree = (int) (Math.random() * 4);

            switch (zeroToThree) {
                case 0:
                    setCurrentDirection(getCurrentDirection().randomizerPatternOne());
                case 1:
                    setCurrentDirection(getCurrentDirection().randomizerPatternTwo());
                case 2:
                    setCurrentDirection(getCurrentDirection().randomizerPatternThree());
                case 3:
                    setCurrentDirection(getCurrentDirection().randomizerPatternFour());
            }
        }
    }

    public void moveInDirection() {

        // move once for every speed unit

        for (int i = 0; i < speed; i++) {

            pos.move(currentDirection);
            collisionDetector.checkCollisions(this);

            if(getCrashed()) {
                break;
            }
        }
    }

    public int hundredPercent() {
        //returns random number between 0 and 100
    return (int) (Math.random() * 101);
    }

    public int getProbChangeDirection() {
        return probChangeDirection;
    }

    public Position getPos() {
        return pos;
    }

    public void setCrashed() {
        crashed = true;
    }
    public void setNotCrashed() {
        crashed = false;
    }
    public boolean getCrashed() {
        return crashed;
    }

    public Directions getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Directions direction) {
        currentDirection = direction;
    }

    public int getID() {
        return ID;
    }
    public void setWinner() {
        isWinner = true;
    }

    public boolean equals(Car object) {
        return getID() == object.getID();
    }

    public void goToPosition(Car[] carArray) {};
}


