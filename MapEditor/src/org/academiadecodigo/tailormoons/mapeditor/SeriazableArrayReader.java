package org.academiadecodigo.tailormoons.mapeditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SeriazableArrayReader {

    public Node[][] readArray() {

        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NUMBERS.DATA"))) {
            return (Node[][]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
