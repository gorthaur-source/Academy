package org.academiadecodigo.tailormoons.sniperelite;


public class EnemySoldier extends Enemy {

    public EnemySoldier(int health) {

        super(health);

    }

    @Override
    public void hit(int damage) {

        super.hit(damage);

        if (getHealth() == 0) {
            setDead();
        }
    }

    @Override
    public String getMessage() {

        return "Enemy soldier(" + getHealth() + ") approaching. Checking wind variables.";
    }

}