package org.academiadecodigo.tailormoons.exceptions;

import org.academiadecodigo.tailormoons.exceptions.exceptions.FileNotFoundException;
import org.academiadecodigo.tailormoons.exceptions.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.tailormoons.exceptions.exceptions.NotEnoughSpaceException;

public class FileManager {

    private boolean isLoggedIn = false;
    private File file;
    public static final int MAX_FILE_NUMBER = 10;
    File[] fileArray = new File[MAX_FILE_NUMBER];


    public void login() {
        isLoggedIn = true;
        System.out.println("Successfully logged in.");
    }


    public void logout() {
        isLoggedIn = false;
        System.out.println("Successfully logged out.");
    }

    public void createFile(String name) throws NotEnoughPermissionsException, NotEnoughSpaceException {

        if (!isLoggedIn) {
            throw new NotEnoughPermissionsException(name);
        }
        for(int i = 0; i < fileArray.length; i++) {
            if(fileArray[i] == null) {
                file = new File(name);
                fileArray[i] = file;
                System.out.println("File " + name + " created.");
                return;
                }
            }
            throw new NotEnoughSpaceException(name);
    }

    public void getFile(String name) throws NotEnoughPermissionsException, FileNotFoundException {

        if (!isLoggedIn) {
            throw new NotEnoughPermissionsException(name);
        }
        else if (file == null) {
            throw new FileNotFoundException(name);
        }
        else if (!file.getName().equals(name)) {
            throw new FileNotFoundException(name);
        }
            System.out.println("File " + name + " loaded.");

    }
}
