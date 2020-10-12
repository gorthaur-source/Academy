package org.academiadecodigo.tailormoons.sniperelite.gameobjects;

public abstract class Enemy extends GameObject implements Shootable {


    private int health;
    private boolean isDead;
    private boolean isDestroyed;


    public Enemy(int health) {
        this.health = health;
    }

    public void hit(int shotDamage) {

        health -= shotDamage;

        if (health<0) {
            health = 0;
        }
        if (getHealth() == 0) {
            setDestroyed();
            System.out.println(this + " has perished.");
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

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed() {
        isDestroyed = true;
    }

    public void setDead() {
        isDead = true;
    }
}
