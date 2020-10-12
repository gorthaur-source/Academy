package org.academiadecodigo.tailormoons.guessanumber;

public class Player {


    private String name;
    private boolean isMale;
    private static int[] madeGuesses = new int[50];
    private int MAX = 60;
    private static int counter = 0;

    public Player(String name, boolean isMale) {
        this.name = name;
        this.isMale = isMale;


    }

    public Player() {
        isMale = true;
    }

    public Player(String name) {
        this.name = name;
        isMale = true;
    }


    public String getName() {
        return name;
    }

    public boolean getGender() {
        return this.isMale;
    }


    public void setName(String name) {
        this.name = name;

    }
    /*
    public int[] formArray() {
        for(int i = 0; i<getMAX(); i++) {
            madeGuesses[i] = Randomizer.generateNumber(getMAX());
        }
        return madeGuesses;
    }

    public int[] makeGuess() {
        for(int i = 0; i<madeGuesses.length; i++) {
            madeGuesses[i] = Randomizer.generateNumber(getMAX());
        }

        for (int i = 0; i < madeGuesses.length; i++) {
            for (int j = i + 1; j < madeGuesses.length; j++) {
                while (madeGuesses[i] == madeGuesses[j]) {
                    madeGuesses[i] = Randomizer.generateNumber(getMAX());
                }
            }
        }
        return madeGuesses;
    }
    public int[] getGuesses() {
    return madeGuesses;
}
*/
    public int educatedGuess() {
        int guess = Randomizer.generateNumber(getMAX());
        while (!isValid(guess)) {
            guess = Randomizer.generateNumber(getMAX());
        }
            addToGuesses(guess);
            return guess;

    }
    public void addToGuesses(int guess) {
        madeGuesses[counter] = guess;
        ++counter;

    }

public boolean isValid (int guess) {
        boolean valid = false;
    for(int i = 0; i<madeGuesses.length; i++) {
        if(guess == madeGuesses[i]) {
          valid = false;
          return valid;
        }
        else valid = true;
    }
    return valid;
}
public int[] getArray() {
        return madeGuesses;
}
public int getMAX() {
        return MAX;
}
    }

