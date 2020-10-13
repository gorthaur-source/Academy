package org.academiadecodigo.tailormoons.exceptions;

import org.academiadecodigo.tailormoons.exceptions.exceptions.FileNotFoundException;
import org.academiadecodigo.tailormoons.exceptions.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.tailormoons.exceptions.exceptions.NotEnoughSpaceException;

public class Main {

    public static void main(String[] args){

        FileManager fileManager = new FileManager();

       fileManager.login();
       // fileManager.logout();

        for(int i = 0; i<10; i++) {
            try {
                fileManager.createFile("" + i);
            } catch (NotEnoughPermissionsException | NotEnoughSpaceException e) {
                System.out.println(e.getMessage());
            }
        }


        try {
            fileManager.createFile("Batata");
        } catch (NotEnoughPermissionsException | NotEnoughSpaceException e) {
            System.out.println(e.getMessage()); // prints the exception message
        }


        try {
            fileManager.getFile("5");
        } catch (NotEnoughPermissionsException | FileNotFoundException e ) {
            System.out.println(e.getMessage()); // prints the exception message
        }


    }
}
