package org.academiadecodigo.tailormoons.ArabianNights.genies;

public class ConsumableDemon extends Genie {

    private boolean wasConsumed;

    public ConsumableDemon(int limit) {
        super(limit); // this is meaningless as canItGrant won't involve this variable
        wasConsumed = false;
    }

    @Override
    public boolean canItGrant() {
        return !wasConsumed;
    }


    @Override
    public void printGrantedMessage() {
        if(wasConsumed) {
            System.out.println("This demon has already been consumed. It is useless. Long live the lamp!");
        }
    }

    @Override
    public void printNotGrantedMessage() {
        System.out.println("Your wish is now granted. I've granted " + super.getGrantedWishes() + " wishes so far. " + this + " signing out.");
    }

    public boolean getConsumedStatus() {
        return wasConsumed;
    }

    public void setConsumedStatus() {
        wasConsumed = true;
    }

    @Override

    public String toString() {

        return "Consumable Demon";

    }

}
