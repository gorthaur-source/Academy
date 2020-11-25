package org.academiadecodigo.tailormoons;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalyzer {










    public long countWords(String filepath) {

        return TextFileReader.readFileGetString(filepath)
             .flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
             .filter(s->s.length()>0).count();
    }



    public String findFirstLongerThan(String filepath, int characters) {

        Optional<String> maybeWord = getWorkableStream(TextFileReader.readFileGetString(filepath)).filter(s-> s.length() > characters).findFirst();

        return maybeWord.orElse("No word satisfying requirements found");

    }


    public Object[] longestNWords(String filepath, int numberOfWords) {

        /*Map<String, Integer> wordFrequency = new TreeMap<>();
        getWorkableStream(stringStream).map(String::toLowerCase).forEach(s -> wordFrequency.put(s, wordFrequency.getOrDefault(s, 0) + 1));
ap<String,Integer> sorted =
                wordFrequency.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(numberOfWords).collect(Collectors.groupingBy()); */

        return getWorkableStream(TextFileReader.readFileGetString(filepath))
                .map(String::toLowerCase)
                .distinct()
                .sorted((string1, string2) -> string2.length() - string1.length())
                .limit(numberOfWords).toArray();

    }



    public Object[] wordsInCommon(String filepath1, String filepath2) {

    }


    public Stream<String> getWorkableStream(Stream <String> stringStream) {
        return stringStream
                .flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
                .filter(s->s.length()>0);
    }



}
