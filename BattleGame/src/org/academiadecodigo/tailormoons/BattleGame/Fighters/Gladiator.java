package org.academiadecodigo.tailormoons.BattleGame.Fighters;

public class Gladiator extends Fighter {

    private static final int ATTACK_DAMAGE = 30;
    private static final int SPELL_DAMAGE = 5;
    private static final int INITIAL_HEALTH = 50;

    private static final int CRITICAL_CHANCE = 10;
    private static final int CRITICAL_MULTIPLIER = 2;

    public Gladiator(String name) {
        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }


    @Override
    public void attack(Fighter opponent) {
        if (opponent instanceof Wizard && ((Wizard) opponent).getShieldStatus()) {
            System.out.println(opponent.getName() + " has absorbed " + getName() + "'s hit!");
        }
        else if(hundredPercent() < CRITICAL_CHANCE) {
            System.out.println(getName() + "(" + getHealth() +  ") has hit " + opponent.getName() + "(" + opponent.getHealth() + ") with a critical hit for " + (ATTACK_DAMAGE*CRITICAL_MULTIPLIER) + " damage!");
            opponent.suffer(ATTACK_DAMAGE*CRITICAL_MULTIPLIER);

        } else {
            System.out.println(getName() + "(" + getHealth() + ") has hit " + opponent.getName() + "(" + opponent.getHealth() + ") for " + ATTACK_DAMAGE + " damage!");
            opponent.suffer(ATTACK_DAMAGE);

        }
    }

}

