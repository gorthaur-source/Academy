package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Ambulance;
import org.academiadecodigo.bootcamp.car.Car;
import org.academiadecodigo.bootcamp.car.CarFactory;
import org.academiadecodigo.bootcamp.car.players.playerOne.PlayerOne;
import org.academiadecodigo.bootcamp.car.players.playerTwo.PlayerTwo;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridFactory;
import org.academiadecodigo.bootcamp.grid.GridType;

/**
 * The game logic
 */
public class Game {


    /**
     * Graphical Car field
     */
    private final Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;
    private Ambulance[] ambulances;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;

    /**
     * Animation delay
     */
    protected static int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private final int manufacturedCars = 10;
    private final int manufacturedAmbulances = 7;
    boolean gameHasWinner = false;
    private Car winner;

    /**
     * Constructs a new game
     *
     * @param gridType which grid type to use
     * @param cols     number of columns in the grid
     * @param rows     number of rows in the grid
     * @param delay    animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        Game.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        grid.init();

        cars = new Car[manufacturedCars];
        ambulances = new Ambulance[manufacturedAmbulances];

        playerOne = (PlayerOne) CarFactory.getNewPlayerOne(grid);
        playerTwo = (PlayerTwo) CarFactory.getNewPlayerTwo(grid);

        collisionDetector = new CollisionDetector(cars, ambulances);

        playerOne.setCollisionDetector(collisionDetector);
        playerOne.setGrid(grid);

        playerTwo.setCollisionDetector(collisionDetector);
        playerTwo.setGrid(grid);

        for (int i = 0; i < manufacturedCars; i++) {

            cars[i] = CarFactory.getNewCar(grid, i);
            cars[i].setCollisionDetector(collisionDetector);
            cars[i].setGrid(grid);

        }

        for (int i = 0; i < ambulances.length; i++) {

            ambulances[i] = CarFactory.getNewAmbulance(grid);
            ambulances[i].setCollisionDetector(collisionDetector);
            ambulances[i].setGrid(grid);
        }

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

            moveAllCars();

        }

    }

    /**
     * Moves all cars
     */
    public void moveAllCars() throws InterruptedException {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
            if (gameHasWinner) { // win condition stops movement
                break;
            }
        }
        recordWinner();
        if (gameHasWinner && winner!=null) {
            winner.flashColorWinner(); // winner flashes
        }
        for (Ambulance ambulance : ambulances) {
            ambulance.move();
            collisionDetector.checkAmbulance(ambulance);
            if (gameHasWinner) break;
        }
        playerOne.move();
        playerTwo.move();
    }

    public void recordWinnerPlayer() {

        for (Ambulance ambulance : ambulances) {
            if (!ambulance.isCrashed()) { // returns if there's at least an ambulance not crashed - player hasn't won
                return;
            }
        }
        if(playerOne.getTakeDowns() > playerTwo.getTakeDowns()) {
        winner = playerOne; }
        if(playerOne.getTakeDowns() < playerTwo.getTakeDowns()) {
            winner = playerTwo; }
        gameHasWinner = true;
    }



    public void recordWinnerBots() { // automated cars only win when only one of them remains

        int indexWinner = -1;
        boolean found = false;
        for (int i = 0; i < cars.length; i++) {
            if (!cars[i].isCrashed()) {
                if (found) {
                    return;
                }
                found = true;
                indexWinner = i;
            }
        }
        if (indexWinner != -1) {
            winner = cars[indexWinner];
            gameHasWinner = true;
        }
    }
      public void recordWinner() {

       recordWinnerBots();
       recordWinnerPlayer();
    }

    public static int getDelay() {
        return delay;
    }

}

