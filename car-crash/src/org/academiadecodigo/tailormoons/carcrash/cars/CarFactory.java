package org.academiadecodigo.tailormoons.carcrash.cars;

import org.academiadecodigo.tailormoons.carcrash.cars.carBrands.*;

public class CarFactory {


    enum CarBrands {

        Audi,
        BMW,
        Ferrari,
        RollsRoyce,
        Honda,
        Toyota,
        Subaru,
        Porsche,
        Nissan,
        Tesla;
    }

    public static Car getNewCar(CollisionDetector collisionDetector, int Index) {

        int randIndex = (int) (Math.random() * CarBrands.values().length);

        switch(randIndex) {
            case 0:
                return new Audi(collisionDetector, Index);
            case 1:
                return new BMW(collisionDetector, Index);
            case 2:
                return new Ferrari(collisionDetector, Index);
            case 3:
                return new RollsRoyce(collisionDetector, Index);
            case 4:
                return new Honda(collisionDetector, Index);
            case 5:
                return new Toyota(collisionDetector, Index);
            case 6:
                return new Subaru(collisionDetector, Index);
            case 7:
                return new Porsche(collisionDetector, Index);
            case 8:
                return new Nissan(collisionDetector, Index);
            case 9:
                return new Tesla(collisionDetector, Index);
        }
            return null;
    }

    public static Ambulance getNewAmbulance(CollisionDetector collisionDetector1, int speed, int probChangeDirection) {
        return new Ambulance(collisionDetector1, speed, probChangeDirection);

    }
}
