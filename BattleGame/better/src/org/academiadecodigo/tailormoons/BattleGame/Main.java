package org.academiadecodigo.tailormoons.BattleGame;
import org.academiadecodigo.tailormoons.BattleGame.Fighters.*;

public class Main {


    public static void main(String[] args) {

        Fighter[] sidRoster = {
                new Troll("SidTroll"),
                new Gladiator("SidGladiator"),
                new Wizard("SidWizard")
        };

        Fighter[] vandoRoster = {
                new Troll("VandoTroll"),
                new Wizard("VandoWizard"),
                new Gladiator("VandoGladiator"),
        };

        Player Sid = new Player("Sid", sidRoster);
        Player Vando = new Player("Vando", vandoRoster);

        Arena arena = new Arena(Sid, Vando);
        arena.battle();


    }
}
