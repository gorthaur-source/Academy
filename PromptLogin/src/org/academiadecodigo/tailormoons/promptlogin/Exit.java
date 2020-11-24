package org.academiadecodigo.tailormoons.promptlogin;

public class Exit implements Action {
    @Override
    public void action() {
        System.out.println("Goodbye!");
        System.exit(1);
    }

    @Override
    public void actionValidation() {

    }
}
