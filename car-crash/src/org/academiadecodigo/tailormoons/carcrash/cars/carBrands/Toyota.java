package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;


public class Toyota extends Car {


    public Toyota(CollisionDetector collisionDetector, int Index) {
        super(collisionDetector,1, 10, Index, Directions.getRandomSaneDirection());

    }

    @Override
    public void randomDirectionChange() {

        if (hundredPercent() < getProbChangeDirection()) {

            int zeroToOne = (int) (Math.random() * 2);
            setCurrentDirection(zeroToOne == 0 ? getCurrentDirection().randomizerSanePatternOne() : getCurrentDirection().randomizerSanePatternTwo());
        }
    }

    @Override
    public String toString() {
        if (this.equals(Game.getWinner())) {
            setWinner();
            return "W";
        }
        else if (getCrashed()) {
            return "C";
        } else if (!getCrashed()) return "T";

        return null;
    }
    }
