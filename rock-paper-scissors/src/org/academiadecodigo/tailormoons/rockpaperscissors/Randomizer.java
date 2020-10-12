package org.academiadecodigo.tailormoons.rockpaperscissors;

public class Randomizer {

    public static HandType randomizeHand() {

        int randIndex = (int) (Math.random() * HandType.values().length);
        return HandType.values()[randIndex];

      /*
      int play = (int) Math.floor(Math.random() * 5);

      switch (play) {

            case 0:
                return org.academiadecodigo.tailormoons.rockpaperscissors.HandType.ROCK;

            case 1:
                return org.academiadecodigo.tailormoons.rockpaperscissors.HandType.PAPER;

            case 2:
                return org.academiadecodigo.tailormoons.rockpaperscissors.HandType.SCISSORS;

            case 3:
                return org.academiadecodigo.tailormoons.rockpaperscissors.HandType.LIZARD;

            case 4:
                return org.academiadecodigo.tailormoons.rockpaperscissors.HandType.SPOCK;
        }


        return null;
    }

       */
    }
}


