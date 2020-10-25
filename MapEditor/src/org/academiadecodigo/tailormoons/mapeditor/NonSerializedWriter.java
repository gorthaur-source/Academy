package org.academiadecodigo.tailormoons.mapeditor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NonSerializedWriter {

    public void write(String data) {
        try (PrintWriter out = new PrintWriter("SavedGridData.txt")) {
            if(data != null && data.trim().length()!=0) {
                out.println(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}