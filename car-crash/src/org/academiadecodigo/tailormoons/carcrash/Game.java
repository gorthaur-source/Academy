package org.academiadecodigo.tailormoons.carcrash;

import org.academiadecodigo.tailormoons.carcrash.cars.CollisionDetector;
import org.academiadecodigo.tailormoons.carcrash.cars.carBrands.Ambulance;
import org.academiadecodigo.tailormoons.carcrash.cars.carBrands.BMW;
import org.academiadecodigo.tailormoons.carcrash.cars.Car;
import org.academiadecodigo.tailormoons.carcrash.cars.CarFactory;
import org.academiadecodigo.tailormoons.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;
    public static final int MANUFACTURED_AMBULANCES = 3;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private final int delay;
    private static Car winner = new BMW(new CollisionDetector(), 1000);
    private static boolean gameHasWinner = false;
    private Ambulance[] ambulances;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        ambulances = new Ambulance[MANUFACTURED_AMBULANCES];

        CollisionDetector collisionDetector = new CollisionDetector(cars);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar(collisionDetector, i);
        }

        CollisionDetector collisionDetector1 = new CollisionDetector(cars);

        for(int i = 0; i < ambulances.length; i++) {
            ambulances[i] = CarFactory.getNewAmbulance(collisionDetector1, 1, 15);
        }
        Field.draw(cars, ambulances);
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
            Field.draw(cars, ambulances);

        }
    }

    private void moveAllCars() {


        for (Car car : cars) {
                recordWinner();
                car.move();
                if (gameHasWinner) {
                    break;
                }
            }

        if (!gameHasWinner) {
            for(Ambulance ambulance : ambulances) {
                ambulance.move(cars);
            }
        }
    }

    public void recordWinner() {
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

    public static boolean getGameHasWinner() {
        return gameHasWinner;
    }


}
