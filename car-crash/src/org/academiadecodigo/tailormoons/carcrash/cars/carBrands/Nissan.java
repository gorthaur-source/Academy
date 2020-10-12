package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;


public class Nissan extends Car {


    public Nissan(CollisionDetector collisionDetector, int Index) {
        super(collisionDetector,1, 8, Index, Directions.getRandomSaneDirection());

    }

    @Override
    public void randomDirectionChange() {

        if (hundredPercent() < getProbChangeDirection()) {

            int zeroToOne = (int) (Math.random() * 3);

            setCurrentDirection(zeroToOne == 0 ? getCurrentDirection().randomizerSanePatternTwo() : getCurrentDirection().randomizerSanePatternOne());



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
        } else if (!getCrashed()) return "S";

        return null;
    }
    }
