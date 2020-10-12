package org.academiadecodigo.tailormoons.BattleGame.Fighters;

public class Wizard extends Fighter {

    private static final int ATTACK_DAMAGE = 6;
    private static final int SPELL_DAMAGE = 20;
    private static final int INITIAL_HEALTH = 70;
    private static final int SHIELD_PROBABILITY = 15;

    private boolean shield;

    public Wizard (String name) {
        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void cast(Fighter opponent) {
        System.out.println(getName() + "(" + getHealth() + ") has hit " + opponent.getName() + "(" + opponent.getHealth() + ") with a spell for " + SPELL_DAMAGE + " damage.");
        opponent.suffer(SPELL_DAMAGE);
        if(hundredPercent() < SHIELD_PROBABILITY) {
            shield = true;
            System.out.println(getName() + " has gained a shield!");

        }

    }
    @Override
    public void suffer(int damage) {
        if(shield) {
            shield = false;
            return;
        }
        super.suffer(damage);
        if(getHealth()<=0) setDeadPrint();
    }


    public boolean getShieldStatus() {
        return shield;
    }
}
