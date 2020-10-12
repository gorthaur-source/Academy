package org.academiadecodigo.tailormoons.sniperelite;
import org.academiadecodigo.tailormoons.sniperelite.gameobjects.Enemy;
import org.academiadecodigo.tailormoons.sniperelite.gameobjects.Mictable;
import org.academiadecodigo.tailormoons.sniperelite.gameobjects.Shootable;

public class SniperRifle {


    private int bulletDamage;
    private final int CRIT_CHANCE = 25;
    private final int MISS_CHANCE = 30;
    private int missedShots;

    public SniperRifle(int bulletDamage) {

        this.bulletDamage = bulletDamage;
    }

    public void mictate (Mictable mictable) {
        System.out.println(mictable.mictOnIt());
    }

    public void shoot(Shootable shootable) {

        int zeroToHundred = (int) (Math.random() * 101);

        if (zeroToHundred < MISS_CHANCE) {
            System.out.println("Shot missed!");
            missedShots++;

        } else if (zeroToHundred > (100 - CRIT_CHANCE)) {

            int effectiveDamage = (int) (bulletDamage + ((Math.random() * 40) + 10));
            System.out.println("Critical shot hit for " + effectiveDamage + " damage!");
            shootable.hit(effectiveDamage);

        } else {

            System.out.println("Shot hit for " + bulletDamage + " damage.");
            shootable.hit(bulletDamage);
        }
    }

    public int getMissedShots() {
        return missedShots;
    }
}