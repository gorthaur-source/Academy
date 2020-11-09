package org.academiadecodigo.tailormoons.promptlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Login implements Action {

    private final Prompt prompt = new Prompt(System.in, System.out);
    private final PasswordInputScanner passwordInputScanner = new PasswordInputScanner();
    private final StringInputScanner userNameQuestion = new StringInputScanner();


    public Login() {
    }

    public void action() {

        System.out.println("Insert your login credentials below");
        userNameQuestion.setMessage("Username: ");
        passwordInputScanner.setMessage("Password:");
        actionValidation();

    }

    public void actionValidation() {

        String name = "";
        String password = "";

        for(int passwordAttempts = 2; passwordAttempts >= 0; passwordAttempts--) {

            name = prompt.getUserInput(userNameQuestion);
            password = prompt.getUserInput(passwordInputScanner);

            if(UserPasswords.isLegitUser(name, password)) {
                System.out.println("Login successful!");
                System.out.println("Welcome home, " + name + "!");
                return;
            }
            if(passwordAttempts == 0) break;
            System.out.println("Incorrect input! You have " + passwordAttempts + " remaining attempts.");
        }
        System.out.println("You have made too many incorrect inputs. Shutting process down.");



    }
}