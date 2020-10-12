package org.academiadecodigo.tailormoons.guessanumber;

import java.util.Arrays;

public class Game {


    public void start(Player[] players) {

        int computerGuess = Randomizer.generateNumber(30);
        boolean gameOver = false;
        System.out.println("Let the games begin!");
        while (!gameOver) {
            for (int i = 0; i < players.length; i++) {
                int guess = players[i].educatedGuess();
                if (computerGuess == guess) {
                    System.out.println((Arrays.toString(players[i].getArray())));
                    System.out.println(players[i].getName() + " guessed the number! It was " + guess);
                    gameOver = true;
                    break;

                } else {
                        System.out.println(players[i].getName() + " failed! The guess was " + guess + ". Next!");
                }
            }
        }


    }
}
