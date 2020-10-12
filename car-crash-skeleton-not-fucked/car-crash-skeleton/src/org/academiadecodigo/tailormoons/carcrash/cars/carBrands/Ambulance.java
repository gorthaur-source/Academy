package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;

import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.field.Position;


public class Ambulance extends Car {

    private int diffX;
    private int diffY;
    private int posX;
    private int posY;
    Car chase;

    public Ambulance(int speed) {
        super(speed);
    }


    public void moveNormal() {
        if (getPos().onEdge(getCurrentDirection())) {
            bounceFromEdge();
        }
        randomDirectionChange();
        getPos().move(getCurrentDirection());
    }


    @Override
    public void move() {
            setY();
           // getPos().move(getCurrentDirection());
            setX();
           // getPos().move(getCurrentDirection());
           if(getPos().overlaps(chase.getPos()) && chase!=null && chase.getPos() != null) healCrashedCars();
        }



    @Override
    public void goToPosition(Car[] carsArray) {
        for (Car car : carsArray) {
            if (!car.getCrashed()) {
                moveNormal();
            } else {
                posX = car.getPos().getCol();
                posY = car.getPos().getRow();
                diffX = posX - getPos().getCol();
                diffY = posY - getPos().getRow();
                chase = car;
                move();
                break;
            }
        }
    }

    public void setX() {

        if (diffX < 0) {
            setCurrentDirection(Directions.LEFT);
        } else if (diffX > 0) {
            setCurrentDirection(Directions.RIGHT);
        }
    }

    public void setY() {

        if(diffY<0) {
            setCurrentDirection(Directions.UP);
            } else if(diffY>0) {
                setCurrentDirection(Directions.DOWN);
        }
    }

   public void healCrashedCars() {
        if(chase!=null) {
            this.chase.setNotCrashed();
        }
}



    @Override
    public String toString() {

        return "Amb";
    }
    }
