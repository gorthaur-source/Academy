package org.academiadecodigo.tailormoons.ArabianNights.genies;

public class FriendlyGenie extends Genie {

    public FriendlyGenie(int limit) {
        super(limit);
    }

    @Override
    public void printGrantedMessage() {
        System.out.println((this + " grants you a wish. He's already granted " + super.getGrantedWishes() + " of them and has " + getRemainWishes() + " left to give."));
    }

    @Override
    public void printNotGrantedMessage() {
        System.out.println(this + " can't grant anymore wishes. He's dried up after granting " + super.getGrantedWishes() + " of them.");

    }

    public int getRemainWishes() {
        return super.getLimit() - super.getGrantedWishes();

    }

    @Override

    public String toString() {

        return "Friendly Genie";

    }

}
