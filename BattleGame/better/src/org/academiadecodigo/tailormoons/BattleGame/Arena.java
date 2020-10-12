package org.academiadecodigo.tailormoons.BattleGame;

public class Arena {
    Player player1;
    Player player2;
    private boolean gameOver = false;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

    }

    public void battle() {
        int firstAttackCondition = (int) (Math.random() * 101);

    if(player1.lost() || player2.lost()) {
        gameOver = true;
    }

        while (!gameOver) {
            if (firstAttackCondition < 50) {
                System.out.println("\n============NEW ROUND============\n");
                System.out.println(player1.getName() + "'s turn to attack.");
                player1.attack(player2);

                player2.printDeadHero(); // track potential hero death that occurred here

                if (player2.lost()) {
                    System.out.println(player1.getName() + " wins!");
                    break;
                }
                System.out.println(player2.getName() + "'s turn to attack.");
                player2.attack(player1);

                player1.printDeadHero();

                if (player1.lost()) {
                    System.out.println(player2.getName() + " wins!");
                    break;
                }
            } else {
                System.out.println("\n============NEW ROUND============\n");
                System.out.println(player2.getName() + "'s turn to attack.");
                player2.attack(player1);

                player1.printDeadHero();

                if (player1.lost()) {
                    System.out.println(player2.getName() + " wins!");
                    break;
                }
                System.out.println(player1.getName() + "'s turn to attack.");
                player1.attack(player2);

                player2.printDeadHero();

                if (player2.lost()) {
                    System.out.println(player1.getName() + " wins!");
                    break;
                }
            }

        }
        }
    }