package org.academiadecodigo.tailormoons.sniperelite.gameobjects;


public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health, int armor) {
        super(health);
        this.armour = armor;
    }

    @Override
    public void hit(int shotDamage) {
        armour -= shotDamage;
        if(armour<0) {
            super.hit(Math.abs(armour));
            armour=0;
        }
    }

    public int getArmor() {
        return armour;
    }

    @Override
    public String getMessage() {

        return this + " approaching. It has " + getArmor() + " armour points. Armour piercing rounds loaded.";
    }

    @Override
    public String toString() {
        return "Armoured vehicle(" + getHealth() + ")";
    }
}