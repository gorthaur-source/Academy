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



    public boolean isUnSafe(GridPosition pos) { // i don't understand this method but i know it does the work as i've tried replacing it with check. ¯\_(ツ)_/¯

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

        public void checkPlayer(Player player) { // check player collision with ambulances. collisions increase respective player takedowns by 1 and update scoreBoard

            int x1 = player.getPos().getCol();
            int y1 = player.getPos().getRow();
            double r2 = 1; // radius of player circumference
            double r1 = 2;
            for (Ambulance ambulance : ambulances) {

                int x2 = ambulance.getPos().getCol();
                int y2 = ambulance.getPos().getRow();
                double distSq = Math.sqrt(((x1 - x2)
                        * (x1 - x2))
                        + ((y1 - y2)
                        * (y1 - y2)));

                if ((distSq + r2 <= r1 - 0.5) && !ambulance.isCrashed()) { // magic collision formula
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

    public void checkAmbulance(Ambulance ambulance) { // when ambulances collide with cars they uncrash them

        for(Car car : cars) {
            if (ambulance.getPos().equals(car.getPos()) && car.isCrashed()) {
                car.setNotCrashed();
                car.getPos().setColor(car.getOriginalColor());


            }
        }
    }

}
