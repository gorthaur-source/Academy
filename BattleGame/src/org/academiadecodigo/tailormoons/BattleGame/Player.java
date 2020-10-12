package org.academiadecodigo.tailormoons.BattleGame;

import org.academiadecodigo.tailormoons.BattleGame.Fighters.Fighter;


public class Player {

    private String name;
    private Fighter[] fighters;

    public Player(String name, Fighter[] fighters) {
        this.name = name;
        this.fighters = fighters;
    }

    public void attack(Player player) {
        if (randomFighter().hundredPercent()<50) {
            randomFighter().attack(player.randomFighter());
            return;
        }
        randomFighter().cast(player.randomFighter());
    }

    public boolean lost() {
        return ((fighters[0].isDead()) && (fighters[1].isDead()) && (fighters[2].isDead()));
    }


    public Fighter randomFighter() {

        Fighter randomFighter = fighters[(int) (Math.random() * fighters.length)];
        while (randomFighter.isDead()) {
            randomFighter = fighters[(int) (Math.random() * fighters.length)];
        }
        return randomFighter;
    }


    public void printDeadHero() {

        if (fighters[0].printDead()) {
            System.out.println(fighters[0].getName() + " has perished!");
        }
        else if (fighters[1].printDead()) {
            System.out.println(fighters[1].getName() + " has perished!");
        } else if (fighters[2].printDead()) {
            System.out.println(fighters[2].getName() + " has perished!");
        }
    }

    public String getName() {
        return name;
    }
}
