package org.academiadecodigo.tailormoons.guessanumber;

public class Game1 {


    public void start(Player[] players) {
        System.out.println("Let the games begin!");
        int numberGuess = 10000;
        //int[] numberGuesses = Randomizer.shuffle(Randomizer.noRepeats(10));
        int computerChoice = Randomizer.generateNumber(10);
        while (numberGuess != computerChoice) {
            numberGuess = Randomizer.generateNumber(30);
            for (Player player : players) {
                numberGuess = Randomizer.generateNumber(10);
                if (computerChoice == numberGuess) {
                    if (player.getGender()) {
                        System.out.println("Game Over! " + player.getName() + " wins. He guessed the number " + numberGuess + "! The computer sucks!");
                        return;
                    } else {
                        System.out.println("Game Over! " + player.getName() + " wins. She guessed the number " + numberGuess + "! The computer sucks!");
                        return;
                    }

                } else {
                    System.out.println(player.getName() + " failed in guessing the number! The number picked was " + numberGuess + "! Next!");

                }
            }
        }
            System.out.println("Game Over! Computers Master Race!");

    }
}
