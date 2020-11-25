package org.academiadecodigo.tailormoons;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.tailormoons.controller.LoginController;
import org.academiadecodigo.tailormoons.controller.MainController;
import org.academiadecodigo.tailormoons.controller.UserDetailsController;
import org.academiadecodigo.tailormoons.controller.UserListController;
import org.academiadecodigo.tailormoons.model.User;
import org.academiadecodigo.tailormoons.persistence.ConnectionManager;
import org.academiadecodigo.tailormoons.service.MockUserService;
import org.academiadecodigo.tailormoons.service.UserService;
import org.academiadecodigo.tailormoons.service.UserServiceImpl;
import org.academiadecodigo.tailormoons.utils.Security;
import org.academiadecodigo.tailormoons.view.LoginView;
import org.academiadecodigo.tailormoons.view.UserDetailsView;
import org.academiadecodigo.tailormoons.view.UserListView;
import org.academiadecodigo.tailormoons.view.MainView;

public class App {

    public static void main(String[] args) {


        LoginController loginController = new LoginController();
        MainController mainController = new MainController();
        UserListController userListController = new UserListController();
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        UserListView userListView = new UserListView();
        UserDetailsController userDetailsController = new UserDetailsController();
        UserDetailsView userDetailsView = new UserDetailsView();
        Prompt prompt = new Prompt(System.in, System.out);


        UserService userService = new UserServiceImpl();
        ConnectionManager connectionManager = new ConnectionManager("root", "");
        userService.setConnectionManager(connectionManager);
        userService.add(new User("rui", "ferrao@academiadecodigo.org", Security.getHash("academiadecodigo"),
                "Rui", "Ferrão", "912345678"));
        userService.add(new User("faustino", "faustino@academiadecodigo.org", Security.getHash("academiadecodigo"),
                "João", "Faustino", "966666666"));
        userService.add(new User("audrey", "audrey@academiadecodigo.org", Security.getHash("academiadecodigo"),
                "Audrey", "Lopes", "934567890"));

        // Wire login controller and view
        loginView.setPrompt(prompt);
        loginView.setController(loginController);
        loginController.setUserService(userService);
        loginController.setView(loginView);
        loginController.setNextController(mainController);

        // Wire main controller and view
        mainView.setPrompt(prompt);
        mainView.setController(mainController);
        mainController.setView(mainView);
        mainController.setUserListController(userListController);
        mainController.setUserDetailsController(userDetailsController);

        // Wire userList controller and view
        userListView.setPrompt(prompt);
        userListView.setController(userListController);
        userListController.setUserService(userService);
        userListController.setView(userListView);

        // Wire userDetails controller and view
        userDetailsView.setPrompt(prompt);
        userDetailsView.setController(userDetailsController);
        userDetailsController.setUserService(userService);
        userDetailsController.setView(userDetailsView);


        // Start APP
        loginController.init();
        connectionManager.close();


    }
}
