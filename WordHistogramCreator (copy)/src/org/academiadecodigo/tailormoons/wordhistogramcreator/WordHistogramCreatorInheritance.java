package org.academiadecodigo.tailormoons.wordhistogramcreator;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramCreatorInheritance extends HashMap<String, Integer> implements Iterable<String> {

    private String sentence;


    public void addToHash(String sentence) {

        this.sentence = sentence.toLowerCase();

        String[] stringArray = this.sentence.split("[\\p{Punct}\\s]+");

        for (String s : stringArray) {
            merge(s, 1, Integer::sum);
        }
    }

    public void printStuff() {

        for (String s : this) {
            System.out.println(s + " " + getValue(s));

        }


    }

    public int getValue(String key) {
        return get(key);

    }


    @Override
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    public String toString() {
        return "" + keySet() + " " + values();
    }

}

