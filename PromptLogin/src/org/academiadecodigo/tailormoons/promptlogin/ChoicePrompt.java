package org.academiadecodigo.tailormoons.promptlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.util.Map;
import java.util.TreeMap;

public class ChoicePrompt {

    private static final Prompt prompt = new Prompt(System.in, System.out);

    public static void createEntryMenu() {

        System.out.println("Welcome to our platform.");
        String[] options = {"Login", "Register", "Exit"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What do you want to do?");

        int answerIndex = prompt.getUserInput(scanner);
        System.out.println(answerIndex);
        System.out.println("User wants to " + options[answerIndex - 1]);

        userChoice(answerIndex);
    }

    public static void userChoice(int choiceNumber) {

        for(ActionsEnum action : ActionsEnum.values()) {
            if (action.getIdentifier() == choiceNumber) {
                action.getAction().action();
            }
        }
    }


}