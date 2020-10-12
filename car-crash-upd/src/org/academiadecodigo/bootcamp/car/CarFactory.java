package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.car.players.playerOne.PlayerOne;
import org.academiadecodigo.bootcamp.car.players.playerTwo.PlayerTwo;
import org.academiadecodigo.bootcamp.grid.Grid;

/**
 * A factory of different types of Cars
 */
public class CarFactory {

    /**
     * Manufactures new random cars
     *
     * @return a newly instantiated car
     */
    public static Car getNewCar(Grid grid, int Index) {

        int random = (int) (Math.random() * CarType.values().length);
        CarType carType = CarType.values()[random];

        Car car;

        if (carType == CarType.MUSTANG) {
            car = new Mustang(grid.makeGridPosition(), Index);
        } else {
            car = new Fiat(grid.makeGridPosition(), Index);
        }

        return car;

    }

    public static Car getNewAmbulance(Grid grid) {

        return new Ambulance(grid.makeGridPositionEllipse(1), 1000);
    }

    public static Car getNewPlayerOne(Grid grid) {
        return new PlayerOne(grid.makeGridPositionEllipse(2), 1002);
    }
    public static Car getNewPlayerTwo(Grid grid) {
        return new PlayerTwo(grid.makeGridPositionEllipse(2), 1002);
    }

}
