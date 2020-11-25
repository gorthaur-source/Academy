package org.academiadecodigo.tailormoons.view;

import org.academiadecodigo.tailormoons.controller.MainController;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MainView extends AbstractView {

    private MainController controller;

    public void show() {
        showMenu();
    }

    private void showMenu() {

        String[] options = {"Show users", "Show user details", "Quit"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("\nChoose an option: ");

        int answerIndex = prompt.getUserInput(scanner);
        controller.onMenuSelection(answerIndex);
    }


    public void setController(MainController controller) {
        this.controller = controller;
    }
}
