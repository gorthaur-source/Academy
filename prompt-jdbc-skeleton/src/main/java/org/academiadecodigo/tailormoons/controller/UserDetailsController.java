package org.academiadecodigo.tailormoons.controller;

import org.academiadecodigo.tailormoons.model.User;

public class UserDetailsController extends AbstractController {


    public User getUser(String username) {
        return userService.findByName(username);
    }
}
