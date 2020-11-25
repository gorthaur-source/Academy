package org.academiadecodigo.tailormoons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TextFileReader {

    private static Stream<String> stringStream;


    public static Stream<String> readFileGetString(String filepath) {

        Path path = Path.of(filepath);

        try {
            stringStream = Files.lines(path);
            return Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringStream;
    }

}
