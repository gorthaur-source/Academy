package org.academiadecodigo.tailormoons.carcrash.cars;

public class CollisionDetector {

    private Car[] cars;

    public CollisionDetector(Car[] cars) {
        this.cars = cars;
    }

    public CollisionDetector() {

    }

    public void checkCollisions(Car movingCar) {
        for(Car car : cars) {
            if(car==movingCar) {
                continue;
            }
            if(car.getPos().overlaps(movingCar.getPos())) {
                movingCar.setCrashed();
                car.setCrashed();
            }
        }

    }

}
