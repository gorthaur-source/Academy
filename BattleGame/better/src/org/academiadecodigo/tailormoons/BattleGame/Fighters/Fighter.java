package org.academiadecodigo.tailormoons.BattleGame.Fighters;

import org.academiadecodigo.tailormoons.BattleGame.Items.*;

public  class  Fighter {

    private final String name;
    private int attackDamage;
    private int spellDamage;
    private int health;
    public double damageMultiplier = 1;
    private boolean isDeadPrint = false; //  tracks if fighter death has been printed
    private int effectiveDamage; // effective damage will replace attack/spell damage and adjust to mitigation

    public Fighter(String name, int attackDamage, int spellDamage, int health) {

        this.name = name;
        this.attackDamage = attackDamage;
        this.spellDamage = spellDamage;
        this.health = health;

    }


    public void attack(Fighter opponent) {

        getItem(); // chance of getting random item

        setEffectiveDamage(getAttackDamage());

        if(oppIsWizardHasShield(opponent)) return;

        if(opponent.damageMultiplier!=1) { // if opponent has damage mitigation from items adjust to it

            setEffectiveDamage((int) (getEffectiveDamage()*opponent.damageMultiplier));
        }

        System.out.println(this + " has caused " + getEffectiveDamage() + " attack damage to " + opponent.toString(getEffectiveDamage()));
        opponent.suffer(getEffectiveDamage());

    }


    public void cast(Fighter opponent) {

        getItem();

        setEffectiveDamage(getSpellDamage());

        if(oppIsWizardHasShield(opponent)) return;

        if(opponent.damageMultiplier!=1) {
            setEffectiveDamage((int) (getEffectiveDamage()*opponent.damageMultiplier));
        }

        System.out.println(this + " has caused " + getEffectiveDamage() + " spell damage to " + opponent.toString(getEffectiveDamage()));
        opponent.suffer(getEffectiveDamage());

    }

    public boolean isDead() {
        return health <= 0;
    }

    public void suffer(int damage) {

        health -= damage;
        if (getHealth() <= 0) setDeadPrint(); // fighter hero death to be printed - check printDeadHero on player class
    }

    public boolean printDead() { // tracks death AND if death has been printed or not, if not set isDeadPrint to false and return true
        if (isDead() && isDeadPrint) {
            isDeadPrint = false;
            return true;
        }
        return false;
    }



    public int hundredPercent() {
        return ((int) (Math.random() * 101));
    }
// random number from 0 to 100 for random rolls

    public boolean oppIsWizardHasShield(Fighter opponent) {
// if opponent is wizard and has shield do nothing and set shield to false
        if (opponent instanceof Wizard && ((Wizard) opponent).getShieldStatus()) {
            System.out.println(opponent.getName() + " has absorbed " + getName() + "'s hit!");
            ((Wizard) opponent).setShieldFalse();
            return true;
        }
        return false;
    }
// getters & setters
    public int getEffectiveDamage() {
        return effectiveDamage;
    }

    public void setEffectiveDamage(int effectiveDamage) {
        this.effectiveDamage = effectiveDamage;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getSpellDamage() {
        return spellDamage;
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

    public void setAttackDamage(double multiplier) {
        attackDamage *= multiplier;
    }

    public void setSpellDamage(double multiplier) {
        spellDamage *= multiplier;
    }

    public void setHealth(double adder) {
        health += adder;
    }

    public void setDamageReduction(double reduction) {
        damageMultiplier -= reduction;
    }

    @Override
    public String toString() { // attacker information
        return (getName() + "(" + getHealth() + ")");

    }

    public String toString(int effectiveDamage) { // defender information

        int healthDisplay = health;
        healthDisplay = ((healthDisplay >= effectiveDamage) ? healthDisplay - effectiveDamage : 0);
        return (getName() + "(" + (healthDisplay) + ").");

    }

    public void weaponEffect(Items.Weapons weapon) {

        switch (weapon) {
            case SWORD:
                setAttackDamage(2);
                System.out.println(getName() + " has gained a sword! Its attack goes up to " + attackDamage );
                break;
            case BAYONET:
                setAttackDamage(1.5);
                System.out.println(getName() + " has gained a bayonet! Its attack goes up to " + attackDamage);
                break;
            case QUARTERSTAFF:
                setSpellDamage(2);
                System.out.println(getName() + " has gained a quarterstaff! Its spell damage goes up to " + spellDamage);
                break;
            case WAND:
                setSpellDamage(1.5);
                System.out.println(getName() + " has gained a wand! Its spell damage goes up to " + spellDamage);
        }
    }


    public void armorEffect(Items.Armor armor) {

        switch (armor) {
            case GREATHELM:
                setDamageReduction(0.1);
                System.out.println(getName() + " has gained a greathelm! Its damage reduction goes up!" );
                break;
            case GAUNTLET:
                setHealth(20);
                System.out.println(getName() + " has gained a gauntlet! Its health goes up to " + getHealth());
                break;
            case SABATON:
                setDamageReduction(0.2);
                System.out.println(getName() + " has gained a sabaton! Its damage reduction goes up!" );
                break;
            case PAULDRON:
                setHealth(12);
                System.out.println(getName() + " has gained pauldrons! Its health goes up to " + getHealth());

        }
    }

    public void getItem() {
// chance of getting a random item
        if (hundredPercent()<5) {
            weaponEffect(Items.randomizeWeapon());
        }
        else if(hundredPercent()>95) {
            armorEffect(Items.randomizeArmor());
        }
    }

}
