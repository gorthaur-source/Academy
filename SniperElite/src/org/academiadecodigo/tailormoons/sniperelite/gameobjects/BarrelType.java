package org.academiadecodigo.tailormoons.sniperelite.gameobjects;

public enum BarrelType {

    STEEL("Steel",200),
    WOOD("Wood",75),
    PVC("PVC",90),
    PlASTIC("Plastic",50);

    private final int maxDamage;
    private final String name;

    BarrelType(String name, int hitPoints) {
        this.name = name;
        this.maxDamage = hitPoints;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public String getName() {
        return name;
    }

}


