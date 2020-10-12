package org.academiadecodigo.tailormoons.sniperelite;
import org.academiadecodigo.tailormoons.sniperelite.gameobjects.*;

public class Game {


    private GameObject[] gameObjects;
    private final SniperRifle sniperRifle = new SniperRifle(50);
    private int shotsFired;
    private int mictsGiven;

    public void start(int numberOfObjects) {

        gameObjects = createObjects(numberOfObjects);

        for (GameObject gameObject : gameObjects) {
            System.out.println(gameObject.getMessage());

            if((gameObject instanceof Mictable)) {
                sniperRifle.mictate((Mictable) gameObject);
                mictsGiven++;
            }
            if ((gameObject instanceof Shootable)) {
                while ( !((Shootable) gameObject).isDestroyed()) {
                    sniperRifle.shoot((Shootable) gameObject);
                    shotsFired++;
                }
            }
        }
        System.out.println("All enemies and barrels destroyed. Trees and barrels were micted. It took me " + shotsFired + " shots(missed " + sniperRifle.getMissedShots() + " of them) and " + mictsGiven + " micts.");
    }
    private GameObject[] createObjects(int numberObjects) {

        GameObject[] gameObjectss = new GameObject[numberObjects];

        for (int i = 0; i < gameObjectss.length; i++) {

            int zeroToHundred = (int) (Math.random() * 101);

            if (zeroToHundred < 25) {
                gameObjectss[i] = new EnemySoldier(80);

            } else if (zeroToHundred < 45) {
                gameObjectss[i] = new ArmouredEnemy(100, 75);

            } else if (zeroToHundred < 75){
                gameObjectss[i] = new Tree();

            } else {
                gameObjectss[i] = new Barrel();
            }
        }
        return gameObjectss;
    }
}


