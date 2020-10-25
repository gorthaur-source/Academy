package org.academiadecodigo.tailormoons.mapeditor;

import java.io.*;

public class SeriazableArrayWriter implements Serializable {

    public static void write (Node[][] data) {

        try( FileOutputStream writer = new FileOutputStream("NUMBERS.DATA");
             ObjectOutputStream oos = new ObjectOutputStream(writer))
        {
            oos.writeObject(data);
            System.out.println("data written");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
