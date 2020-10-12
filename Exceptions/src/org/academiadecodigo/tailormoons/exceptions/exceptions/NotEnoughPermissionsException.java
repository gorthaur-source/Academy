package org.academiadecodigo.tailormoons.exceptions.exceptions;

import javax.annotation.processing.FilerException;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException(String filename) {
        super("You haven't logged in. You can't access " + filename);
    }
}
