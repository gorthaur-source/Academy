package org.academiadecodigo.tailormoons.promptlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.util.Map;
import java.util.TreeMap;

public class ChoicePrompt {

    private final Prompt prompt = new Prompt(System.in, System.out);

    public void createMenu() {

        System.out.println("Welcome to your first prompt-view experience.");
        String[] options = {"Login"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What do you want to do?");

        int answerIndex = prompt.getUserInput(scanner);
        System.out.println(answerIndex);
        System.out.println("User wants to " + options[answerIndex - 1]);

        userChoice(answerIndex);
    }

    public void userChoice(int choiceNumber) {

        for(ActionsEnum action : ActionsEnum.values()) {
            if (action.getIdentifier() == choiceNumber) {
                action.getAction().action();
            }
        }
    }


}