package org.academiadecodigo.tailormoons.ArabianNights.genies;

public class GrumpyGenie extends Genie {


    public GrumpyGenie(int limit) {
        super(limit); //
    }

    @Override
    public boolean canItGrant() {
        return super.getGrantedWishes() == 0;
    }

    @Override
    public void printNotGrantedMessage() {
        System.out.println("No wishes left. Begone. " + this + " out.");

}
    @Override
    public void printGrantedMessage() {
        System.out.println("Your wish is granted. Beware, there won't be a next one. " + this + " signing out.");

    }
    @Override

    public String toString() {

        return "Grumpy Genie";

    }


}




