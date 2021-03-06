package org.academiadecodigo.tailormoons.promptlogin;

public enum ActionsEnum {

    LOGIN(1, new Login()),
    REGISTER(2, new Register()),
    EXIT(3, new Exit());


    private final int identifier;
    private final Action action;

     ActionsEnum(int identifier, Action action) {
         this.identifier = identifier;
         this.action = action;
    }

    public int getIdentifier() {
         return identifier;
    }

    public Action getAction() {
        return action;
    }

}
