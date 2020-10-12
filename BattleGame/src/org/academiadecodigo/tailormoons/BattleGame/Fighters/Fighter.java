package org.academiadecodigo.tailormoons.BattleGame.Fighters;

public abstract class  Fighter {

    private final String name;
    private final int ATTACK_DAMAGE;
    private final int SPELL_DAMAGE;
    public int health;
    private boolean isDeadPrint = false;

    public Fighter(String name, int ATTACK_DAMAGE , int SPELL_DAMAGE, int health) {
        this.name = name;
        this.ATTACK_DAMAGE = ATTACK_DAMAGE;
        this.SPELL_DAMAGE = SPELL_DAMAGE;
        this.health = health;

    }

    public void attack(Fighter fighter) {
        if (fighter instanceof Wizard && ((Wizard) fighter).getShieldStatus()) {
            System.out.println(fighter.getName() + " has absorbed " + getName() + "'s hit!");
            return;
        }
        System.out.println(getName() + "(" + health + ") caused " + ATTACK_DAMAGE + " attack damage to " + fighter.getName() + "(" + fighter.health + ")");
        fighter.suffer(ATTACK_DAMAGE);

    }


    public void cast(Fighter fighter) {
        System.out.println(getName() + "(" + health + ") has hit " + fighter.getName() + "(" + fighter.health + ") with a spell for " + SPELL_DAMAGE + " damage.");
        fighter.suffer(SPELL_DAMAGE);
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void suffer(int damage) {
        health -= damage;
        if(getHealth()<=0) setDeadPrint();
    }

    public boolean printDead() {
        if(isDead() && isDeadPrint) {
            isDeadPrint = false;
            return true;
        }
        return false;
    }
    public void setDeadPrint() {
        isDeadPrint = true;
    }

    public String getName() {
        return name;
}
    public int getHealth() {
        return health;
    }

    public int hundredPercent() {
        return ((int)(Math.random() * 101));
    }


}
