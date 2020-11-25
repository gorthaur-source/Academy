package org.academiadecodigo.tailormoons;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        Stream<String> stringStream = TextFileReader.readFileGetString("Toyota");
        Stream<String> stringStream1 = TextFileReader.readFileGetString("Toyota");


        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        //System.out.println(fileAnalyzer.countWords(stringStream));
        System.out.println(Arrays.toString(fileAnalyzer.longestNWords("Toyota", 5)));
        System.out.println(fileAnalyzer.findFirstLongerThan("Toyota", 6));
    }
}
