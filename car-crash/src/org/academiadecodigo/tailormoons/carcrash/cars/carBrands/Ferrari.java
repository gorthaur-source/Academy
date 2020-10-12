package org.academiadecodigo.tailormoons.carcrash.cars.carBrands;
import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.Directions;
import org.academiadecodigo.tailormoons.carcrash.Game;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;


public class Ferrari extends Car {


    public Ferrari(CollisionDetector collisionDetector, int Index) {
        super(collisionDetector, 3, 20, Index, Directions.getRandomDirection());

    }

    @Override
    public String toString() {
        if (this.equals(Game.getWinner())) {
            setWinner();
            return "W";
        } else if (getCrashed()) {
            return "C";
        } else if (!getCrashed()) return "F";

        return null;
    }
}

