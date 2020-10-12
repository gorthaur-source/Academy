package org.academiadecodigo.tailormoons.BattleGame.Fighters;

public class Troll extends Fighter {

    private static final int ATTACK_DAMAGE = 8;
    private static final int SPELL_DAMAGE = 2;
    private static final int INITIAL_HEALTH = 300;

    private static final int ATTACK_POSSIBILITY = 50;

    public Troll(String name) {
        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void attack(Fighter opponent) {
        if(hundredPercent() < ATTACK_POSSIBILITY) {
            if ((opponent instanceof Wizard) && ((Wizard) opponent).getShieldStatus()) {
                System.out.println(opponent.getName() + " has absorbed " + getName() + "'s hit!");
                return;
            } else {
                System.out.println(getName() + "(" + getHealth() + ") has hit " + opponent.getName() + "(" + opponent.getHealth() + ") for " + ATTACK_DAMAGE + " damage!");
                opponent.suffer(ATTACK_DAMAGE);
                return;
            }
        }
        System.out.println(getName() + " is resting...");
    }



}
