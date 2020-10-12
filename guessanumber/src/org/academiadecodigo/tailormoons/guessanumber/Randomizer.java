package org.academiadecodigo.tailormoons.guessanumber;

public class Randomizer {

    public static int generateNumber(int max) {
        return (int) Math.floor(Math.random() * (max + 1));
    }

    public int[] noRepeats(int max) {
        int[] guessArray = new int[max];
        for (int i = 0; i < guessArray.length; i++) {
            guessArray[i] = i;
        }
        return guessArray;
    }

    public int[] shuffle(int[] playerGuesses) {
        for (int i = playerGuesses.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            int k = playerGuesses[i];
            playerGuesses[i] = playerGuesses[j];
            playerGuesses[j] = k;
        }
        return playerGuesses;
    }
}