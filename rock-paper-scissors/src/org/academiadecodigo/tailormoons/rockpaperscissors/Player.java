package org.academiadecodigo.tailormoons.rockpaperscissors;

public class Player {

    private String name;
    private int victories = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HandType showHand() {
        return Randomizer.randomizeHand();
    }

    public int getVictories() {
        return victories;
    }
    public void incrementVictories() {

        victories++;
    }
    }
