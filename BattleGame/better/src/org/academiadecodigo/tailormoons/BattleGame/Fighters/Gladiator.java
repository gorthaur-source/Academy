package org.academiadecodigo.tailormoons.BattleGame.Fighters;

public class Gladiator extends Fighter {

    private static final int ATTACK_DAMAGE = 60;
    private static final int SPELL_DAMAGE = 20;
    private static final int INITIAL_HEALTH = 200;

    private static final int CRITICAL_CHANCE = 10;
    private static final int CRITICAL_MULTIPLIER = 2;

    public Gladiator(String name) {
        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }


    @Override
    public void attack(Fighter opponent) {
// most verbose class - had to repeat some code here

        if(hundredPercent() > CRITICAL_CHANCE) {

            super.attack(opponent);

        } else if (hundredPercent() < CRITICAL_CHANCE) {

            getItem();

            if(oppIsWizardHasShield(opponent)) return;

            setEffectiveDamage(getAttackDamage());

            setEffectiveDamage(getEffectiveDamage() * CRITICAL_MULTIPLIER);


            if (opponent.damageMultiplier != 1) {

                setEffectiveDamage((int) (getEffectiveDamage() * opponent.damageMultiplier));
            }

            System.out.println(this + " has caused " + getEffectiveDamage() + " attack damage with a critical hit to " + opponent.toString(getEffectiveDamage()));
            opponent.suffer(getEffectiveDamage());
        }
    }


}

