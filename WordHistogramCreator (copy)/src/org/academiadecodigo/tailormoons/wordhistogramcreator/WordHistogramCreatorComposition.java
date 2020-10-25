package org.academiadecodigo.tailormoons.wordhistogramcreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordHistogramCreatorComposition implements Iterable<String> {


    private final Map<String, Integer> wordMap;
    private String sentence;

    public WordHistogramCreatorComposition() {
        this.wordMap = new HashMap<>();
    }

    public void addToHash(String sentence) {

        this.sentence = sentence.toLowerCase();

        String[] stringArray = this.sentence.split("[\\p{Punct}\\s]+");

        for (String s : stringArray) {
            wordMap.merge(s, 1, Integer::sum);
        }
    }

    public void printStuff() {

        for (String s : this) {
            System.out.println(s + " " + getValue(s));

        }


    }

    public int getValue(String key) {
        return wordMap.get(key);

    }


    @Override
    public Iterator<String> iterator() {
        return wordMap.keySet().iterator();
    }

    public String toString() {
        return "" + wordMap.keySet() + " " + wordMap.values();
    }

}
