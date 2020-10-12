package org.academiadecodigo.tailormoons.carcrash.cars;

import org.academiadecodigo.tailormoons.carcrash.cars.carBrands.Ambulance;

public class CollisionDetector {

    private Car[] cars;

    public CollisionDetector(Car[] cars) {
        this.cars = cars;
    }

    public CollisionDetector() {

    }

    public void checkCollisions(Ambulance ambulance) {

            for(Car car : cars) {
                if (ambulance.getPos().overlaps(car.getPos()) && car.getCrashed()) {
                    car.setNotCrashed();
                }
            }
        }

    public void checkCollisions(Car movingCar) {

        for (Car car : cars) {
            if (car == movingCar) {
                continue;
            }
            if (car.getPos().overlaps(movingCar.getPos())) {
                movingCar.setCrashed();
                car.setCrashed();
            }
        }
    }



}
