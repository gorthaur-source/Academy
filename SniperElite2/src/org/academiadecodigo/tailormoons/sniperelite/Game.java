package org.academiadecodigo.tailormoons.sniperelite;

public class Game {


    private GameObject[] gameObjects;
    private SniperRifle sniperRifle = new SniperRifle(50);
    private int shotsFired;



    public void Start(int numberOfObjects) {

        createObjects(numberOfObjects);

        for (GameObject gameObject : gameObjects) {
            System.out.println(gameObject.getMessage());

            if ((gameObject instanceof Enemy)) {
                while ( !((Enemy) gameObject).isDead()) {
                    sniperRifle.shoot((Enemy) gameObject);
                    shotsFired++;
                }
            }
        }
        System.out.println("Took me " + shotsFired + ".");
    }
    private GameObject[] createObjects(int numberObjects) {

        gameObjects = new GameObject[numberObjects];

        for (int i = 0; i < gameObjects.length; i++) {

            int zeroToHundred = (int) (Math.random() * 101);

            if (zeroToHundred < 40) {
                gameObjects[i] = new EnemySoldier(80);

            } else if (zeroToHundred < 75) {
                gameObjects[i] = new ArmouredEnemy(100, 75);

            } else {
                gameObjects[i] = new Tree();
            }
        }
        return gameObjects;
    }
}


