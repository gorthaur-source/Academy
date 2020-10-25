package org.academiadecodigo.tailormoons.mapeditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NonSerializedReader {


    public List<String> readAndWrite() {

        List<String> lines = new ArrayList<>();

        try (FileReader reader = new FileReader("SavedGridData.txt");
             BufferedReader abc = new BufferedReader(reader);) {

            String line = "";
            while ((line = abc.readLine()) !=null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}