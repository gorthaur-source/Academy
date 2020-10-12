package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;


public class Tesla extends Car {


    public Tesla(CollisionDetector collisionDetector, int Index) {
        super(collisionDetector, 3, 25, Index, Directions.getRandomDirection());

    }

    @Override
    public void randomDirectionChange() {

        if (hundredPercent() < getProbChangeDirection()) {

            int zeroToTwo = (int) (Math.random() * 3);

            switch(zeroToTwo) {
                case 0:
                    setCurrentDirection(getCurrentDirection().randomizerPatternThree());
                    break;
                case 1:
                    setCurrentDirection(getCurrentDirection().randomizerPatternOne());
                    break;
                case 2:
                    setCurrentDirection(getCurrentDirection().randomizerPatternFour());
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
