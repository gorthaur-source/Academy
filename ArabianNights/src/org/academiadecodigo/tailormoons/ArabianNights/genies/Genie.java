package org.academiadecodigo.tailormoons.ArabianNights.genies;

public abstract class  Genie {

    private int wishLimit;
    private int grantedWishes;


    public Genie(int limit) {
        this.wishLimit = limit;
    }

    public boolean makeAWish() {
        if(!canItGrant()) {
            printNotGrantedMessage();
            return false;
        }
        grantedWishes++;
        printGrantedMessage();
        return true;
    }

    public boolean canItGrant() {
        return wishLimit > grantedWishes;

    }

    public abstract void printGrantedMessage();

    public abstract void printNotGrantedMessage();

    public int getGrantedWishes() {
        return grantedWishes;
    }

    public int getLimit() {
        return wishLimit;
    }

}
