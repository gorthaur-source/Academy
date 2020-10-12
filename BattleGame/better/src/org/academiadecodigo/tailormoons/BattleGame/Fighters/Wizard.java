package org.academiadecodigo.tailormoons.BattleGame.Fighters;

import org.academiadecodigo.tailormoons.BattleGame.Items.*;

public class Wizard extends Fighter {

    private static final int ATTACK_DAMAGE = 12;
    private static final int SPELL_DAMAGE = 40;
    private static final int INITIAL_HEALTH = 160;
    private static final int SHIELD_PROBABILITY = 25;

    private boolean shield;
// fix spelldmg
    public Wizard (String name) {
        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void cast(Fighter opponent) {

        super.cast(opponent);
        if(hundredPercent() < SHIELD_PROBABILITY) {
            shield = true;
            System.out.println(getName() + " has gained a shield!");

        }

    }

    @Override
    public void suffer(int damage) {

        super.suffer(damage);
        if(getHealth()<=0) setDeadPrint();
    }


    public boolean getShieldStatus() {
        return shield;
    }

    public void setShieldFalse() {
        shield = false;
    }

}
