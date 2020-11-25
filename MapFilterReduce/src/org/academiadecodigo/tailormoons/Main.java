package org.academiadecodigo.tailormoons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {


        String message = "I'll send an SOS to the Garbage, world, I hope that someone garbage gets my message in a garbage bottle.";

        String[] messages = message.split(" ");
        String modifiedString = Stream.of(messages).map(String::toUpperCase).
                filter(string -> !string.contains("GARBAGE")).
                reduce("", (sentence, word) -> sentence + " " + word);

        // System.out.println(modifiedString);

        String sentence = "";
        for (String s : messages) {
            if (!s.toUpperCase().contains("GARBAGE")) {
                sentence += " " + s.toUpperCase();
            }
        }
        System.out.println(sentence);
    }
}