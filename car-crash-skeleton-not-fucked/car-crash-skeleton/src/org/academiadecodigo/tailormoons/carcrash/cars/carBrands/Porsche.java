package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;


public class Porsche extends Car {


    public Porsche(CollisionDetector collisionDetector, int Index) {
        super(collisionDetector,4, 30, Index, Directions.getRandomDirection());

    }

    @Override
    public void randomDirectionChange() {

        if (hundredPercent() < getProbChangeDirection()) {

            int zeroToTwo = (int) (Math.random() * 3);

            switch(zeroToTwo) {
                case 0:
                    setCurrentDirection(getCurrentDirection().randomizerPatternOne());
                    break;
                case 1:
                    setCurrentDirection(getCurrentDirection().randomizerPatternTwo());
                    break;
                case 2:
                    setCurrentDirection(getCurrentDirection().randomizerPatternThree());
                    break;

            }
            setCurrentDirection(zeroToTwo == 0 ? getCurrentDirection().randomizerPatternTwo() : getCurrentDirection().randomizerPatternThree());
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
