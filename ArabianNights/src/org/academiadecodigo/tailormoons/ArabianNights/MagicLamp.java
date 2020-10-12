package org.academiadecodigo.tailormoons.ArabianNights;

import org.academiadecodigo.tailormoons.ArabianNights.genies.ConsumableDemon;
import org.academiadecodigo.tailormoons.ArabianNights.genies.FriendlyGenie;
import org.academiadecodigo.tailormoons.ArabianNights.genies.Genie;
import org.academiadecodigo.tailormoons.ArabianNights.genies.GrumpyGenie;

public class MagicLamp {

    private int rubLimit;
    private int demonsConsumed;
    private int rubs;
    private boolean demonGenerated;

    public MagicLamp(int rubLimit) {
        this.rubLimit = rubLimit;
    }


    public Genie rub(int wishesLimit) {

        if (rubLimit > rubs) {
            rubs++;

            if (rubs % 2 == 0) {
                System.out.println("Hello. I'm the Friendly Genie. You have " + wishesLimit + " wishes");
                return new FriendlyGenie(wishesLimit);
            }
            System.out.println("Grumpy Genie here. Make your wish and leave.");
            return new GrumpyGenie(wishesLimit); // redundant?
        } else if (demonGenerated) {
            System.out.println("Dude this lamp is dried up. You need to consume the demon to recharge it");
        } else {
            System.out.println("We're out of rubs! Beware the Consumable Demon!");
            demonGenerated = true;
            return new ConsumableDemon(wishesLimit);
        }
        return null; // won't get to this
    }

    public void feedDemon(ConsumableDemon identifier) {

        if(!identifier.getConsumedStatus()) {

            identifier.setConsumedStatus();
            rubs = 0; // reset rubs since last recharge
            demonsConsumed++;
            System.out.println("Lamp reactivated. Demon consumed.");
        }

    }

    public int getNrGenies() {
        return (rubLimit - rubs);
    }

    public int getDemonsConsumed() {
        return demonsConsumed;
    }


    public int getRubs() {
        return rubs;
    }

    public int getLimit() {
        return rubLimit;
    }

    @Override
    public boolean equals(Object object) {
        if((object instanceof MagicLamp) && (((MagicLamp) object).getLimit() == getLimit() && ((MagicLamp) object).getDemonsConsumed() == getDemonsConsumed() && ((MagicLamp) object).getNrGenies() == getNrGenies()))
        {
            System.out.println("Uncanny! They are clones!");
            return true;
        }
        System.out.println("Nah. These lamps are nothing alike.");
        return false;
        }
    }

    /* Deprecated

    public boolean isEqual(MagicLamp toCompare) {
        if (getLimit() == toCompare.getLimit() && getDemonsConsumed() == toCompare.getDemonsConsumed() && getNrGenies() == toCompare.getNrGenies()) {
            System.out.println("Uncanny! They are clones!");
            return true;
        }
        System.out.println("Nah. These lamps are nothing alike.");
        return false;
    }
*/
