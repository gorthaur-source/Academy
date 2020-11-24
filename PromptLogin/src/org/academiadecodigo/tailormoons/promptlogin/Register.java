package org.academiadecodigo.tailormoons.promptlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Register implements Action {

    private final Prompt prompt = new Prompt(System.in, System.out);
    private final PasswordInputScanner passwordInputScanner = new PasswordInputScanner();
    private final StringInputScanner userNameQuestion = new StringInputScanner();


    @Override
    public void action() {

        System.out.println("Insert your desired login credentials below");
        userNameQuestion.setMessage("Username: ");
        passwordInputScanner.setMessage("Password:");
        actionValidation();

    }

    @Override
    public void actionValidation() {

        String name = "";
        String password = "";

        name = prompt.getUserInput(userNameQuestion);
        password = prompt.getUserInput(passwordInputScanner);

        while(UserPasswords.containsUser(name)) {
            System.out.println("Username already exists. Please try another one.");
            name = prompt.getUserInput(userNameQuestion);
            password = prompt.getUserInput(passwordInputScanner);
        }
        UserPasswords.addAUser(name, password);
        ChoicePrompt.createEntryMenu();


    }
}
