package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;


import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;

public class RollsRoyce extends Car {


    public RollsRoyce(CollisionDetector collisionDetector, int Index) {
        super(collisionDetector, 2, 15, Index, Directions.getRandomDirection());

    }

    @Override
    public void randomDirectionChange() {

        if (hundredPercent() < getProbChangeDirection()) {

            int zeroToOne = (int) (Math.random() * 2);
            setCurrentDirection(zeroToOne == 0 ? getCurrentDirection().randomizerPatternTwo() : getCurrentDirection().randomizerPatternThree());
        }
    }

    @Override
    public String toString() {
        if (this.equals(Game.getWinner())) {
            setWinner();
            return "W";
        } else if (getCrashed()) {
            return "C";
        } else if (!getCrashed()) return "P";

        return null;
    }
}

