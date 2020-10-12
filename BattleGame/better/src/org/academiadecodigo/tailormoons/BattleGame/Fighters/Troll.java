package org.academiadecodigo.tailormoons.BattleGame.Fighters;

public class Troll extends Fighter {

    private static final int ATTACK_DAMAGE = 20;
    private static final int SPELL_DAMAGE = 6;
    private static final int INITIAL_HEALTH = 400;

    private static final int ATTACK_POSSIBILITY = 50;

    public Troll(String name) {
        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void attack(Fighter opponent) {

        if (hundredPercent() < ATTACK_POSSIBILITY) {
            super.attack(opponent);
        } else {
            System.out.println(getName() + " is resting...");
        }
    }


}
