package org.academiadecodigo.tailormoons.carcrash;


public enum Directions {

    UP,
    DOWN,
    LEFT,
    RIGHT,
    UP_AND_RIGHT,
    UP_AND_LEFT,
    DOWN_AND_LEFT,
    DOWN_AND_RIGHT;


    public static Directions getRandomDirection() {

        int randomIndex = (int) Math.floor(Math.random() * Directions.values().length);
        return Directions.values()[randomIndex];
    }

    public static Directions getRandomSaneDirection() {
        return Directions.values()[(int) (Math.random() * 4)];
    }

    public Directions goOppositeDirection() {

        switch (this) {

            case LEFT:
                return Directions.RIGHT;
            case RIGHT:
                return Directions.LEFT;
            case UP:
                return Directions.DOWN;
            case DOWN:
                return Directions.UP;
            case UP_AND_RIGHT:
                return Directions.DOWN_AND_LEFT;
            case UP_AND_LEFT:
                return Directions.DOWN_AND_RIGHT;
            case DOWN_AND_LEFT:
                return Directions.UP_AND_RIGHT;
            case DOWN_AND_RIGHT:
                return Directions.UP_AND_LEFT;
        }
        return null;
    }

    public Directions randomizerPatternOne() {

        switch (this) {

            case LEFT:
                return Directions.UP_AND_LEFT;
            case RIGHT:
                return Directions.DOWN_AND_RIGHT;
            case UP:
                return Directions.LEFT;
            case DOWN:
                return Directions.RIGHT;
            case UP_AND_RIGHT:
                return Directions.DOWN;
            case UP_AND_LEFT:
                return Directions.UP_AND_RIGHT;
            case DOWN_AND_LEFT:
                return Directions.DOWN_AND_LEFT;
            case DOWN_AND_RIGHT:
                return Directions.UP;
        }
        return null;
    }

    public Directions randomizerPatternTwo() {

        switch (this) {

            case LEFT:
                return Directions.DOWN_AND_LEFT;
            case RIGHT:
                return Directions.UP_AND_RIGHT;
            case UP:
                return Directions.RIGHT;
            case DOWN:
                return Directions.LEFT;
            case UP_AND_RIGHT:
                return Directions.UP;
            case UP_AND_LEFT:
                return Directions.UP_AND_LEFT;
            case DOWN_AND_LEFT:
                return Directions.DOWN_AND_RIGHT;
            case DOWN_AND_RIGHT:
                return Directions.DOWN;
        }
        return null;

    }

    public Directions randomizerPatternThree() {

        switch (this) {

            case LEFT:
                return Directions.DOWN_AND_RIGHT;
            case RIGHT:
                return Directions.UP_AND_LEFT;
            case UP:
                return Directions.RIGHT;
            case DOWN:
                return Directions.LEFT;
            case UP_AND_RIGHT:
                return Directions.UP;
            case UP_AND_LEFT:
                return Directions.DOWN_AND_LEFT;
            case DOWN_AND_LEFT:
                return Directions.UP_AND_RIGHT;
            case DOWN_AND_RIGHT:
                return Directions.DOWN;
        }
        return null;
    }

    public Directions randomizerPatternFour() {

        switch (this) {

            case LEFT:
                return Directions.DOWN;
            case RIGHT:
                return Directions.UP;
            case UP:
                return Directions.UP_AND_RIGHT;
            case DOWN:
                return Directions.DOWN_AND_LEFT;
            case UP_AND_RIGHT:
                return Directions.DOWN_AND_RIGHT;
            case UP_AND_LEFT:
                return Directions.RIGHT;
            case DOWN_AND_LEFT:
                return Directions.LEFT;
            case DOWN_AND_RIGHT:
                return Directions.UP_AND_LEFT;
        }
        return null;
    }

    public Directions randomizerSanePatternOne() {

        switch (this) {

            case LEFT:
                return Directions.DOWN;
            case RIGHT:
                return Directions.UP;
            case UP:
                return Directions.LEFT;
            case DOWN:
                return Directions.RIGHT;
        }
        return null;
    }

    public Directions randomizerSanePatternTwo() {

        switch (this) {

            case LEFT:
                return Directions.UP;
            case RIGHT:
                return Directions.DOWN;
            case UP:
                return Directions.RIGHT;
            case DOWN:
                return Directions.LEFT;
        }
        return null;
    }
}
