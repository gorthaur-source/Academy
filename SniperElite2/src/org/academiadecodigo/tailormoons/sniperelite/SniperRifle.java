package org.academiadecodigo.tailormoons.sniperelite;


public class SniperRifle {


    private int bulletDamage;
    private final int CRIT_CHANCE = 25;
    private final int MISS_CHANCE = 30;

    public SniperRifle(int bulletDamage){

        this.bulletDamage = bulletDamage;
    }

    public void shoot(GameObject enemy){

        int zeroToHundred = (int) (Math.random() * 101);

        if(enemy instanceof Enemy) {

            if (zeroToHundred < MISS_CHANCE) {
                System.out.println("Shot missed!");
            }
            else if (zeroToHundred > (100-CRIT_CHANCE)) {
                int effectiveDamage = (int) (bulletDamage + ((Math.random() * 40) + 10));
                ((Enemy) enemy).hit(effectiveDamage);
                System.out.println("Critical shot hit for " + effectiveDamage + " damage!");

                if (((Enemy) enemy).isDead()) {
                    System.out.println("Enemy died. Headshot.");
                } else {

                    ((Enemy) enemy).hit(bulletDamage);
                    System.out.println("Shot hit for " + bulletDamage + " damage.");
                    if (((Enemy) enemy).isDead()) {

                        System.out.println("Enemy died.");
                    }
                }
            }
        }
        if(enemy instanceof Barrel) {
            if (zeroToHundred < MISS_CHANCE) {
                System.out.println("Shot missed!");
            }
            else if (zeroToHundred > (100-CRIT_CHANCE)) {
                int effectiveDamage = (int) (bulletDamage + ((Math.random() * 40) + 10));
                ((Barrel) enemy).hit(effectiveDamage);
                System.out.println("Critical shot hit for " + effectiveDamage + " damage!");

                if (((Barrel) enemy).getIsDestroyed()) {
                    System.out.println("Enemy died. Headshot.");
                } else {

                    ((Barrel) enemy).hit(bulletDamage);
                    System.out.println("Shot hit for " + bulletDamage + " damage.");
                    if (((Enemy) enemy).isDead()) {

                        System.out.println("Enemy died.");
                    }
                }
            }
        }

        }
}