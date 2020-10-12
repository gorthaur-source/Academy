package org.academiadecodigo.tailormoons.sniperelite;

public enum BarrelType {

    STEEL("Steel",200),
    WOOD("Wood",75),
    PVC("PVC",90),
    PlASTIC("Plastic",50);

    private int hitPoints;
    private String name;

    BarrelType(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getName() {
        return name;
    }

}


