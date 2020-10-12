package org.academiadecodigo.tailormoons.sniperelite;


public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health, int armor) {
        super(health);
        this.armour = armor;
    }

    @Override
    public void hit(int shotDamage) {

        if (getArmor() >= shotDamage){
            armour -= shotDamage;
        }
        else if (armour>0) {
            armour = armour - shotDamage;
            hit(Math.abs(armour));
        } else {
            super.hit(shotDamage);
        }
        if (getHealth() == 0 ){
            setDead();
        }
    }

    public int getArmor() {
        return armour;
    }

    @Override
    public String getMessage() {

        return "Enemy (" + getHealth() + ") approaching. It has " + getArmor() + " armour points. Armour piercing rounds loaded.";
    }

}
