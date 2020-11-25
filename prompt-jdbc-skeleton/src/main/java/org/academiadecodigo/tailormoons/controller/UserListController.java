package org.academiadecodigo.tailormoons.controller;

import org.academiadecodigo.tailormoons.model.User;

import java.util.List;

public class UserListController extends AbstractController {

    public List<User> getUserList() {
        return userService.findAll();
    }

}
