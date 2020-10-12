package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Ambulance;
import org.academiadecodigo.bootcamp.car.Car;
import org.academiadecodigo.bootcamp.car.players.Player;
import org.academiadecodigo.bootcamp.car.players.playerTwo.PlayerTwo;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public class CollisionDetector {

    private final Car[] cars;
    private final Ambulance[] ambulances;


    public CollisionDetector(Car[] cars, Car[] ambulances) {
        this.cars = cars;
        this.ambulances = (Ambulance[]) ambulances;


    }



    public boolean isUnSafe(GridPosition pos) {

        for (Car c : cars) {

            if (c.getPos()!= pos && c.getPos().equals(pos)) {
                return true;
            }

        }
        return false;
    }

    /**
     * Checks for collisions with specific car
     * Requires iterating the array once
     * @param car
     */
    public void check(Car car) {

        for (Car ic : cars) {

            // No point in checking collisions with self
            if (ic == car) {
                continue;
            }
                if (ic.getPos().equals(car.getPos())) {
                    ic.crash();
                    car.crash();
                }
            }
        }

    public void checkPlayer(Player player) {
        for (Ambulance ambulance : ambulances) {
            if (player.getPos().equals(ambulance.getPos()) && !ambulance.isCrashed()) {
                ambulance.crash();
                if (player instanceof PlayerTwo) {
                    player.incrementTakeDowns();
                    player.getGrid().setPlayerTwoScoreText(player.getTakeDowns());
                    return;
                }
                player.incrementTakeDowns();
                player.getGrid().setPlayerOneScoreText(player.getTakeDowns());
            }
        }
    }

    public void checkAmbulance(Car ambulance) {

        for(Car car : cars) {
            if (ambulance.getPos().equals(car.getPos()) && car.isCrashed()) {
                car.setNotCrashed();
                car.getPos().setColor(car.getOriginalColor());


            }
        }
    }

}
