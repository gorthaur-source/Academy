package org.academiadecodigo.tailormoons.sniperelite.gameobjects;


public class EnemySoldier extends Enemy {

    public EnemySoldier(int health) {

        super(health);

    }

    @Override
    public String getMessage() {

        return this + " approaching. Checking wind variables.";
    }

    @Override
    public String toString() {
        return "Enemy soldier(" + getHealth() + ")";
    }

}