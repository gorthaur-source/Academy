package org.academiadecodigo.tailormoons.ArabianNights;

import org.academiadecodigo.tailormoons.ArabianNights.genies.ConsumableDemon;
import org.academiadecodigo.tailormoons.ArabianNights.genies.Genie;

public class Main {


    public static void main(String[] args) {

        MagicLamp testlamp = new MagicLamp(4);
        Genie genie1 = testlamp.rub(6);
        Genie genie2 = testlamp.rub(2);
        Genie genie3 = testlamp.rub(4);
        Genie genie4 = testlamp.rub(3);
        Genie genie5 = testlamp.rub(2);
        Genie genie6 = testlamp.rub(10);

        for (int i = 0; i < 2; i++) {
            genie1.makeAWish();
        }

        for (int i = 0; i < 7; i++) {
            genie2.makeAWish();
        }

        for (int i = 0; i < 3; i++) {
            genie3.makeAWish();
        }

        for (int i = 0; i <6; i++) {
            genie4.makeAWish();
        }

        for (int i = 0; i <6; i++) {
            genie5.makeAWish();
        }

        MagicLamp testlamp1 = new MagicLamp(10);

        testlamp.equals(testlamp1);

        testlamp.feedDemon((ConsumableDemon) genie5);

        testlamp.rub(3);
        System.out.println(testlamp.getRubs());

    }
}
