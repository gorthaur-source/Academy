package org.academiadecodigo.tailormoons.sniperelite;

public abstract class Enemy extends GameObject {


    private int health;

    private boolean isDead;


    public Enemy(int health) {
        this.health = health;
    }

    public void hit(int shotDamage) {

        health -= shotDamage;

        if (health<0) {
            health = 0;
        }

    }

    public boolean isDead() {

        return isDead;
    }


    @Override
    public String getMessage() {

        return "Enemy approaching. Checking wind variables.";
    }

    public int getHealth() {
        return health;
    }




    public void setDead() {
        isDead = true;
    }
}
