package org.academiadecodigo.tailormoons.carcrash;

import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.cars.carBrands.Ambulance;
import org.academiadecodigo.tailormoons.carcrash.cars.carBrands.BMW;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;
import org.academiadecodigo.tailormoons.carcrash.cars.CarFactory;
import org.academiadecodigo.tailormoons.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private final int delay;
    private static Car winner = new BMW(new CollisionDetector(), 1000);
    private boolean gameHasWinner = false;
    private Car ambulance;
    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        CollisionDetector collisionDetector = new CollisionDetector(cars);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar(collisionDetector, i);
        }
        this.ambulance = new Ambulance(1);
        Field.draw(cars, ambulance);
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars, ambulance);

        }
    }

    private void moveAllCars() {


        for (Car car : cars) {
            recordWinner();
            car.move();
            ambulance.goToPosition(cars);
            if (gameHasWinner) {
               break;
            }
        }
    }

    public  void recordWinner() {
        int indexWinner = -1;
        boolean found = false;
        for (int i = 0; i < cars.length; i++) {
            if (!cars[i].getCrashed()) {
                if (found) {
                    return;
                }
                    found = true;
                    indexWinner = i;
            }
        }
        if(indexWinner!=-1) {
            winner = cars[indexWinner];
            gameHasWinner = true;
        }
    }

    public static Car getWinner() {
        return winner;
    }


    public Car[] getCarArray() {
        return cars;
    }
}
