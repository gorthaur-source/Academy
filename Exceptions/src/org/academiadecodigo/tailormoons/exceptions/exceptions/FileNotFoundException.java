package org.academiadecodigo.tailormoons.exceptions.exceptions;


public class FileNotFoundException extends FileException {

    public FileNotFoundException(String filename) {
        super("File " + filename + " not found.");
    }
}
