package org.academiadecodigo.tailormoons.sniperelite.gameobjects;

public class Barrel extends GameObject implements Shootable, Mictable {

    private final BarrelType barrelType;
    private boolean isDestroyed;
    private int currentDamage;

    public Barrel() {
        barrelType = BarrelType.values()[(int) (Math.random() * BarrelType.values().length)];
    }

    @Override
    public void hit(int shotDamage) {

         currentDamage += shotDamage;

        if (currentDamage >= barrelType.getMaxDamage()) {
            isDestroyed = true;
            System.out.println(this + " barrel has been destroyed");
        }
    }

    @Override
    public String mictOnIt() {
        return "Successfully mictated on " + this + " barrel.";
    }

    @Override
    public String getMessage() {
        return ("It's a " + this + " barrel.");
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }


    public String toString() {
        return barrelType.getName();
    }

}