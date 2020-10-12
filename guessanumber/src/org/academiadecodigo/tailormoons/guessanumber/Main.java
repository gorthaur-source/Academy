package org.academiadecodigo.tailormoons.guessanumber;

import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
      Game game = new Game();

      String[] playerNames = {"João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno"};
      int playerNumber = 16;
      Player[] players1 = new Player[playerNumber];
      for (int i = 0; i < playerNumber; i++) {
         players1[i] = new Player(playerNames[i]);
         //players[i].setName(playerNames[i]);
      }

         Player[] players = new Player[4];
         players[0] = new Player("Elodie", false);
         players[1] = new Player("João", true);
         players[2] = new Player("André", true);
         players[3] = new Player("Edgar", true);
         // Game.start(players);
         game.start(players1);




   }
   }



