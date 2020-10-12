package org.academiadecodigo.tailormoons.sniperelite;

public class Barrel extends GameObject {

    private BarrelType barrelType;
    private boolean isDestroyed;
    private int hitPoints;

    public Barrel() {
        barrelType = BarrelType.values()[(int) (Math.random() * BarrelType.values().length)];
        this.hitPoints = barrelType.getHitPoints();
    }

    public void hit(int shotDamage) {

        if(shotDamage >= barrelType.getHitPoints()) {
            isDestroyed = true;
            System.out.println("Barrel destroyed!");
        } else {
            hitPoints -= shotDamage;
        }
    }

    @Override
    public String getMessage() {
       return ("It's a " + barrelType.getName() + " barrel.");
    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }
}


