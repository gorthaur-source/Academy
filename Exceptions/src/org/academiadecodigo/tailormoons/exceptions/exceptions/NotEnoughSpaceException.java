package org.academiadecodigo.tailormoons.exceptions.exceptions;

import javax.annotation.processing.FilerException;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException(String filename) {
        super("Not enough space for " + filename + ".");
    }
}
